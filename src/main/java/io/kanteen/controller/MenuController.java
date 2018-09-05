package io.kanteen.controller;

import io.kanteen.dto.MenuDto;
import io.kanteen.persistance.entity.Menu;
import io.kanteen.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MenuDto getMenuById(@PathVariable(name = "id") long id) { return menuService.getMenuById(id);}

    @RequestMapping(method = RequestMethod.GET)
    public List<MenuDto> getAllMenus() { return  menuService.getAllMenus(); }

    @RequestMapping(method = RequestMethod.POST)
    public MenuDto saveMenu(@RequestBody Menu menu) { return menuService.saveMenu(menu); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {  menuService.delete(id); }


}
