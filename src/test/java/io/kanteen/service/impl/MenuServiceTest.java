package io.kanteen.service.impl;

import io.kanteen.dto.MenuDto;
import io.kanteen.persistance.entity.Menu;
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



    @Autowired MenuService service;


    @Before
    public void setUp() throws Exception{
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void saveMenu() {
        Menu menuDejeuner = new Menu();
        menuDejeuner.setContent("puree");
         MenuDto dejeuner = service.saveMenu(menuDejeuner);
         assertTrue(dejeuner.getId()>0);
        service.delete(dejeuner.getId());
    }

    @Test
    public void getMenuById() {
        Menu menuViande = new Menu();
        menuViande.setContent("poulet");

       MenuDto poulet = service.saveMenu(menuViande);
        MenuDto viande= service.getMenuById(poulet.getId());
        assertEquals(poulet.getId(), viande.getId());
        service.delete(poulet.getId());
    }

    @Test
    public void getAllMenus() {

        Menu lundi = new Menu();
        lundi.setContent("sauceGombo");

        Menu mardi = new Menu();
        mardi.setContent("pouletYassa");

        Menu mercredi = new Menu();
        mercredi.setContent("grillade");

        MenuDto lundiDto = service.saveMenu(lundi);
        MenuDto mardiDto = service.saveMenu(mardi);
        MenuDto mercrediDto = service.saveMenu(mercredi);

        List<MenuDto> menus = service.getAllMenus();

        assertEquals(3, menus.size());
        
        service.delete(lundi.getId());
        service.delete(mardi.getId());
        service.delete(mercredi.getId());
    }

    @Test
    public void delete() {

        Menu menuPatte = new Menu();
        menuPatte.setContent("patte");
        MenuDto patte= service.saveMenu(menuPatte);
        service.delete(patte.getId());

        assertFalse(patte.getContent() == "patte");
    }
}