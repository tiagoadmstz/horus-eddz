package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.UserDto;
import io.github.tiagoadmstz.eddz.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/security")
public class SecurityController {

    private final AuthenticationService authenticationService;

    public SecurityController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authentication")
    public ResponseEntity<UserDto> authentication(@RequestBody UserDto userDto) {
        final Optional<UserDto> optionalUserDto = authenticationService.authentication(userDto);
        return optionalUserDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
