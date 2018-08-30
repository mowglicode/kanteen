package io.kanteen.service.impl;

import io.kanteen.dto.MenuDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    private static boolean setupIsDone = false;

    @Autowired MenuService service;

    @Before
    public void setUp() throws Exception{
        if (setupIsDone){
            return;
        }

        MenuDto lundiDto = new MenuDto();
        lundiDto.setContent("sauceGombo");

        MenuDto mardiDto = new MenuDto();
        mardiDto.setContent("pouletYassa");

        MenuDto mercrediDto = new MenuDto();
        mercrediDto.setContent("grillade");

        MenuDto lundi = service.saveMenu(lundiDto);
        MenuDto mardi = service.saveMenu(mardiDto);
        MenuDto mercredi = service.saveMenu(mercrediDto);
        setupIsDone=true;
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void saveMenu() {
        MenuDto menuDejeuner = new MenuDto();
        menuDejeuner.setContent("puree");
         MenuDto dejeuner = service.saveMenu(menuDejeuner);

         assertTrue(dejeuner.getId()>0);
    }

    @Test
    public void getMenuById() {
        MenuDto menuViande = new MenuDto();
        menuViande.setContent("poulet");

       MenuDto poulet = service.saveMenu(menuViande);
        MenuDto viande= service.getMenuById(poulet.getId());
        assertEquals(poulet.getId(), viande.getId());
    }

    @Test
    public void getAllMenus() {
        List<MenuDto> menus = service.getAllMenus();
        assertEquals(3, menus.size());
    }

    @Test
    public void delete() {
        MenuDto menuPatte = new MenuDto();
        menuPatte.setContent("patte");
        MenuDto patte= service.saveMenu(menuPatte);
        service.delete(patte.getId());

        assertFalse(patte.getContent() == "patte");
    }
}