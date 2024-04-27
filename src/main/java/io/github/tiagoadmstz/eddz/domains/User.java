package io.github.tiagoadmstz.eddz.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
