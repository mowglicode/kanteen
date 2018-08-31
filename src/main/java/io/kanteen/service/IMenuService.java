package io.kanteen.service;

import io.kanteen.dto.MenuDto;

import java.util.List;

public interface IMenuService {

    MenuDto saveMenu(MenuDto menuDto);
    MenuDto getMenuById(long id);
    void delete(long id);
    List<MenuDto> getAllMenus();
}
