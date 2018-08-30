package io.kanteen.service.impl;

import io.kanteen.dto.ChildDto;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.repository.IChildRepository;
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
public class ChildServiceTest {

    @Autowired ChildService service;

    @Autowired
    private IChildRepository childRepository;

    ChildDto childDto;
    List <ChildDto> tmp;

    @Before
    public void setUp() throws Exception {
        ChildDto MiniJo = new ChildDto("MiniJo", "cp");
        ChildDto Bobby = new ChildDto("Bobby", "cm1");
        service.saveChild(MiniJo);
        service.saveChild(Bobby);
    }



    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayChildren() {
        tmp = service.displayChildren();
        assertEquals(2, tmp.size());
    }

    @Test
    public void displayChildrenById() {
        ChildDto c = service.displayChildrenById(1);
        assertEquals("MiniJo", c.getName());
    }

    @Test
    public void deleteChildren() {
        service.deleteChildren(1);
        service.deleteChildren(2);
        tmp = service.displayChildren();
        assertEquals(0, tmp.size());
    }

    @Test
    public void saveChild() {
        tmp = service.displayChildren();
        assertEquals(2, tmp.size());
        ChildDto jack = new ChildDto("Jack", "cm2");
        service.saveChild(jack);
        tmp = service.displayChildren();
        assertEquals(3, tmp.size());
        assertEquals("MiniJo", tmp.get(0).getName());
        assertEquals("Bobby", tmp.get(1).getName());
        assertEquals("Jack", tmp.get(2).getName());
    }
}