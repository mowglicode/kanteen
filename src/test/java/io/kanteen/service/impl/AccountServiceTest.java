package io.kanteen.service.impl;

import io.kanteen.dto.AccountDto;
import io.kanteen.persistance.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {



    @Autowired AccountService service;

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveAccount(){

        AccountDto accountLuck= new AccountDto();
        accountLuck.setEmail("lucky@luck.com");
        accountLuck.setPhone("06.12.34.56.78");

        AccountDto luck = service.saveAccount(accountLuck);

        assertTrue(luck.getId() > 0);

        service.deleteAccount(luck.getId());
    }

    @Test
    public void deleteAccount (){
        AccountDto samDto = new AccountDto();
        samDto.setEmail("toto@mail.com");
        samDto.setPhone("06.12.34.56.78");

        AccountDto sam = service.saveAccount(samDto);
        service.deleteAccount(sam.getId());

        assertFalse(sam.getEmail() == "sam@mail.com");

    }

    @Test
    public void getAccountById(){
        AccountDto anaDto = new AccountDto();
        anaDto.setEmail("ana@mail.com");
        anaDto.setPhone("06.12.34.56.79");

        anaDto = service.saveAccount(anaDto);
        AccountDto ana = service.getAccountById(anaDto.getId());
        assertEquals(ana.getId(), anaDto.getId());
        service.deleteAccount(ana.getId());

    }

    @Test
    public void getAllAccounts(){
        AccountDto raymond = new AccountDto();
        raymond.setEmail("raymond@brady.nfl");
        raymond.setPhone("0101010101");

        AccountDto travis = new AccountDto();
        travis.setEmail("travis@brady.nfl");
        travis.setPhone("0202020202");

        AccountDto kevin = new AccountDto();
        kevin.setEmail("kevin@brady.fr");
        kevin.setPhone("0303030303");

        raymond = service.saveAccount(raymond);
        travis = service.saveAccount(travis);
        kevin = service.saveAccount(kevin);

        List<AccountDto> accounts = service.getAllAccounts();
        assertEquals(3, accounts.size());

        service.deleteAccount(raymond.getId());
        service.deleteAccount(travis.getId());
        service.deleteAccount(kevin.getId());

    }
}