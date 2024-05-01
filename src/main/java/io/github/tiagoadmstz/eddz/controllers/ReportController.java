package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.ReportGroupDto;
import io.github.tiagoadmstz.eddz.services.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
