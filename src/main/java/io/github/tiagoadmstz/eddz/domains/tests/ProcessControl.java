package io.github.tiagoadmstz.eddz.domains.tests;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cad_Controle_Processo")
@SequenceGenerator(name = "process_control_seq", sequenceName = "process_control_seq", allocationSize = 1)
public class ProcessControl {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "process_control_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DESC_CONTROLE", length = 255, nullable = false)
    private String evaluationDescription;
    @Column(name = "METODO_AVALIACAO", length = 50)
    private String evaluationMethod;
    @Column(name = "PREVENT_DETECT", length = 10)
    private String detectPrevent;
    @Column(name = "SETOR", length = 50)
    private String sector;

}
