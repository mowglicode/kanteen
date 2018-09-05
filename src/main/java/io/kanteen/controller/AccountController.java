package io.kanteen.controller;

import io.kanteen.dto.AccountDto;
import io.kanteen.persistance.entity.Account;
import io.kanteen.service.IAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @ApiOperation(value = "Get accounts")
    @RequestMapping(method = RequestMethod.GET)
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @ApiOperation(value = "Get account by ID")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AccountDto getAccoundById(@PathVariable long id){
        return accountService.getAccountById(id);
    }

    @ApiOperation(value = "Save account")
    @RequestMapping(method = RequestMethod.POST)
    public AccountDto saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @ApiOperation(value = "Delete account by ID")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteAccount(long id){
        accountService.deleteAccount(id);
    }

    @ApiOperation(value = "Get account by email")
    @RequestMapping(value = "/{email}",method = RequestMethod.GET)
    public AccountDto getAccountByEmail(@PathVariable String email){
        return accountService.getAccountByEmail(email);
    }


    @ApiOperation(value = "Get isAdmin by email")
    @RequestMapping(value = "/isAdmin/{email}",method = RequestMethod.GET)
    public boolean getIsAdminByEmail(@PathVariable String email){
        return accountService.getIsAdminByEmail(email);
    }
}
