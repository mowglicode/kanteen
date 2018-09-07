package io.kanteen.service.impl;

import io.kanteen.dto.AccountDto;
import io.kanteen.dto.AdminDto;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Admin;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.persistance.repository.IAdminRepository;
import io.kanteen.persistance.repository.IParentRepository;
import io.kanteen.service.IParentService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AdminService adminService;

    @Autowired
    AccountService accountService;

    @Autowired
    IParentRepository parentRepository;

    @Autowired
    IParentService parentService;

    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    IAccountRepository accountRepository;

    AccountDto accdir;
    AdminDto director;

    @org.junit.Before
    public void setUp() throws Exception {
        director = new AdminDto("jeanne@zed.zed","jeanne");
        accdir = accountService.saveAccount(director.getAccount());
    }

    @org.junit.After
    public void tearDown() throws Exception {
        List<Admin> par = adminRepository.findAll();
        if(par.size()>=1){
            for(Admin a:par){
                adminService.deleteAdmin(a.getId());
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
    public void saveAdmin() {
        AdminDto result = adminService.saveAdmin(director);
        assertTrue(result.getId()>0);

        //test if isAdmin property can be reached
        Optional<Admin> admin = adminRepository.findById(director.getId());
        if (admin.isPresent()) {
            Admin a = modelMapper.map(admin.get(), Admin.class);

            assertTrue(a.isAdmin());
        }
    }

    @Test
    public void getAdminById() {
        AdminDto admin = adminService.saveAdmin(director);
        AdminDto result = adminService.getAdminById(admin.getId());
        assertTrue(result.getId()>0);
    }

    @Test
    public void deleteAdmin() {
        AdminDto admin = adminService.saveAdmin(director);
        List<Admin> res = adminRepository.findAll();
        assertTrue(res.size()>0);

        adminService.deleteAdmin(admin.getId());
        res = adminRepository.findAll();
        assertTrue(res.size()==0);

    }
}