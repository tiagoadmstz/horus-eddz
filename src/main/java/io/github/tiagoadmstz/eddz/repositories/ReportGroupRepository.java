package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.ReportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportGroupRepository extends JpaRepository<ReportGroup, Long> {

    @Query("FROM ReportGroup AS rpg WHERE rpg.id IN :groupIds")
    Optional<List<ReportGroup>> findByIds(final Long[] groupIds);
}
