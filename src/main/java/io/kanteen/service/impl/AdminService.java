package io.kanteen.service.impl;

import io.kanteen.dto.AdminDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Admin;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.persistance.repository.IAdminRepository;
import io.kanteen.service.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminDto saveAdmin(AdminDto adminDto) {
        Admin admin = modelMapper.map(adminDto,Admin.class);
        Optional<Account> tmp = accountRepository.findById(admin.getId());
        if (tmp.isPresent()) {
            admin = adminRepository.save(admin);
        } else {
            Account account = modelMapper.map(adminDto.getAccount(),Account.class);
            account = accountRepository.save(account);
            admin.setAccount(account);
            adminRepository.save(admin);
        }

        return getAdminById(admin.getId());
    }

    @Override
    public AdminDto getAdminById(long id) {
        Optional<Admin> tmp = adminRepository.findById(id);
        if (tmp.isPresent()){
            return modelMapper.map(tmp.get(),AdminDto.class);
        } else {
            throw new NotFoundException("Admin not found");
        }
    }

    @Override
    public void deleteAdmin(long id) {
        Optional<Admin> tmp = adminRepository.findById(id);
        if (tmp.isPresent()) {
            adminRepository.deleteById(id);
        } else {
            throw new NotFoundException("Admin not found, it can't be deleted");
        }
    }
}
