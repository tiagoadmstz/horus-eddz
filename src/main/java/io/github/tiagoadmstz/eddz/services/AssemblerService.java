package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.domains.materials.Oem;
import io.github.tiagoadmstz.eddz.dtos.OemDto;
import io.github.tiagoadmstz.eddz.repositories.OemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssemblerService {

    private final OemRepository oemRepository;

    public AssemblerService(OemRepository oemRepository) {
        this.oemRepository = oemRepository;
    }

    public List<OemDto> list() {
        return oemRepository.findAll(Sort.by("id").ascending())
                .stream().map(OemDto::new).toList();
    }

    public OemDto save(final OemDto oemDto) {
        return new OemDto(oemRepository.save(new Oem(oemDto)));
    }

    public void delete(final Long id) {
        oemRepository.deleteById(id);
    }

    public OemDto findById(final Long id) {
        return oemRepository.findById(id).map(OemDto::new).orElse(new OemDto());
    }
}
