package io.kanteen.service.impl;

import io.kanteen.dto.ParentDtoFull;
import io.kanteen.persistance.entity.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentServiceTest {

    @Autowired ParentService service;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayAllParents() {


        service.displayAllParents();
    }

    @Test
    public void saveParent() {
        ParentDtoFull parentDtoFull = new ParentDtoFull("JoDalton", "joDalton@jo.com");

        ParentDtoFull p = service.saveParent(parentDtoFull);

        assertTrue(p.getId()>0);

        // Cleaning
        service.deleteParent(p.getId());

        // Should check account id deleted
    }
}