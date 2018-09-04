package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInformationRepository extends JpaRepository<Information, Long> {
}
