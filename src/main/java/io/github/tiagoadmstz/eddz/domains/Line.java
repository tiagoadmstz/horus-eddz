package io.github.tiagoadmstz.eddz.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cad_Linha")
@SequenceGenerator(name = "line_seq", sequenceName = "line_seq", allocationSize = 1)
public class Line {

    @Id
    @Column(name = "ID_LINHA")
    @GeneratedValue(generator = "line_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "ORDEM")
    private Integer order;
    @Column(name = "LINHA", length = 50, nullable = false)
    private String lineDescription;
    @Column(name = "TIPO_LINHA", length = 50)
    private String lineType;
    @Column(name = "SETOR", length = 50)
    private String sector;
    @Column(name = "N_PLANO", length = 50)
    private String planNumber;
    @Column(name = "CONTATO_CHAVE", length = 100)
    private String contactKey;
    @Column(name = "EQUIPE_PRINCIPAL", length = 100)
    private String coreTeam;
    @Column(name = "DATA_INICIAL", length = 50)
    private LocalDateTime initialDate;

}
