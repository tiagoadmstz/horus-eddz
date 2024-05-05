package io.github.tiagoadmstz.eddz.domains.ddz;

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
@Table(name = "Problemas")
@SequenceGenerator(name = "problem_seq", sequenceName = "problem_seq", allocationSize = 1)
public class Problem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "problem_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DESC_PROBLEMA", length = 255)
    private String problemDescription;

}
