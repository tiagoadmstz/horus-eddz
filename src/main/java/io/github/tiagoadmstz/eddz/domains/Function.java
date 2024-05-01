package io.github.tiagoadmstz.eddz.domains;

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
@Table(name = "CAD_FUNCAO")
@SequenceGenerator(name = "function_seq", sequenceName = "function_seq", allocationSize = 1)
public class Function {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "function_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DESCRICAO", length = 255, nullable = false)
    private String description;
    @OneToMany(mappedBy = "functionId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FunctionParameter> functionParameter;

}
