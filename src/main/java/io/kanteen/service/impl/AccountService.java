package io.kanteen.service.impl;

import io.kanteen.dto.AccountDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.service.IAccountService;
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
    private ModelMapper modelMapper;

    @Override
    public AccountDto saveAccount(Account account) {
        Account accountService = modelMapper.map(account,Account.class);
        accountRepository.save(account);
        return getAccountById(accountService.getId());
    }

    // overloading
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
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
}
