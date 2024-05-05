package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.functions.FunctionParameter;
import io.github.tiagoadmstz.eddz.domains.functions.FunctionProfileParameter;
import io.github.tiagoadmstz.eddz.domains.materials.Material;
import io.github.tiagoadmstz.eddz.domains.tests.Equipment;
import io.github.tiagoadmstz.eddz.dtos.reports.ReportGroupDto;
import io.github.tiagoadmstz.eddz.repositories.DdzRepository;
import io.github.tiagoadmstz.eddz.repositories.EquipmentRepository;
import io.github.tiagoadmstz.eddz.repositories.FunctionParameterRepository;
import io.github.tiagoadmstz.eddz.repositories.LineRepository;
import io.github.tiagoadmstz.eddz.repositories.MaterialRepository;
import io.github.tiagoadmstz.eddz.repositories.ReportGroupRepository;
import io.github.tiagoadmstz.eddz.repositories.ReportRepository;
import io.github.tiagoadmstz.eddz.repositories.TestRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final EquipmentRepository equipmentRepository;
    private final DdzRepository ddzRepository;
    private final MaterialRepository materialRepository;
    private final TestRepository testRepository;
    private final ReportGroupRepository reportGroupRepository;
    private final FunctionParameterRepository functionParameterRepository;
    private final LineRepository lineRepository;

    public ReportService(
            ReportRepository reportRepository,
            EquipmentRepository equipmentRepository,
            DdzRepository ddzRepository,
            MaterialRepository materialRepository,
            TestRepository testRepository,
            ReportGroupRepository reportGroupRepository,
            FunctionParameterRepository functionParameterRepository,
            LineRepository lineRepository
    ) {
        this.reportRepository = reportRepository;
        this.equipmentRepository = equipmentRepository;
        this.ddzRepository = ddzRepository;
        this.materialRepository = materialRepository;
        this.testRepository = testRepository;
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

    public List<String> findTestDescriptionByEquip(final String sector) {
        return testRepository.findTestDescriptionByEquip(sector);
    }

    public List<String> findMaterialByLine(final String line) {
        if (StringUtils.isBlank(line)) {
            return this.formatMaterialBpcs(materialRepository.findMaterialSeqAndBpcsByOrderByBpcsAsc());
        }
        return this.formatMaterialBpcs(materialRepository.findByLine(line));
    }

    private List<String> formatMaterialBpcs(List<Material> materialList) {
        return materialList.stream()
                .map(m -> String.format("%s - %s", m.getMaterialDescription(), m.getBpcs()))
                .collect(Collectors.toList());
    }

    public List<String> findDdzByDateAndProfile(
            final LocalDateTime initialDate,
            final LocalDateTime finalDate,
            final Long rcProfile
    ) {
        return ddzRepository.findFullDateByFlagEAndDateAndMaterial(initialDate, finalDate, rcProfile).stream()
                .map(ddz -> DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ddz.getFullDate()))
                .collect(Collectors.toList());
    }

    public List<String> findAllEquip() {
        return equipmentRepository.findAll(Sort.by(Sort.Direction.ASC, "equipmentDescription")).stream()
                .map(Equipment::getEquipmentDescription)
                .collect(Collectors.toList());
    }

    public List<Long> findReportPermissionsByUserId(final Long userId) {
        return reportRepository.findPermissionByUser(userId);
    }
}
