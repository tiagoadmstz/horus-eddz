package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findByUserId(final Long userId);

    void deleteByUserId(final Long userID);
}
