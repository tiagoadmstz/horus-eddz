package io.github.tiagoadmstz.eddz.domains.materials;

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
@Table(name = "Cad_Projeto")
@SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
public class Project {

    @Id
    @Column(name = "ID_PROJETO")
    @GeneratedValue(generator = "project_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PROJETO", length = 50, nullable = false, unique = true)
    private String projectDescription;
    @ManyToOne
    @JoinColumn(name = "PRO_OEM", referencedColumnName = "OEM",
            foreignKey = @ForeignKey(name = "FK_Cad_Projeto_Cad_Oem", value = ConstraintMode.CONSTRAINT, foreignKeyDefinition = "VARCHAR")
    )
    private Oem oem;

}
