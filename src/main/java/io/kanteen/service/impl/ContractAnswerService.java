package io.kanteen.service.impl;

import io.kanteen.dto.ContractAnswerDto;
import io.kanteen.dto.ContractDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Contract;
import io.kanteen.persistance.entity.ContractAnswer;
import io.kanteen.persistance.repository.IContractAnswerRepository;
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
    private ModelMapper modelMapper;

    @Override
    public List<ContractAnswerDto> displayContractAnswersDto(){

        List<ContractAnswer> ca = contractAnswerRepository.findAll();
        List<ContractAnswerDto> contractAnswers = new ArrayList<>();

        for (ContractAnswer c : ca){
            contractAnswers.add(modelMapper.map(c, ContractAnswerDto.class));
        }
        return contractAnswers;
    }

    @Override
    public ContractAnswerDto displayContractAnswerDtoById(long id) {

        Optional<ContractAnswer> ca = contractAnswerRepository.findById(id);
        if (ca.isPresent()){
            return modelMapper.map(ca.get(), ContractAnswerDto.class);
        }else{
            throw new NotFoundException("Contract doesn't have any option");
        }

    }

    @Override
    public void deleteContractAnswer(long id) {
        Optional<ContractAnswer> ca = contractAnswerRepository.findById(id);
        if(ca.isPresent()){
            contractAnswerRepository.deleteById(id);
        }else{
            throw new NotFoundException("Not answer yet");
        }
    }

    @Override
    public ContractAnswerDto saveContractAnswer(ContractAnswerDto contractAnswerDto) {

        ContractAnswer contractAnswer = modelMapper.map(contractAnswerDto, ContractAnswer.class);
        contractAnswerRepository.save(contractAnswer);
        return displayContractAnswerDtoById(contractAnswer.getId());
    }
}
