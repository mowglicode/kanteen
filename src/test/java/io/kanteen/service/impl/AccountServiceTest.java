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

        AccountDto raymond = new AccountDto();
        raymond.setEmail("raymond@brady.nfl");
        raymond.setPhone("0101010101");

        AccountDto travis = new AccountDto();
        travis.setEmail("travis@brady.nfl");
        travis.setPhone("0202020202");

        AccountDto kevin = new AccountDto();
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

        AccountDto accountLuck= new AccountDto();
        accountLuck.setEmail("lucky@luck.com");
        accountLuck.setPhone("06.12.34.56.78");

        AccountDto luck = service.saveAccount(accountLuck);

        assertTrue(luck.getId() > 0);

        service.deleteAccount(luck.getId());
    }

    @Test
    public void deleteAccount (){
        AccountDto totoAccount= new AccountDto();
        totoAccount.setEmail("toto@mail.com");
        totoAccount.setPhone("06.12.34.56.78");

        AccountDto toto = service.saveAccount(totoAccount);
        service.deleteAccount(toto.getId());

        assertFalse(toto.getEmail() == "toto@mail.com");

    }

    @Test
    public void getAccountById(){
        AccountDto titiAccount = new AccountDto();
        titiAccount.setEmail("titi@mail.com");
        titiAccount.setPhone("06.12.34.56.79");

       AccountDto titiDto = service.saveAccount(titiAccount);
        AccountDto titi = service.getAccountById(titiDto.getId());
        assertEquals(titi.getId(), titiDto.getId());
        assertTrue(titi.getEmail().equals("titi@mail.com"));
        service.deleteAccount(titi.getId());

    }

    @Test
    public void getAllAccounts(){
        List<AccountDto> accounts = service.getAllAccounts();
        assertEquals(3, accounts.size());
    }
}