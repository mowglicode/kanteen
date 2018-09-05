package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * FROM `account` WHERE email =?1",nativeQuery = true)
    Optional<Account> findByEmail(String email);
}
