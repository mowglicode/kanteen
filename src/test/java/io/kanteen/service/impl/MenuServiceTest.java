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
    private static boolean tearIsDone = false;

    @Autowired MenuService service;

    MenuDto lundi;
    MenuDto mardi;
    MenuDto mercredi;

    @Before
    public void setUp() throws Exception{

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
        service.delete(dejeuner.getId());
    }

    @Test
    public void getMenuById() {
        MenuDto menuViande = new MenuDto();
        menuViande.setContent("poulet");

       MenuDto poulet = service.saveMenu(menuViande);
        MenuDto viande= service.getMenuById(poulet.getId());
        assertEquals(poulet.getId(), viande.getId());
        service.delete(poulet.getId());
    }

    @Test
    public void getAllMenus() {

        MenuDto lundi = new MenuDto();
        lundi.setContent("sauceGombo");

        MenuDto mardi = new MenuDto();
        mardi.setContent("pouletYassa");

        MenuDto mercredi = new MenuDto();
        mercredi.setContent("grillade");

        lundi = service.saveMenu(lundi);
        mardi = service.saveMenu(mardi);
        mercredi = service.saveMenu(mercredi);

        List<MenuDto> menus = service.getAllMenus();

        assertEquals(3, menus.size());
        
        service.delete(lundi.getId());
        service.delete(mardi.getId());
        service.delete(mercredi.getId());
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