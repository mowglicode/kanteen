package io.kanteen.service;

import io.kanteen.dto.ContractAnswerDto;
import io.kanteen.dto.ContractDto;
import io.kanteen.persistance.entity.ContractAnswer;

import java.util.List;

public interface IContractAnswerService {
    List<ContractAnswerDto> displayContractAnswersDto();
    ContractAnswerDto displayContractAnswerDtoById(long id);
    void deleteContractAnswer(long id);
    ContractAnswerDto saveContractAnswer(ContractAnswerDto contractAnswerDto);

}
