package io.github.tiagoadmstz.eddz.domains.functions;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAD_FUNCAO_PARAM_PERFIL")
@SequenceGenerator(name = "func_profile_param_seq", sequenceName = "func_profile_param_seq", allocationSize = 1)
public class FunctionProfileParameter {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "func_profile_param_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PERFIL", length = 255, nullable = false)
    private String profile;
    @Column(name = "VALOR", length = 255, nullable = false)
    private String value;
    @Column(name = "ID_CAD_FUNC_PARAM", nullable = false)
    private Integer functionParameterId;

}
