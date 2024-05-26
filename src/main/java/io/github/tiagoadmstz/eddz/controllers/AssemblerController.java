package io.github.tiagoadmstz.eddz.controllers;

import io.github.tiagoadmstz.eddz.dtos.OemDto;
import io.github.tiagoadmstz.eddz.services.AssemblerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("assembler")
public class AssemblerController {

    private final AssemblerService assemblerService;

    public AssemblerController(AssemblerService assemblerService) {
        this.assemblerService = assemblerService;
    }

    @GetMapping("list")
    public ResponseEntity<List<OemDto>> list() {
        return ResponseEntity.ok(assemblerService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<OemDto> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(assemblerService.findById(id));
    }

    @PostMapping("save")
    public ResponseEntity<OemDto> save(@RequestBody final OemDto oem) {
        return ResponseEntity.ok(assemblerService.save(oem));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable final Long id) {
        assemblerService.delete(id);
    }
}
