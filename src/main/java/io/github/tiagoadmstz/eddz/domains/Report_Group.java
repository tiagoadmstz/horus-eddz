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
@Table(name = "Report_Group")
@NamedQueries(value = {
        @NamedQuery(name = "report_group.findAll", query = "SELECT rr FROM Report_Group AS rr")
})
@SequenceGenerator(name = "seq_report_group", allocationSize = 1)
public class Report_Group implements Serializable {

    private static final long serialVersionUID = 3983201603811180025L;

    @Id
    @Column(name = "GRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report_group")
    private Long id;
    @Column(name = "NOME", length = 150)
    private String nome;

}
