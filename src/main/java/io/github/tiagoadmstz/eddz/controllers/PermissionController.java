package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.PermissionDto;
import io.github.tiagoadmstz.eddz.services.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/security")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("save")
    public ResponseEntity<PermissionDto> save(@RequestBody PermissionDto permissionDto) {
        return ResponseEntity.ok(permissionService.save(permissionDto));
    }

    @PostMapping("saveAll")
    public ResponseEntity<List<PermissionDto>> saveAll(@RequestBody List<PermissionDto> permissionDto) {
        return ResponseEntity.ok(permissionService.saveAll(permissionDto));
    }
}
