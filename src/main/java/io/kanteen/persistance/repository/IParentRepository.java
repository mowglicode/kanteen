package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParentRepository extends JpaRepository<Parent, Long> {
}
