package io.github.tiagoadmstz.eddz.domains.materials;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cad_Oem")
@SequenceGenerator(name = "oem_seq", sequenceName = "oem_seq", allocationSize = 1)
public class Oem {

    @Id
    @Column(name = "ID_OEM")
    @GeneratedValue(generator = "oem_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "OEM", length = 50, nullable = false, unique = true)
    private String oemDescription;

}
