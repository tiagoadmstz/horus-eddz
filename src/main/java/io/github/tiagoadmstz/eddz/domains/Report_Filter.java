package io.github.tiagoadmstz.eddz.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Report_Filter")
@NamedQueries(value = {
        @NamedQuery(name = "report_filter.findAll", query = "SELECT rr FROM Report_Filter AS rr")
})
@SequenceGenerator(name = "seq_report_filter", allocationSize = 1)
public class Report_Filter implements Serializable {

    private static final long serialVersionUID = -8031438007775305676L;

    @Id
    @Column(name = "FILTRO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report_filter")
    private Long id;
    @Column(name = "NOME", length = 80)
    private String nome;
    @Column(name = "VALOR", length = 100)
    private String valor;
    @Column(name = "TIPO", length = 50)
    private String tipo;
    @Column(name = "ORDEM")
    private Integer ordem;

}
