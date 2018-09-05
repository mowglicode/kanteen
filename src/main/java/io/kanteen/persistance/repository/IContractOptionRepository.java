package io.kanteen.persistance.repository;

import io.kanteen.persistance.entity.Contract;
import io.kanteen.persistance.entity.ContractOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractOptionRepository extends JpaRepository<ContractOption, Long> {

    @Query("select o from ContractOption o where o.contract = ?1")
    List<ContractOption> findByContract(Contract contract);


}
