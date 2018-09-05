package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.ContractAnswer;
import io.kanteen.persistance.entity.ContractOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractAnswerRepository extends JpaRepository<ContractAnswer, Long> {
}
