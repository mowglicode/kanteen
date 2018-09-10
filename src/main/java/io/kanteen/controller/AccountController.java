package io.kanteen.controller;

import io.kanteen.dto.AccountDto;
import io.kanteen.service.IAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
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
    public AccountDto getAccountById(@PathVariable long id){
        return accountService.getAccountById(id);
    }

    @ApiOperation(value = "Get isAdmin by email")
    @RequestMapping(value = "/isAdmin/{email}",method = RequestMethod.GET)
    public boolean getIsAdminByEmail(@PathVariable String email){
        return accountService.getIsAdminByEmail(email);
    }

    @ApiOperation(value = "Check credentials")
    @RequestMapping(value = "/login/{email}/{pass}",method = RequestMethod.GET)
    public boolean getIsAdminByEmailAndPass(@PathVariable(name="email")String email, @PathVariable(name = "pass")String pass){
        return accountService.getIsAdminByEmailAndPass(email,pass);
    }

    @ApiOperation(value = "Save account")
    @RequestMapping(method = RequestMethod.POST)
    public AccountDto saveAccount(@RequestBody AccountDto accountDto){
        return accountService.saveAccount(accountDto);
    }

    @ApiOperation(value = "Delete account by ID")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteAccount(long id){
        accountService.deleteAccount(id);
    }


}
