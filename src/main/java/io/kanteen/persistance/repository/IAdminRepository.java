package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAdminRepository extends JpaRepository<Admin,Long> {
    @Query(value = "SELECT * FROM `parent` WHERE account_id =?1",nativeQuery = true)
    Optional<Admin> findAdminByAccountId(long id);
}
