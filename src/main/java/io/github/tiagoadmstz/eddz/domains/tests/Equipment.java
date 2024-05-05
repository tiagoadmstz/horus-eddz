package io.github.tiagoadmstz.eddz.domains.tests;

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
@Table(name = "Cad_Equipamento")
@SequenceGenerator(name = "equipment_seq", sequenceName = "equipment_seq", allocationSize = 1)
public class Equipment {

    @Id
    @Column(name = "ID_EQUIPAMENTO")
    @GeneratedValue(generator = "equipment_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "EQUIPAMENTO", length = 255, unique = true)
    private String equipmentDescription;
    @Column(name = "EQU_OPERACAO", length = 255)
    private String operationEquipment;
    @Column(name = "ORDEM")
    private Integer order;

}
