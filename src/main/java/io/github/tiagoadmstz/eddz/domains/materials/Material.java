package io.github.tiagoadmstz.eddz.domains.materials;

import jakarta.persistence.Column;
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

import static jakarta.persistence.ConstraintMode.CONSTRAINT;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cad_Material")
@SequenceGenerator(name = "material_seq", sequenceName = "material_seq", allocationSize = 1)
public class Material {

    @Id
    @Column(name = "ID_MATERIAL")
    @GeneratedValue(generator = "material_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "MATERIAL", nullable = false)
    private Long materialSeq;
    @Column(name = "DESC_MATERIAL", length = 255)
    private String materialDescription;
    @ManyToOne
    @JoinColumn(name = "MAT_LINHA", referencedColumnName = "LINHA",
            foreignKey = @ForeignKey(name = "FK_Cad_Material_Cad_Linha", value = CONSTRAINT, foreignKeyDefinition = "VARCHAR")
    )
    private Line line;
    @ManyToOne
    @JoinColumn(name = "MAT_PROJETO", referencedColumnName = "PROJETO",
            foreignKey = @ForeignKey(name = "FK_Cad_Material_Cad_Projeto", value = CONSTRAINT, foreignKeyDefinition = "VARCHAR")
    )
    private Project project;
    @Column(name = "N_DESENHO", length = 100)
    private String drawNumber;
    @Column(name = "N_PLANO", length = 50)
    private String projectNumber;
    @Column(name = "BPCS", length = 10)
    private String bpcs;
    @Column(name = "META", length = 10)
    private String goal;
    @Column(name = "OBSERVACAO", length = 500)
    private String notes;
    @Column(name = "IMAGE", length = 150)
    private String image;
    @Column(name = "IMAGEROD", length = 255)
    private String imagerod;

}
