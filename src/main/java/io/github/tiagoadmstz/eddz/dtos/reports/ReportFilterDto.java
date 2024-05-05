package io.github.tiagoadmstz.eddz.dtos.reports;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.eddz.domains.reports.ReportFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportFilterDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("valor")
    private String value;
    @JsonProperty("tipo")
    private String type;
    @JsonProperty("ordem")
    private Integer order;

    public ReportFilterDto(final ReportFilter reportFilter) {
        this.id = reportFilter.getId();
        this.name = reportFilter.getNome();
        this.type = reportFilter.getTipo();
        this.value = reportFilter.getValor();
        this.order = reportFilter.getOrdem();
    }
}
