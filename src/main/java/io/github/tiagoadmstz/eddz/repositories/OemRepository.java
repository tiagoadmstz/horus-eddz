package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.materials.Oem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OemRepository extends JpaRepository<Oem, Long> {
}
