package io.kanteen.controller;

import io.kanteen.dto.AdminDto;
import io.kanteen.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "Save new admin")
    @RequestMapping(method = RequestMethod.POST)
    public AdminDto saveAdmin(@RequestBody AdminDto adminDto) {
        return adminService.saveAdmin(adminDto);
    }

    @ApiOperation(value = "Get admin by ID")
    @RequestMapping(method = RequestMethod.GET)
    public AdminDto getAdminById(long id){
        return adminService.getAdminById(id);
    }

    @ApiOperation(value = "Delete admin by ID")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteAdmin(@PathVariable long id) {
        adminService.deleteAdmin(id);
    }

    @ApiOperation(value = "Get admin by email")
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public AdminDto getParentByEmail(@PathVariable(name = "email") String email){
        return adminService.getAdminByEmail(email);
    }
}
