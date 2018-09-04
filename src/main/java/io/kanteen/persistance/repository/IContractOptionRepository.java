package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.ContractOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractOptionRepository extends JpaRepository<ContractOption, Long> {
}
