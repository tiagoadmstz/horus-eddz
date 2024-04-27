package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.User;
import io.github.tiagoadmstz.eddz.dtos.UserDto;
import io.github.tiagoadmstz.eddz.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDto> authentication(final UserDto userDto) {
        final Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
        if (optionalUser.isEmpty() || !new BCryptPasswordEncoder().matches(userDto.getPassword(), optionalUser.get().getPassword())) {
            return Optional.empty();
        }
        return Optional.of(new UserDto(optionalUser.get()));
    }
}
