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
    ChildDto miniJo;
    ChildDto bobby;

    @Before
    public void setUp() throws Exception {
        this.miniJo = new ChildDto("MiniJo", "cp");
        this.bobby = new ChildDto("Bobby", "cm1");
    }



    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayChildren() {
        service.saveChild(this.miniJo);
        service.saveChild(this.bobby);
        tmp = service.displayChildren();
        assertEquals(2, tmp.size());
        service.deleteChildren(1);
        service.deleteChildren(2);
    }

    @Test
    public void displayChildrenById() {
        service.saveChild(this.miniJo);
        service.saveChild(this.bobby);
        ChildDto c = service.displayChildrenById(1);
        assertEquals("MiniJo", c.getName());
        ChildDto d = service.displayChildrenById(2);
        assertEquals("Bobby", d.getName());
        service.deleteChildren(1);
        service.deleteChildren(2);
    }


    @Test
    public void deleteChildren() {
        service.saveChild(this.miniJo);
        service.saveChild(this.bobby);
        service.deleteChildren(1);
        service.deleteChildren(2);
        tmp = service.displayChildren();
        assertEquals(0, tmp.size());
    }

    @Test
    public void saveChild() {
        service.saveChild(this.miniJo);
        service.saveChild(this.bobby);
        tmp = service.displayChildren();
        assertEquals(2, tmp.size());
        ChildDto jack = new ChildDto("Jack", "cm2");
        service.saveChild(jack);
        tmp = service.displayChildren();
        assertEquals(3, tmp.size());
        assertEquals("MiniJo", tmp.get(0).getName());
        assertEquals("Bobby", tmp.get(1).getName());
        assertEquals("Jack", tmp.get(2).getName());
        service.deleteChildren(1);
        service.deleteChildren(2);
        service.deleteChildren(3);
    }
}