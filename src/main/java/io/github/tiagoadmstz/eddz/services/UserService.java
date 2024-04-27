package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.dtos.UserDto;
import io.github.tiagoadmstz.eddz.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Map<String, String> lines = new HashMap<>(1);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.lines.put("DDZL7", "L07");
        this.lines.put("DDZL8", "L08");
        this.lines.put("DDZL9", "L09");
    }

    public String findUserLine(String ddzLine) {
        return lines.getOrDefault(ddzLine, "L");
    }

    public List<UserDto> list() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }
}
