package io.kanteen.service.impl;

import io.kanteen.dto.ContractAnswerDto;
import io.kanteen.dto.ContractDto;
import io.kanteen.persistance.entity.ContractAnswer;
import io.kanteen.persistance.repository.IContractAnswerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ContractAnswerServiceTest {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ContractAnswerDto contractAnswerDto;

    @Autowired
    IContractAnswerRepository contractAnswerRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayContractAnswersDto() {

    }

    @Test
    public void displayContractAnswerDtoByContractId() {
    }

    @Test
    public void deleteContractAnswer() {
    }

    @Test
    public void saveContractAnswer() {

        ContractAnswer contractAnswer = modelMapper.map(contractAnswerDto, ContractAnswer.class);
        contractAnswer = contractAnswerRepository.save(contractAnswer);
        assertEquals(1, contractAnswer.getId());
    }
}