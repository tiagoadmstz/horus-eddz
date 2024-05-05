package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.materials.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findMaterialSeqAndBpcsByOrderByBpcsAsc();

    @Query("select mt.materialSeq, mt.bpcs from Material mt where mt.line.lineDescription = :line order by mt.bpcs asc")
    List<Material> findByLine(final String line);

}
