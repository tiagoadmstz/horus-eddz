package io.github.tiagoadmstz.eddz.services;

import io.github.tiagoadmstz.eddz.repositories.LineRepository;
import org.springframework.stereotype.Service;

@Service
public class LineService {

    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }
}
