package io.github.tiagoadmstz.eddz.dtos.reports;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.eddz.domains.reports.Report;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportDto implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("sigla")
    private String sigla;
    @JsonProperty("path")
    private String path;
    @JsonProperty("tipo")
    private String type;
    @JsonProperty("ativo")
    private Boolean active;
    @JsonProperty("ordem")
    private Integer order;
    @JsonProperty("grupo")
    private Long groupId;
    @JsonProperty("filtros")
    private List<ReportFilterDto> filters;

    public ReportDto(final Report report) {
        this.id = report.getId();
        this.name = report.getName();
        this.sigla = report.getAcronym();
        this.path = report.getPath();
        this.type = report.getType();
        this.active = report.getActive();
        this.order = report.getOrder();
        this.groupId = report.getGroupId();
        if (Objects.nonNull(report.getFilters())) {
            this.filters = report.getFilters().stream()
                    .map(ReportFilterDto::new)
                    .collect(Collectors.toList());
        }
    }
}
