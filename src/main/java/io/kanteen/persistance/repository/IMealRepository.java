package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IMealRepository extends JpaRepository<Meal, Long> {

    @Query(value = "SELECT * FROM meal WHERE child_id=?1",nativeQuery = true)
    Optional<Meal> findMealByChildId(long idChild);
}
