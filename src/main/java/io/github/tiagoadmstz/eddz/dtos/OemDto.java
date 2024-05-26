package io.github.tiagoadmstz.eddz.dtos;

import io.github.tiagoadmstz.eddz.domains.materials.Oem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OemDto {

    private Long id;
    private String description;

    public OemDto(Oem oem) {
        this.id = oem.getId();
        this.description = oem.getOemDescription();
    }
}
