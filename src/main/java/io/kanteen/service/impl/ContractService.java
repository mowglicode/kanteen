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

        for (Contract c : tmp) {
            contracts.add(this.displayContractById(c.getId()));
        }
        return contracts;
    }

    @Override
    public ContractDto displayContractById(long id) {
        Optional<Contract> contractMaybe = contractRepository.findById(id);
        if (contractMaybe.isPresent()) {

            // Entities
            Contract contract = contractMaybe.get();
            List<ContractOption> options = contractOptionRepository.findByContract(contract);

            ContractDto dto = modelMapper.map(contract, ContractDto.class);
            for (ContractOption option : options) {
                ContractOptionDto optionDto = modelMapper.map(option, ContractOptionDto.class);
                dto.addOption(optionDto);
            }
            return dto;

        } else {
            throw new NotFoundException("Contract not found");
        }
    }

    @Override
    public void deleteContract(long id) {

        Optional<Contract> tmp = contractRepository.findById(id);
        if (tmp.isPresent()) {

            List<ContractOption> options = contractOptionRepository.findByContract(tmp.get());
            options.forEach(contractOption -> contractOptionRepository.delete(contractOption));

            contractRepository.deleteById(id);
        } else {
            throw new NotFoundException("Contract not found or already deleted");
        }
    }


    @Override
    public ContractDto saveContract(ContractDto contractDto) {

        Contract contract = modelMapper.map(contractDto, Contract.class);
        contractRepository.save(contract);

        if (contractDto.getOptions() != null) {
            List<ContractOptionDto> optionsDto = contractDto.getOptions();
            for (ContractOptionDto optionDto : optionsDto) {
                ContractOption option = modelMapper.map(optionDto, ContractOption.class);
                option.setContract(contract);
                contractOptionRepository.save(option);
            }
        }
        return displayContractById(contract.getId());
    }

}
