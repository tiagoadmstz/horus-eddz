package io.github.tiagoadmstz.eddz.domains;

import io.github.tiagoadmstz.eddz.dtos.UserDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cad_Usuario")
@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @Column(name = "PK_ID")
    private Long id;
    @Column(name = "LOGIN", length = 50, nullable = false, unique = true)
    private String username;
    @Column(name = "SENHA", length = 50, nullable = false)
    private String password;
    /**
     * DDZL4=L04;DDZL6=L06;DDZL7=L07;DDZL8=L08;DDZL9=L09;DDZL11=L11;DDZL12=L12;
     * DDZL17=L17;DDZL19=L19;DDZL27=L27;DDZL26=L26;DDZL28=L28;
     */
    @Column(name = "NOME", length = 100, nullable = false)
    private String name;
    @Column(name = "SETOR", length = 50)
    private String sector;
    @Column(name = "SOBRE_NOME", length = 80)
    private String lastname;
    /**
     * Varginha, Atibaia
     */
    @Column(name = "PLANTA", length = 50)
    private String plant;
    @Column(name = "EMAIL", length = 255)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Permission> permissions;
    @Transient
    private List<String> authorities;
    @Transient
    private boolean accountNonExpired = true;
    @Transient
    private boolean accountNonLocked = true;
    @Transient
    private boolean credentialsNonExpired = true;
    @Transient
    private boolean enabled = true;

    public User(UserDto userDto, boolean encriptPassword) {
        id = userDto.getId();
        username = userDto.getUsername();
        if (!StringUtils.isEmpty(userDto.getPassword())) {
            if (encriptPassword) {
                password = new BCryptPasswordEncoder().encode(userDto.getPassword());
            } else {
                password = userDto.getPassword();
            }
        }
        name = userDto.getName();
        sector = userDto.getSector();
        lastname = userDto.getLastname();
        plant = userDto.getPlant();
        email = userDto.getEmail();
        if (Objects.nonNull(userDto.getPermissions())) {
            permissions = userDto.getPermissions().stream()
                    .map(Permission::new)
                    .collect(Collectors.toList());
        }
    }
}
