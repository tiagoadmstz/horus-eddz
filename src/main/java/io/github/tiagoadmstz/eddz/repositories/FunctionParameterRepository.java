package io.github.tiagoadmstz.eddz.repositories;

import io.github.tiagoadmstz.eddz.domains.FunctionParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FunctionParameterRepository extends JpaRepository<FunctionParameter, Long> {

    @Query("SELECT fp FROM FunctionParameter fp JOIN fp.functionProfileParameter fpp WHERE fp.parameter = :sector AND fpp.profile = :sector")
    Optional<FunctionParameter> findBySector(final String sector);

}
