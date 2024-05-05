package io.github.tiagoadmstz.eddz.domains.ddz;

import io.github.tiagoadmstz.eddz.domains.materials.Material;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DDZ")
@SequenceGenerator(name = "ddz_seq", sequenceName = "ddz_seq", allocationSize = 1)
public class Ddz {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ddz_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "ACAO_TOMADA", length = 300)
    private String action;
    @Transient
    private LocalDateTime fullDate;
    @Column(name = "DATA_INPUT")
    private LocalDateTime inputDate;
    @Column(name = "HORA_INPUT")
    private LocalDateTime inputHour;
    @Column(name = "OBSERVACAO", length = 300)
    private String notes;
    @Column(name = "TURNO", length = 10)
    private String turn;
    @ManyToOne
    @JoinColumn(name = "ID_CAUSA_ID", foreignKey = @ForeignKey(name = "FK_DDZ_ID_CAUSA_ID", value = ConstraintMode.CONSTRAINT))
    private Cause cause;
    @ManyToOne
    @JoinColumn(name = "ID_M_MATERIAL", foreignKey = @ForeignKey(name = "FK_DDZ_ID_M_MATERIAL", value = ConstraintMode.CONSTRAINT))
    private Material material;
    @Column(name = "QTD_SCRAP")
    private BigDecimal scrap;
    @Column(name = "QTD_SCRAP_REAIS")
    private BigDecimal realScrap;
    @Column(name = "QTD_SCRAP_KG")
    private BigDecimal weightScrap;
    @Column(name = "VELOCIDADE")
    private Double speed;
    @Column(name = "PESO")
    private Double weight;
    @Column(name = "DATA_REAL")
    private LocalDateTime realDate;
    @Column(name = "PRIORIDADE")
    private Integer priority;
    @Column(name = "PARTICIPANTES", length = 255)
    private String participants;
    @Column(name = "RESPONSAVEL", length = 50)
    private String answerable;
    @Column(name = "DATA_CONCLUIDO", length = 10)
    private String conclusionDate;
    @Column(name = "DATA_PLANO", length = 10)
    private String planDate;
    @Column(name = "FLAG", length = 1)
    private String flag;

    @PostLoad
    private void loadFullDate() {
        this.fullDate = LocalDateTime.of(this.inputDate.toLocalDate(), this.inputHour.toLocalTime());
    }
}
