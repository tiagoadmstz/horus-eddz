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

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cad_Operacao")
@SequenceGenerator(name = "operation_seq", sequenceName = "operation_seq", allocationSize = 1)
public class Operation {

    @Id
    @Column(name = "ID_OPERACAO")
    @GeneratedValue(generator = "operation_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "OPERACAO", length = 255, nullable = false)
    private String operation;
    @Column(name = "ORDEM")
    private Integer order;
    @Column(name = "OPE_SETOR", length = 50)
    private String operationSector;
    @Column(name = "COD_OP")
    private Integer operationCode;
    @Column(name = "CLIENTE", length = 50)
    private String client;
    @Column(name = "COD_SIMBOL_OP", length = 50)
    private String operationSymbolCode;
    @Column(name = "FORNECEDOR", length = 50)
    private String supplier;
    @Column(name = "PREPARADO_POR", length = 50)
    private String madeBy;
    @Column(name = "TELEFONE", length = 50)
    private String phone;
    @Column(name = "RESPONSAVEL_PROCESSO", length = 50)
    private String processOwner;
    @Column(name = "EQUIPE", length = 300)
    private String team;
    @Column(name = "DATA_CRIACAO", length = 10, columnDefinition = "VARCHAR")
    private LocalDate creationDate;

}
