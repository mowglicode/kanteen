package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Contract;
import io.kanteen.persistance.entity.ContractOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractOptionRepository extends JpaRepository<ContractOption, Long> {
}
