package io.github.tiagoadmstz.eddz.dtos.reports;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.eddz.domains.reports.ReportGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportGroupDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("reportList")
    private List<ReportDto> reportDtoList;

    public ReportGroupDto(ReportGroup reportGroup) {
        this.id = reportGroup.getId();
        this.name = reportGroup.getNome();
        if (Objects.nonNull(reportGroup.getReportList())) {
            this.reportDtoList = reportGroup.getReportList().stream()
                    .map(ReportDto::new)
                    .collect(Collectors.toList());
        }
    }
}
