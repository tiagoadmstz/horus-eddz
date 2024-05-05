package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.tests.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    @Query("select tt.testDescription from Test tt where tt.testEquipment = :sector order by tt.order")
    List<String> findTestDescriptionByEquip(final String sector);
}
