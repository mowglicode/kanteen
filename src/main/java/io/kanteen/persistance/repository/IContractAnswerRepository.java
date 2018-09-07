package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Contract;
import io.kanteen.persistance.entity.ContractAnswer;
import io.kanteen.persistance.entity.ContractOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractAnswerRepository extends JpaRepository<ContractAnswer, Long> {


    @Query("SELECT ca FROM ContractAnswer ca WHERE ca.contract = ?1")
    List<ContractAnswer> findContractAnswerByContract(Contract contract);
}
