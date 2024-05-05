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
@Table(name = "Cad_Metodo_Avaliacao")
@SequenceGenerator(name = "evaluation_method_seq", sequenceName = "evaluation_method_seq", allocationSize = 1)
public class EvaluationMethod {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "evaluation_method_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DESC_METODO", length = 50, nullable = false)
    private String methodDescription;
    @Column(name = "SETOR", length = 50)
    private String sector;

}
