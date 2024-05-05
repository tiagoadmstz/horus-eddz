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
@Table(name = "Cad_Teste")
@SequenceGenerator(name = "test_seq", sequenceName = "test_seq", allocationSize = 1)
public class Test {

    @Id
    @Column(name = "ID_TESTE")
    @GeneratedValue(generator = "test_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "COD_TESTE", length = 50, nullable = false)
    private String testCode;
    @Column(name = "DESC_TESTE", length = 255)
    private String testDescription;
    @Column(name = "ORDEM")
    private Integer order;
    @Column(name = "TES_EQUIPAMENTO", length = 255)
    private String testEquipment;
    @Column(name = "CONTROL_PRCESS", length = 255)
    private String processControl;
    @Column(name = "CLASSIFICACAO", length = 50)
    private String classification;

}
