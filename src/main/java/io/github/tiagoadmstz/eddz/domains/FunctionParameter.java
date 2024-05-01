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
@Table(name = "CAD_FUNCAO_PARAMETRO")
@SequenceGenerator(name = "func_param_seq", sequenceName = "func_param_seq", allocationSize = 1)
public class FunctionParameter {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "func_param_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "CODIGO")
    private Long code;
    @Column(name = "PARAMETRO", length = 255, nullable = false)
    private String parameter;
    @Column(name = "VALOR_PADRAO", length = 255, nullable = false)
    private String defaultValue;
    @Column(name = "CONTEXTO", length = 4000, nullable = false)
    private String context;
    @Column(name = "ID_CAD_FUNCAO")
    private Long functionId;
    @OneToMany(mappedBy = "functionParameterId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FunctionProfileParameter> functionProfileParameter;

}
