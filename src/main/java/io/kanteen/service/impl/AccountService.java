package io.kanteen.service.impl;

import io.kanteen.dto.AccountDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Admin;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.persistance.repository.IAdminRepository;
import io.kanteen.persistance.repository.IParentRepository;
import io.kanteen.service.IAccountService;
import io.kanteen.service.IParentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAdminRepository adminRepository;
    @Autowired
    private IParentRepository parentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto saveAccount(Account account) {
        Account accountService = modelMapper.map(account,Account.class);
        accountRepository.save(account);
        return getAccountById(accountService.getId());
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto){
        Account account = modelMapper.map(accountDto,Account.class);
        accountRepository.save(account);
        return getAccountById(account.getId());
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> result = new ArrayList<>();
        for(Account a: accounts){
            result.add(modelMapper.map(a,AccountDto.class));
        }
        return result;
    }

    @Override
    public AccountDto getAccountById(long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return modelMapper.map(account.get(),AccountDto.class);
        } else {
            throw new NotFoundException("Account not found");
        }
    }

    @Override
    public void deleteAccount(long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.deleteById(id);
        } else {
            throw new NotFoundException("Account not found, it can't be deleted");
        }
    }

    @Override
    public AccountDto getAccountByEmail(String email) {
        Optional<Account> accountTmp = accountRepository.findByEmail(email);
        if (accountTmp.isPresent()) {
            return modelMapper.map(accountTmp.get(),AccountDto.class);
        }else {
            throw new NotFoundException("Email not found");
        }

    }

    @Override
    public boolean getIsAdminByEmail(String email) {
        Optional<Account> accountOpt = accountRepository.findByEmail(email);
        if (accountOpt.isPresent()) {
            Account account = modelMapper.map(accountOpt.get(),Account.class);
            Optional<Admin> adminOpt = adminRepository.findAdminByAccountId(account.getId());
            //if the accound is linked to an admin
            if (adminOpt.isPresent()) {
                Admin admin = modelMapper.map(adminOpt.get(),Admin.class);
                return admin.isAdmin();
                //else the account is linked to a parent
            } else {
                Optional<Parent> parentOpt = parentRepository.findParentByAccountId(account.getId());
                Parent parent = modelMapper.map(parentOpt.get(),Parent.class);
                return parent.isAdmin();
            }
        } else {
            throw new NotFoundException("Account not found with that email");
        }
    }
}
