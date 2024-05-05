package io.github.tiagoadmstz.eddz.domains.ddz;

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
@Table(name = "")
@SequenceGenerator(name = "cause_seq", sequenceName = "cause_seq", allocationSize = 1)
public class Cause {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "cause_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DESC_CAUSA", length = 255)
    private String causeDescription;
    @ManyToOne
    @JoinColumn(name = "ID_PROBLEMA_ID", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "Causas_ID_PROBLEMA_ID", value = ConstraintMode.CONSTRAINT)
    )
    private Problem problem;

}
