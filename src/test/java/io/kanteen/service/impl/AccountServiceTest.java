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

    private static boolean setupIsDone = false;

    @Autowired AccountService service;

    @org.junit.Before
    public void setUp() throws Exception {
        if (setupIsDone) {
            return;
        }

        Account raymond = new Account();
        raymond.setEmail("raymond@brady.nfl");
        raymond.setPhone("0101010101");

        Account travis = new Account();
        travis.setEmail("travis@brady.nfl");
        travis.setPhone("0202020202");

        Account kevin = new Account();
        kevin.setEmail("kevin@brady.fr");
        kevin.setPhone("0303030303");

        AccountDto raymondDto = service.saveAccount(raymond);
        AccountDto travisDto = service.saveAccount(travis);
        AccountDto kevinDto = service.saveAccount(kevin);
        setupIsDone = true;
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveAccount(){

        Account accountLuck= new Account();
        accountLuck.setEmail("lucky@luck.com");
        accountLuck.setPhone("06.12.34.56.78");

        AccountDto luck = service.saveAccount(accountLuck);

        assertTrue(luck.getId() > 0);

        service.deleteAccount(luck.getId());
    }

    @Test
    public void deleteAccount (){
        Account sam = new Account();
        sam.setEmail("toto@mail.com");
        sam.setPhone("06.12.34.56.78");

        AccountDto samDto = service.saveAccount(sam);
        service.deleteAccount(sam.getId());

        assertFalse(samDto.getEmail() == "sam@mail.com");

    }

    @Test
    public void getAccountById(){
        Account ana = new Account();
        ana.setEmail("ana@mail.com");
        ana.setPhone("06.12.34.56.79");

       AccountDto anaDto = service.saveAccount(ana);
         anaDto = service.getAccountById(anaDto.getId());
        assertEquals(ana.getId(), anaDto.getId());
        service.deleteAccount(ana.getId());

    }

    @Test
    public void getAllAccounts(){
        List<AccountDto> accounts = service.getAllAccounts();
        assertEquals(3, accounts.size());
    }
}