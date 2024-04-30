package io.github.tiagoadmstz.eddz.domains;

import io.github.tiagoadmstz.eddz.dtos.PermissionDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cad_Usuario_Permissao")
@SequenceGenerator(name = "permissions_seq", sequenceName = "permissions_seq", allocationSize = 1)
public class Permission {

    @Id
    @Column(name = "PK_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_seq")
    private Long id;
    @Column(name = "FK_ID_USUARIO")
    private Long userId;
    @Column(name = "PERMISSAO", length = 50)
    private String userPermission;

    public Permission(PermissionDto permissionDto) {
        id = permissionDto.getId();
        userId = permissionDto.getUserId();
        userPermission = permissionDto.getUserPermission();
    }
}
