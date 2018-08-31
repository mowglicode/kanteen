package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuRepository extends JpaRepository<Menu, Long> {
}
