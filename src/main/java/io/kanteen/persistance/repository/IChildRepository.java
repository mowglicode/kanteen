package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChildRepository extends JpaRepository<Child, Long> {

}
