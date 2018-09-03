package io.kanteen.service.impl;


import io.kanteen.dto.ContractDto;
import io.kanteen.dto.ContractOptionDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Contract;
import io.kanteen.persistance.entity.ContractOption;
import io.kanteen.persistance.repository.IContractOptionRepository;
import io.kanteen.persistance.repository.IContractRepository;
import io.kanteen.service.IContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IContractOptionRepository contractOptionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ContractDto> displayContracts() {
        List<Contract> tmp = contractRepository.findAll();
        List<ContractDto> contracts = new ArrayList<>();

        for (Contract c : tmp){
            contracts.add(modelMapper.map(c, ContractDto.class));
        }
        return contracts;
    }

    @Override
    public ContractDto displayContractById(long id) {
        Optional<Contract> tmp = contractRepository.findById(id);
        if (tmp.isPresent()){
            return modelMapper.map(tmp.get(), ContractDto.class);
        } else {
            throw new NotFoundException("Contract not found");
        }
    }

    @Override
    public void deleteContract(long id) {
        Optional<Contract> tmp = contractRepository.findById(id);
        if(tmp.isPresent()) {
            contractRepository.deleteById(id);
        }else {
            throw new NotFoundException("Contract not found or already deleted");
        }
    }

    @Override
    public ContractDto saveContract(ContractDto contractDto, ContractOptionDto contractOptionDto) {
        Contract contract = modelMapper.map(contractDto, Contract.class);
        ContractOption contractOption = modelMapper.map(contractOptionDto, ContractOption.class);
        if (contract.isWithOption()){
           contractRepository.save(contract);
        } else {
            contractRepository.save(contract);
        }
        return displayContractById(contract.getId());
    }




//    @Override
//    public ContractDto saveContract(ContractDto contractDto) {
//        Contract contract = modelMapper.map(contractDto, Contract.class);
//
//        // save each options
//        contractRepository.save(contract);
//        return displayContractById(contract.getId());
//    }
}
