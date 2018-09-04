package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Long> {
}
