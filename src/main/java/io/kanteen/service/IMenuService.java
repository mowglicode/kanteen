package io.kanteen.service;

import io.kanteen.dto.MenuDto;
import io.kanteen.persistance.entity.Menu;

import java.util.List;

public interface IMenuService {

    MenuDto saveMenu(Menu menu);
    MenuDto getMenuById(long id);
    void delete(long id);
    List<MenuDto> getAllMenus();
}
