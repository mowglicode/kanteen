package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Long> {
}
