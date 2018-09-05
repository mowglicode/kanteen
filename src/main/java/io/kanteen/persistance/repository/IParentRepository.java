package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IParentRepository extends JpaRepository<Parent, Long> {
    @Query(value = "SELECT * FROM `parent` WHERE account_id =?1",nativeQuery = true)
    Optional<Parent> findParentByAccountId(long id);
}
