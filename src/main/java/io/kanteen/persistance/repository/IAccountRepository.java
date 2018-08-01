package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
