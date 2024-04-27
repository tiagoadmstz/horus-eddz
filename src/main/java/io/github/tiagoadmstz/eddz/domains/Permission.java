package io.github.tiagoadmstz.eddz.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Cad_Usuario_Permissao")
public class Permission {

    @Id
    @Column(name = "PK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FK_ID_USUARIO")
    private Long userId;
    @Column(name = "PERMISSAO", length = 50)
    private String userPermission;

}
