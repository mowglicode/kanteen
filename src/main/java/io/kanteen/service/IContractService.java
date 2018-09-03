package io.kanteen.service;

import io.kanteen.dto.ContractDto;

import java.util.List;

public interface IContractService {
    List<ContractDto> displayContracts();
    ContractDto displayContractById(long id);
    void deleteContract(long id);
    ContractDto saveContract(ContractDto contractDto);
}

