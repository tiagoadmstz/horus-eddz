package io.github.tiagoadmstz.eddz.domains.reports;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Report_Group")
@SequenceGenerator(name = "seq_report_group", allocationSize = 1)
public class ReportGroup {

    @Id
    @Column(name = "GRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report_group")
    private Long id;
    @Column(name = "NOME", length = 150)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "groupId")
    private List<Report> reportList;

}
