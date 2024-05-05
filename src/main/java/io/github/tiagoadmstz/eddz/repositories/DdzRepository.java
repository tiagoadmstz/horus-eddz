package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.ddz.Ddz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DdzRepository extends JpaRepository<Ddz, Long> {

    @Query("select d.inputDate, d.inputHour from Ddz as d where d.flag = 'E' and d.inputDate between :initialDate and :finalDate and d.material.id = :materialId")
    List<Ddz> findFullDateByFlagEAndDateAndMaterial(final LocalDateTime initialDate, final LocalDateTime finalDate, final Long materialId);

}
