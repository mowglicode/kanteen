package io.kanteen.service.impl;

import io.kanteen.dto.AccountDto;
import io.kanteen.dto.ChildDto;
import io.kanteen.dto.ParentDtoFull;
import io.kanteen.dto.ParentDtoLight;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.persistance.repository.IChildRepository;
import io.kanteen.persistance.repository.IParentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

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

    ParentDtoFull henri;
    ParentDtoFull david;
    ChildDto julie;
    AccountDto accHenri;

    @org.junit.Before
    public void setUp() throws Exception {
        henri = new ParentDtoFull("henri","h@dd.com");
        david = new ParentDtoFull("david","hddd@dd.com");
        accHenri = accountService.saveAccount(henri.getAccount());

        julie = new ChildDto("julie","cp");
        childService.saveChild(julie);

    }

    @org.junit.After
    public void tearDown() throws Exception {

        List<Parent> par = parentRepository.findAll();
        if(par.size()>=1){
            for(Parent a:par){
                service.deleteParent(a.getId());
            }
        }
        List<Child> chi = childRepository.findAll();
        if(chi.size()>=1){
            for(Child c: chi){
                childRepository.deleteById(c.getId());
            }
        }
        List<Account> acc = accountRepository.findAll();
        if(acc.size()>=1){
            for(Account a: acc){
                accountRepository.deleteById(a.getId());
            }
        }
    }

    @Test
    public void saveParentWithIdAccount() {
        ParentDtoFull p = service.saveParentWithIdAccount(henri,accHenri.getId());
        assertTrue(p.getAccount().getId() == accHenri.getId());
        assertTrue(service.displayAllParents().size()>0);
    }

    @Test
    public void displayAllParents() {
        service.saveParent(henri);
        service.saveParent(david);
        List<ParentDtoLight> p = service.displayAllParents();
        System.out.println(p.size());
        assertTrue(p.size()==2);
    }

    @Test
    public void saveParent() {
        ParentDtoFull ph = service.saveParent(henri);
        ParentDtoFull pd = service.saveParent(david);
        assertTrue(ph.getId()>0);
        assertTrue(pd.getId()>0);
    }

    @Test
    public void saveAndRemoveParentWithChildId() {
        ChildDto jsaved = childService.saveChild(julie);
        ParentDtoFull pdh = service.saveParentWithChildId(henri,jsaved.getId());
        assertTrue(pdh.getChildren().size()==1);

        ParentDtoFull psaved = service.saveParent(henri);
        pdh = service.removeChildFromParent(pdh.getId(),jsaved.getId());
        assertTrue(pdh.getChildren().size()==0);

    }
}



