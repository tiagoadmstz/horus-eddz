package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.UserDto;
import io.github.tiagoadmstz.eddz.services.PermissionService;
import io.github.tiagoadmstz.eddz.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("permissions/delete/{userId}")
    public void deletePermissions(@PathVariable Long userId) {
        permissionService.deleteByUserId(userId);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDto>> list() {
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
