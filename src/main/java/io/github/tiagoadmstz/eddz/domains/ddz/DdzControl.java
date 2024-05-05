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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "")
@SequenceGenerator(name = "ddz_control_seq", sequenceName = "ddz_control_seq", allocationSize = 1)
public class DdzControl {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ddz_control_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "MATERIAL", length = 255, nullable = false)
    private String material;
    @Column(name = "DATA_BASE", nullable = false)
    private LocalDateTime baseDate;
    @Column(name = "LINHA", length = 255, nullable = false)
    private String line;
    @Column(name = "SCRAP_TOTAL", scale = 10, precision = 2)
    private BigDecimal totalScrap;

}
