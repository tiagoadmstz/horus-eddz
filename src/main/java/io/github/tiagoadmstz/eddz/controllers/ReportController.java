package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.reports.ReportGenerationDto;
import io.github.tiagoadmstz.eddz.dtos.reports.ReportGroupDto;
import io.github.tiagoadmstz.eddz.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.repo.OutputStreamResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("list/{sector}")
    public ResponseEntity<List<ReportGroupDto>> listBySector(@PathVariable final String sector) {
        return ResponseEntity.ok(reportService.listBySector(sector));
    }

    @GetMapping("lines/{sector}")
    public ResponseEntity<List<String>> listLinesBySector(@PathVariable final String sector) {
        return ResponseEntity.ok(reportService.findReportLinesBySector(sector));
    }

    @GetMapping("tests/{sector}")
    public ResponseEntity<List<String>> findTestDescriptionByEquip(@PathVariable final String sector) {
        return ResponseEntity.ok(reportService.findTestDescriptionByEquip(sector));
    }

    @GetMapping("materials/{line}")
    public ResponseEntity<List<String>> findMaterialByLine(@PathVariable final String line) {
        return ResponseEntity.ok(reportService.findMaterialByLine(line));
    }

    @GetMapping("ddz/list")
    public ResponseEntity<List<String>> findDdzByDateAndProfile(
            @RequestParam final LocalDateTime initialDate,
            @RequestParam final LocalDateTime finalDate,
            @RequestParam final Long rcProfile
    ) {
        return ResponseEntity.ok(reportService.findDdzByDateAndProfile(initialDate, finalDate, rcProfile));
    }

    @GetMapping("equips/list")
    public ResponseEntity<List<String>> findAllEquip() {
        return ResponseEntity.ok(reportService.findAllEquip());
    }

    @GetMapping("permissions/{userId}")
    public ResponseEntity<List<Long>> findReportPermissionsByUserId(@PathVariable final Long userId) {
        return ResponseEntity.ok(reportService.findReportPermissionsByUserId(userId));
    }

    @PostMapping("generate")
    public ResponseEntity<byte[]> generatePdfReport(@RequestBody final ReportGenerationDto reportGenerationDto) throws JRException, IOException {
        final byte[] pdfReport = reportService.generatePdfReportByDto(reportGenerationDto);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfReport);
    }
}
