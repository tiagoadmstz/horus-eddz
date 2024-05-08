package io.github.tiagoadmstz.eddz.dtos.reports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.tiagoadmstz.eddz.domains.reports.ReportFilter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.PathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ReportGenerationDto implements Serializable {

    private String prettyName;
    private String type;
    private String fileName;
    private String sheetFormat;
    private String reportPath;
    private String reportLogo;
    private List<ReportFilter> filters;
    private Map<String, Object> parameters;

    public void checkDefaultReportParameters() throws IOException {
        this.parameters.put("SUBREPORT_DIR", new PathResource(this.reportPath));
        this.parameters.put("logo", new PathResource(this.reportLogo));
        this.checkDdzSheetFormat();
    }

    @JsonIgnore
    public InputStream getInputStream() throws IOException {
        return new PathResource(String.format("%s/%s", this.reportPath, this.fileName)).getInputStream();
    }

    public void setReportPaths(String reportPath, String reportLogo) {
        this.reportPath = reportPath;
        this.reportLogo = reportLogo;
    }

    public boolean isDataCollect() {
        return Stream.of("Coleta de Dados (por Teste)", "Coleta de Dados (por Composto)")
                .noneMatch(t -> t.equals(prettyName));
    }

    public boolean isResultPerLabel() {
        return "Resultado por Etiqueta".equals(prettyName);
    }

    public boolean isSqlReport() {
        return "SQL".equals(type);
    }

    private boolean isRoundDdz() {
        return "DDZ rodada".equals(prettyName);
    }

    private boolean isA3Sheet() {
        return "A3".equals(sheetFormat);
    }

    private void checkDdzSheetFormat() {
        if (isRoundDdz() && isA3Sheet()) {
            fileName = fileName.substring(0, (fileName.length() - 7)).concat("A3.jasper");
        }
    }
}
