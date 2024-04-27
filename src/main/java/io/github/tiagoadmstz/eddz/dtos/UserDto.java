package io.github.tiagoadmstz.eddz.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.eddz.domains.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class UserDto implements Serializable {

    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("login")
    private String username;
    @JsonProperty("senha")
    private String password;
    @JsonProperty("setor")
    private String sector;
    @JsonProperty("planta")
    private String plant;
    @JsonProperty("sobrenome")
    private String lastname;
    @JsonProperty("email")
    private String email;

    public UserDto(final User user) {
        id = user.getId();
        name = user.getName();
        username = user.getUsername();
        password = user.getPassword();
        sector = user.getSector();
        plant = user.getPlant();
        lastname = user.getLastname();
        email = user.getEmail();
    }
}
