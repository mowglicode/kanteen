package io.kanteen.service.impl;

import io.kanteen.dto.MenuDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Menu;
import io.kanteen.persistance.repository.IMenuRepository;
import io.kanteen.service.IMenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private IMenuRepository menuRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MenuDto saveMenu(Menu menu) {
        menuRepository.save(menu);
        return getMenuById(menu.getId());
    }

    @Override
    public MenuDto getMenuById(long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()) {
            return modelMapper.map(menu.get(), MenuDto.class);
        } else {
            throw new NotFoundException("Menu not found");
        }
    }

    @Override
    public List<MenuDto> getAllMenus() {
      List<Menu> tmp = menuRepository.findAll();
      List<MenuDto> menusDto = new ArrayList<>();

      for (Menu m : tmp) {
          menusDto.add(modelMapper.map(m, MenuDto.class));
      }
      return menusDto;
    }

    @Override
    public void delete(long id) {
        Optional<Menu> tmp = menuRepository.findById(id);
        if (tmp.isPresent()) {
            menuRepository.deleteById(id);
        } else {
            throw new NotFoundException("Menu not found, it can't be deleted !");
        }
    }


}
