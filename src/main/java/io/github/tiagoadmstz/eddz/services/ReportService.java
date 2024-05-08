package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.config.EddzConfiguration;
import io.github.tiagoadmstz.eddz.domains.functions.FunctionParameter;
import io.github.tiagoadmstz.eddz.domains.functions.FunctionProfileParameter;
import io.github.tiagoadmstz.eddz.domains.materials.Material;
import io.github.tiagoadmstz.eddz.domains.tests.Equipment;
import io.github.tiagoadmstz.eddz.dtos.reports.ReportGenerationDto;
import io.github.tiagoadmstz.eddz.dtos.reports.ReportGroupDto;
import io.github.tiagoadmstz.eddz.exceptions.ReportException;
import io.github.tiagoadmstz.eddz.repositories.DdzRepository;
import io.github.tiagoadmstz.eddz.repositories.EquipmentRepository;
import io.github.tiagoadmstz.eddz.repositories.FunctionParameterRepository;
import io.github.tiagoadmstz.eddz.repositories.LineRepository;
import io.github.tiagoadmstz.eddz.repositories.MaterialRepository;
import io.github.tiagoadmstz.eddz.repositories.ReportGroupRepository;
import io.github.tiagoadmstz.eddz.repositories.ReportRepository;
import io.github.tiagoadmstz.eddz.repositories.TestRepository;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final JRDataSource dataSource;
    private final EddzConfiguration eddzConfiguration;
    private final ReportRepository reportRepository;
    private final EquipmentRepository equipmentRepository;
    private final DdzRepository ddzRepository;
    private final MaterialRepository materialRepository;
    private final TestRepository testRepository;
    private final ReportGroupRepository reportGroupRepository;
    private final FunctionParameterRepository functionParameterRepository;
    private final LineRepository lineRepository;

    public ReportService(
            JRDataSource dataSource,
            EddzConfiguration eddzConfiguration,
            ReportRepository reportRepository,
            EquipmentRepository equipmentRepository,
            DdzRepository ddzRepository,
            MaterialRepository materialRepository,
            TestRepository testRepository,
            ReportGroupRepository reportGroupRepository,
            FunctionParameterRepository functionParameterRepository,
            LineRepository lineRepository
    ) {
        this.dataSource = dataSource;
        this.eddzConfiguration = eddzConfiguration;
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
                !"T".equals(functionProfileParameter.getFirst().getProfile())
            ) {
                return functionProfileParameter.getFirst().getValue();
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

    public byte[] generatePdfReportByDto(final ReportGenerationDto report) throws ReportException {
        try {
            if (
                report.getFilters().stream().anyMatch(ft -> StringUtils.isBlank(ft.getValor())) &&
                (report.isSqlReport() && report.isDataCollect())
            ) {
                report.setReportPaths(eddzConfiguration.getReportsPath(), eddzConfiguration.getReportsLogo());
                report.checkDefaultReportParameters();
                if (report.isResultPerLabel()) {
                    throw new ReportException("Error on trying generate report: copies sent to printer");
                }
                return generatePdfReport(report);
            } else {
                throw new ReportException("Error on trying generate report: required field");
            }
        } catch (JRException | IOException reportException) {
            throw new ReportException(String.format("Error on trying generate report: %s", reportException.getMessage()));
        }
    }

    private byte[] generatePdfReport(final ReportGenerationDto report) throws JRException, IOException {
        final JasperPrint jasperPrint = JasperFillManager.fillReport(report.getInputStream(), report.getParameters(), dataSource);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
