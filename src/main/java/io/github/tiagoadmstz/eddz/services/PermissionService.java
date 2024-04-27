package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.Permission;
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
}
