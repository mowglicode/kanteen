package io.kanteen.service;

import io.kanteen.dto.ContractDto;
import io.kanteen.dto.ContractOptionDto;

import java.util.List;

public interface IContractService {
    List<ContractDto> displayContracts();
    ContractDto displayContractById(long id);
    void deleteContract(long id);
    ContractDto saveContract(ContractDto contractDto);
}

