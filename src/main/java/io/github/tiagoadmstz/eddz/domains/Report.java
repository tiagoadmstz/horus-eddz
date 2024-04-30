package io.github.tiagoadmstz.eddz.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cad_Report")
@NamedQueries(value = {
        @NamedQuery(name = "report.findAll", query = "SELECT cc FROM Report AS cc")
        , @NamedQuery(name = "report.findByIds", query = "SELECT cc FROM Report AS cc WHERE cc.id IN :paramIds")
})
@SequenceGenerator(name = "seq_report", allocationSize = 1)
public class Report implements Serializable {

    private static final long serialVersionUID = 4617363613110228581L;

    @Id
    @Column(name = "RELATORIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report")
    private Long id;
    @Column(name = "NOME", length = 255)
    private String nome;
    @Column(name = "SIGLA", length = 7)
    private String sigla;
    @Column(name = "PASTA", length = 2000)
    private String path;
    @Column(name = "TIPO", length = 5)
    private String tipo;
    @Column(name = "ATIVO", columnDefinition = "bit")
    private Boolean ativo;
    @Column(name = "ORDEM")
    private Integer ordem;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "GRUPO")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Report_Group.class)
    private Report_Group grupo;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Report_Filter.class)
    private List<Report_Filter> filtros;

}
