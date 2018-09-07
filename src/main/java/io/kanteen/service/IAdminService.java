package io.kanteen.service;

import io.kanteen.dto.AdminDto;

public interface IAdminService {
    AdminDto saveAdmin(AdminDto adminDto);
    AdminDto getAdminById(long id);
    void deleteAdmin(long id);
    AdminDto getAdminByEmail(String email);
}
