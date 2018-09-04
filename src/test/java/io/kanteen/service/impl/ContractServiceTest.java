package io.kanteen.service.impl;

import io.kanteen.dto.ContractDto;
import io.kanteen.persistance.repository.IContractRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractServiceTest {

    @Autowired ContractService contractService;

    @Autowired private IContractRepository contractRepository;

    ContractDto contractDto;
    List<ContractDto> tmp;
    ContractDto contract1;
    ContractDto contract2;

    @Before
    public void setUp() throws Exception {
        contract1 = new ContractDto("Accord_données","blablabla" );
        contract2 = new ContractDto("Accord_sortie", "bloubloublou");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayContracts() {
        ContractDto c1 = contractService.saveContract(this.contract1);
        ContractDto c2 = contractService.saveContract(this.contract2);
        tmp = contractService.displayContracts();
        assertEquals(2, tmp.size());
        contractService.deleteContract(c1.getId());
        contractService.deleteContract(c2.getId());
    }

    @Test
    public void displayContractById() {
        ContractDto c1 = contractService.saveContract(this.contract1);
        ContractDto c2 = contractService.saveContract(this.contract2);
        ContractDto c1Id = contractService.displayContractById(c1.getId());
        assertEquals("Accord_données", c1Id.getTitle());
        ContractDto c2Id = contractService.displayContractById(c2.getId());
        assertEquals("Accord_sortie", c2Id.getTitle());
        contractService.deleteContract(c1.getId());
        contractService.deleteContract(c2.getId());
    }

    @Test
    public void deleteContract() {
        ContractDto c1 = contractService.saveContract(this.contract1);
        ContractDto c2 = contractService.saveContract(this.contract2);
        contractService.deleteContract(c1.getId());
        contractService.deleteContract(c2.getId());
        tmp = contractService.displayContracts();
        assertEquals(0, tmp.size());
    }

    @Test
    public void saveContract() {
        ContractDto c1 = contractService.saveContract(this.contract1);
        ContractDto c2 = contractService.saveContract(this.contract2);
        tmp = contractService.displayContracts();
        assertEquals(2, tmp.size());
        ContractDto contract3 = new ContractDto("Accord_paiement", "bliblibli");
        ContractDto c3 = contractService.saveContract(contract3);
        tmp = contractService.displayContracts();
        assertEquals(3, tmp.size());
        assertEquals("Accord_données", c1.getTitle());
        assertEquals("Accord_sortie", c2.getTitle());
        assertEquals("Accord_paiement", c3.getTitle());
        contractService.deleteContract(c1.getId());
        contractService.deleteContract(c2.getId());
        contractService.deleteContract(c3.getId());
        tmp = contractService.displayContracts();
        assertEquals(0, tmp.size());
    }


}