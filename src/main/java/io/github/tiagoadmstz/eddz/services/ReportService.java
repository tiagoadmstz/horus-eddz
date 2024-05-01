package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.FunctionParameter;
import io.github.tiagoadmstz.eddz.domains.FunctionProfileParameter;
import io.github.tiagoadmstz.eddz.dtos.ReportGroupDto;
import io.github.tiagoadmstz.eddz.repositories.FunctionParameterRepository;
import io.github.tiagoadmstz.eddz.repositories.LineRepository;
import io.github.tiagoadmstz.eddz.repositories.ReportGroupRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportGroupRepository reportGroupRepository;
    private final FunctionParameterRepository functionParameterRepository;
    private final LineRepository lineRepository;

    public ReportService(
            ReportGroupRepository reportGroupRepository,
            FunctionParameterRepository functionParameterRepository,
            LineRepository lineRepository
    ) {
        this.reportGroupRepository = reportGroupRepository;
        this.functionParameterRepository = functionParameterRepository;
        this.lineRepository = lineRepository;
    }

    public List<ReportGroupDto> listBySector(final String sector) {
        final String stringReportsIds = getReportIdListByUserSector(sector);
        if (!StringUtils.isBlank(stringReportsIds)) {
            final Long[] reportsIds = Arrays.stream(stringReportsIds.split(","))
                    .map(Long::parseLong)
                    .toArray(Long[]::new);
            return reportGroupRepository.findByIds(reportsIds).orElse(Collections.emptyList()).stream()
                    .map(ReportGroupDto::new)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private String getReportIdListByUserSector(final String sector) {
        final Optional<FunctionParameter> fpOptional = functionParameterRepository.findBySector(sector);
        if (fpOptional.isPresent()) {
            final FunctionParameter functionParameter = fpOptional.get();
            final List<FunctionProfileParameter> functionProfileParameter = functionParameter.getFunctionProfileParameter();
            if (
                    "N".equals(functionParameter.getDefaultValue()) &&
                            !functionProfileParameter.isEmpty() &&
                            !"T".equals(functionProfileParameter.get(0).getProfile())
            ) {
                return functionProfileParameter.get(0).getValue();
            }
            return functionParameter.getDefaultValue();
        }
        return "";
    }

    public List<String> findReportLinesBySector(final String sector) {
        final String[] lines = {
                "L01", "L03", "L03ATB", "L04ATB", "L05", "L10", "L13", "L14", "L16",
                "Carrossel 37", "Carrossel 153", "Carrossel 197"
        };
        return lineRepository.findReportByNotLineAndSector(sector, lines);
    }
}
