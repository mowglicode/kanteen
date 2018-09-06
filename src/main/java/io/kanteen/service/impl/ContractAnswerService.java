package io.kanteen.service.impl;

import io.kanteen.dto.ContractAnswerDto;
import io.kanteen.dto.ContractDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Contract;
import io.kanteen.persistance.entity.ContractAnswer;
import io.kanteen.persistance.entity.ContractOption;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IContractAnswerRepository;
import io.kanteen.persistance.repository.IContractOptionRepository;
import io.kanteen.persistance.repository.IContractRepository;
import io.kanteen.persistance.repository.IParentRepository;
import io.kanteen.service.IContractAnswerService;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractAnswerService implements IContractAnswerService {

    @Autowired
    private IContractAnswerRepository contractAnswerRepository;

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IContractOptionRepository contractOptionRepository;

    @Autowired
    private IParentRepository parentRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ContractService contractService;

    @Override
    // TODO: should probably by parent
    public List<ContractAnswerDto> displayContractAnswersDto() {

        List<ContractAnswer> ca = contractAnswerRepository.findAll();
        List<ContractAnswerDto> contractAnswers = new ArrayList<>();

        for (ContractAnswer c : ca) {
            contractAnswers.add(modelMapper.map(c, ContractAnswerDto.class));
        }
        return contractAnswers;
    }

    @Override
    public List<ContractAnswerDto> displayContractAnswerDtoByContractId(long id) {

        Optional<Contract> contractMaybe = contractRepository.findById(id);
        if (!contractMaybe.isPresent()) {
            throw new NotFoundException("Contract " + id + " does not exist");
        }
        Contract contract = contractMaybe.get();
        if (!contract.isWithOption()) {
            throw new NotFoundException("Contract doesn't have any option");
        }

        List<ContractAnswer> answers = this.contractAnswerRepository.findContractAnswerByContract(contract);

        List<ContractAnswerDto> result = new ArrayList<>();
        for (ContractAnswer answer : answers) {
            ContractAnswerDto answerDto = modelMapper.map(answer, ContractAnswerDto.class);
            result.add(answerDto);
        }
        return result;


    }

    @Override
    public void deleteContractAnswer(long id) {
        Optional<ContractAnswer> ca = contractAnswerRepository.findById(id);
        if (ca.isPresent()) {
            contractAnswerRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not answer yet");
        }
    }

    @Override
    public ContractAnswerDto saveContractAnswer(ContractAnswerDto dto) {

        ContractAnswer contractAnswer = modelMapper.map(dto, ContractAnswer.class);
        System.out.println("parentid : " + dto.getParent().getAccount().getId());
        // very bad !!!
        Parent parent = parentRepository.findParentByAccountId(dto.getParent().getAccount().getId()).get();
        Contract contract = contractRepository.findById(dto.getContract().getId()).get();
        System.out.println("option : "+dto.getOption().getId());

        ContractOption option = contractOptionRepository.findById(dto.getOption().getId()).get();

        contractAnswer.setOption(option);
        contractAnswer.setContract(contract);
        contractAnswer.setParent(parent);

        contractAnswer = contractAnswerRepository.save(contractAnswer);
        return modelMapper.map(contractAnswer, ContractAnswerDto.class);
    }
}
