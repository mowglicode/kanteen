package io.kanteen.service.impl;

import io.kanteen.dto.AccountDto;
import io.kanteen.dto.ChildDto;
import io.kanteen.dto.ParentDtoFull;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.persistance.repository.IChildRepository;
import io.kanteen.persistance.repository.IParentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentServiceTest {

    @Autowired
    ParentService service;
    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    ChildService childService;
    @Autowired
    IParentRepository parentRepository;
    @Autowired
    IChildRepository childRepository;
    @Autowired
    AccountService accountService;

    ModelMapper modelMapper;

    ParentDtoFull parentDtoFull;

    Account parentAccount;


    ChildDto childDto;

    @org.junit.Before
    public void setUp() throws Exception {

        /**
         * Set up for testing saveParentWithIdAccount() function.
         */
        parentDtoFull = new ParentDtoFull("JeanneDo", "jeanne@jo.com");
        parentAccount = parentDtoFull.getAccount();
        System.out.println(parentAccount.getId());
        System.out.println("-----------------------");


        accountService.saveAccount(parentDtoFull.getAccount());

        childDto = new ChildDto();
        childDto.setName("Wilson");
        childDto.setGrade("cm2");
        childDto = childService.saveChild(childDto);


    }

    @org.junit.After
    public void tearDown() throws Exception {
        // Cleaning
        Optional<Parent> ParentTmp = parentRepository.findById(parentDtoFull.getId());
        if (ParentTmp.isPresent()) {
            service.deleteParent(parentAccount.getId());
        }
        Optional<Account> accountTmp = accountRepository.findById(parentAccount.getId());
        if (accountTmp.isPresent()) {
            accountRepository.delete(parentAccount);
        }
        Optional<Child> childTmp = childRepository.findById(childDto.getId());
        if (childTmp.isPresent()) {
            childService.deleteChildren(childTmp.get().getId());
        }
    }

    @Test
    public void saveParentWithIdAccount() {
        ParentDtoFull p = service.saveParentWithIdAccount(parentDtoFull, parentAccount.getId());
        assertTrue(p.getAccount().getId() == parentAccount.getId());
    }

    @Test
    public void displayAllParents() {


        service.displayAllParents();
    }

    @Test
    public void saveParent() {


        ParentDtoFull p = service.saveParent(parentDtoFull);

        assertTrue(p.getId() > 0);

        // Cleaning
        service.deleteParent(p.getId());

        // Should check account id deleted
    }

    @Test
    public void saveAndRemoveParentWithChildId() {


        // Save parent
        ParentDtoFull result = service.saveParentWithChildId(parentDtoFull, childDto.getId());
        assertTrue(result.getId() > 0);
        assertEquals(1, result.getChildren().size());
        result = service.removeChildFromParent(result.getId(), childDto.getId());
        assertEquals(0, result.getChildren().size());

    }



}



