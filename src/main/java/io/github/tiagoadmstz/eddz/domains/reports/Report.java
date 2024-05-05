package io.github.tiagoadmstz.eddz.domains.reports;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cad_Report")
@SequenceGenerator(name = "seq_report", allocationSize = 1)
public class Report {

    @Id
    @Column(name = "RELATORIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report")
    private Long id;
    @Column(name = "NOME", length = 255)
    private String name;
    @Column(name = "SIGLA", length = 7)
    private String acronym;
    @Column(name = "PASTA", length = 2000)
    private String path;
    @Column(name = "TIPO", length = 5)
    private String type;
    @Column(name = "ATIVO")
    private Boolean active;
    @Column(name = "ORDEM")
    private Integer order;
    @Column(name = "ID_GRUPO")
    private Long groupId;
    @JoinTable(
            name = "Cad_Report_Report_Filter",
            joinColumns = @JoinColumn(name = "Report_RELATORIO"),
            inverseJoinColumns = @JoinColumn(name = "filtros_FILTRO")
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<ReportFilter> filters;

}
