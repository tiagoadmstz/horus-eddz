package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.materials.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {

    @Query("select ln.lineDescription from Line as ln where ln.sector = :sector and ln.lineDescription not in :lines")
    List<String> findReportByNotLineAndSector(final String sector, final String[] lines);
}
