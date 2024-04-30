package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.Permission;
import io.github.tiagoadmstz.eddz.domains.User;
import io.github.tiagoadmstz.eddz.dtos.UserDto;
import io.github.tiagoadmstz.eddz.repositories.PermissionRepository;
import io.github.tiagoadmstz.eddz.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Map<String, String> lines = new HashMap<>(1);
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    public UserService(
            UserRepository userRepository,
            PermissionRepository permissionRepository
    ) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
        this.lines.put("DDZL7", "L07");
        this.lines.put("DDZL8", "L08");
        this.lines.put("DDZL9", "L09");
    }

    public String findUserLine(final String ddzLine) {
        return lines.getOrDefault(ddzLine, "L");
    }

    public List<UserDto> list() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public UserDto findById(final Long id) {
        return userRepository.findById(id).map(UserDto::new).orElse(new UserDto());
    }

    public UserDto save(final UserDto userDto) {
        permissionRepository.findByUserId(userDto.getId()).stream()
                .filter(permission -> !userDto.getPermissions().contains(permission))
                .forEach(permissionRepository::delete);
        boolean encryptPassword = true;
        if (Objects.nonNull(userDto.getId()) && StringUtils.isEmpty(userDto.getPassword())) {
            userDto.setPassword(userRepository.findPasswordById(userDto.getId()));
            encryptPassword = false;
        }
        final User userSaved = userRepository.save(new User(userDto, encryptPassword));
        updatePermissionsUserId(userSaved);
        return new UserDto(userSaved);
    }

    private void updatePermissionsUserId(User user) {
        List<Permission> permissions = user.getPermissions();
        if (Objects.nonNull(permissions) && !permissions.isEmpty()) {
            permissions.forEach(permission -> permission.setUserId(user.getId()));
            permissionRepository.saveAll(permissions);
        }
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }
}
