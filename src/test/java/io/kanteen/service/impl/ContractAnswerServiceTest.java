package io.kanteen.service.impl;

import io.kanteen.dto.ContractAnswerDto;
import io.kanteen.dto.ContractDto;
import io.kanteen.dto.ContractOptionDto;
import io.kanteen.dto.ParentDtoFull;
import io.kanteen.persistance.entity.ContractOption;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IContractOptionRepository;
import io.kanteen.persistance.repository.IContractRepository;
import io.kanteen.persistance.repository.IParentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractAnswerServiceTest {

    @Autowired
    ParentService service;

    @Autowired
    ContractService contractService;

    @Autowired
    ContractAnswerService answerService;

    @Autowired
    IParentRepository parentRepository;

    @Autowired private IContractRepository contractRepository;

    @Autowired private IContractOptionRepository contractOptionRepository;


    ContractDto contractDto;
    List<ContractDto> tmp;
    ContractDto contract1;
    ContractDto contract2;
    ParentDtoFull henri;

    @Before
    public void setUp() throws Exception {
        contract1 = new ContractDto("Accord_données","blablabla" );
        contract2 = new ContractDto("Accord_sortie", "bloubloublou");
        henri = new ParentDtoFull("henri","h@dd.com");
        henri = service.saveParent(henri);
    }

    @After
    public void tearDown() throws Exception {
        List<Parent> par = parentRepository.findAll();
        if(par.size()>=1){
            for(Parent a:par){
                service.deleteParent(a.getId());
            }
        }
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
        ContractDto c1 = contractService.saveContract(this.contract1);
        ContractDto c2 = contractService.saveContract(this.contract2);
        tmp = contractService.displayContracts();
        assertEquals(2, tmp.size());

        List<ContractOptionDto> choices = new ArrayList<>();
        ContractOptionDto contractOption1 = new ContractOptionDto( "choice1");
        ContractOptionDto contractOption2 = new ContractOptionDto("choice2");
        choices.add(contractOption1);
        choices.add(contractOption2);
        assertEquals(2, choices.size());
        assertEquals("choice1", choices.get(0).getOptionName());

        ContractDto contract3 = new ContractDto("Accord_paiement", "bliblibli", choices);
        ContractDto c3 = contractService.saveContract(contract3);

        tmp = contractService.displayContracts();


        ContractAnswerDto answerDto = new ContractAnswerDto();
        answerDto.setParent(henri);
        answerDto.setContract(c3);
        ContractOptionDto option  = contract3.getOptions().get(1);
        answerDto.setOption(option);



        answerDto = answerService.saveContractAnswer(answerDto);
        assertTrue(answerDto.getId() > 0);







    }
}