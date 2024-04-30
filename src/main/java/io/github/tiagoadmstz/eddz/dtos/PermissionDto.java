package io.github.tiagoadmstz.eddz.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.eddz.domains.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class PermissionDto implements Serializable {

    @JsonProperty("codigo")
    private Long id;
    @JsonProperty(value = "codigo_usuario")
    private Long userId;
    @JsonProperty("permissao")
    private String userPermission;

    public PermissionDto(final Permission permission) {
        id = permission.getId();
        userId = permission.getUserId();
        userPermission = permission.getUserPermission();
    }
}
