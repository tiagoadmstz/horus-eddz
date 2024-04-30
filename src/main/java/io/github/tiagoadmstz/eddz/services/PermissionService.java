package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.Permission;
import io.github.tiagoadmstz.eddz.dtos.PermissionDto;
import io.github.tiagoadmstz.eddz.repositories.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public List<String> listByUserId(Long userId) {
        return permissionRepository.findByUserId(userId).stream()
                .map(Permission::getUserPermission)
                .collect(Collectors.toList());
    }

    public PermissionDto save(final PermissionDto permissionDto) {
        return new PermissionDto(permissionRepository.save(new Permission(permissionDto)));
    }

    public List<PermissionDto> saveAll(List<PermissionDto> permissionDto) {
        final List<Permission> permissionList = permissionDto.stream().map(Permission::new).collect(Collectors.toList());
        return permissionRepository.saveAll(permissionList).stream().map(PermissionDto::new).collect(Collectors.toList());
    }

    public void deleteByUserId(final Long userId) {
        permissionRepository.deleteByUserId(userId);
    }
}
