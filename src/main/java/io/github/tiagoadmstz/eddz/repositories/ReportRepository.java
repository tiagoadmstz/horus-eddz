package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.reports.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("FROM Report AS rp WHERE rp.id IN :paramIds")
    Optional<List<Report>> findByIds(final Long[] paramIds);

    @Query(value = "select Relatorio from Cad_Relatorios_Permissoes where Usuario = :userId", nativeQuery = true)
    List<Long> findPermissionByUser(final Long userId);
}
