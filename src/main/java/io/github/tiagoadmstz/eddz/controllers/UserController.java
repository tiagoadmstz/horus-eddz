package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.UserDto;
import io.github.tiagoadmstz.eddz.services.PermissionService;
import io.github.tiagoadmstz.eddz.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PermissionService permissionService;

    public UserController(
            UserService userService,
            PermissionService permissionService
    ) {
        this.userService = userService;
        this.permissionService = permissionService;
    }

    @GetMapping("line/{ddzLine}")
    public ResponseEntity<String> line(@PathVariable String ddzLine) {
        return ResponseEntity.ok(userService.findUserLine(ddzLine));
    }

    @GetMapping("permissions/{userId}")
    public ResponseEntity<List<String>> listPermissions(@PathVariable Long userId) {
        return ResponseEntity.ok(permissionService.listByUserId(userId));
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDto>> list() {
        return ResponseEntity.ok(userService.list());
    }
}
