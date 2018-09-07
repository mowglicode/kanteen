package io.kanteen.service.impl;

import io.kanteen.persistance.repository.IContractAnswerRepository;
import io.kanteen.persistance.repository.IContractOptionRepository;
import io.kanteen.persistance.repository.IContractRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ContractAnswerServiceTest {

    @Autowired ContractAnswerService contractAnswerService;

    @Autowired ContractService contractService;

    @Autowired private IContractRepository contractRepository;

    @Autowired private IContractOptionRepository contractOptionRepository;

    @Autowired private IContractAnswerRepository contractAnswerRepository;



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

    }
}