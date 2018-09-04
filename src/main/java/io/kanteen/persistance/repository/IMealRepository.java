package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IMealRepository extends JpaRepository<Meal, Long> {

    @Query(value = "SELECT * FROM meal WHERE child_id=?1",nativeQuery = true)
    Optional<List<Meal>> findMealByChildId(long idChild);

    @Query( value="SELECT * FROM meal WHERE day=?1", nativeQuery= true)
    Optional<List<Meal>> findMealsByDay( String date);

}
