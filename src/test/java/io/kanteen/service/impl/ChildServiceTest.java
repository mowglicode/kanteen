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
        miniJo = new ChildDto("MiniJo", "cp");
        bobby = new ChildDto("Bobby", "cm1");
    }



    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayChildren() {
        ChildDto m = service.saveChild(this.miniJo);
        ChildDto b = service.saveChild(this.bobby);
        tmp = service.displayChildren();
        assertEquals(2, tmp.size());
        service.deleteChildren(m.getId());
        service.deleteChildren(b.getId());
    }

    @Test
    public void displayChildrenById() {
        ChildDto m = service.saveChild(this.miniJo);
        ChildDto b = service.saveChild(this.bobby);
        ChildDto c = service.displayChildrenById(m.getId());
        assertEquals("MiniJo", c.getName());
        ChildDto d = service.displayChildrenById(b.getId());
        assertEquals("Bobby", d.getName());
        service.deleteChildren(c.getId());
        service.deleteChildren(d.getId());
    }


    @Test
    public void deleteChildren() {
        ChildDto m = service.saveChild(this.miniJo);
        ChildDto b = service.saveChild(this.bobby);
        service.deleteChildren(m.getId());
        service.deleteChildren(b.getId());
        tmp = service.displayChildren();
        assertEquals(0, tmp.size());
    }

    @Test
    public void saveChild() {
        ChildDto m = service.saveChild(this.miniJo);
        ChildDto b = service.saveChild(this.bobby);
        tmp = service.displayChildren();
        assertEquals(2, tmp.size());
        ChildDto jack = new ChildDto("Jack", "cm2");
        ChildDto j = service.saveChild(jack);
        tmp = service.displayChildren();
        assertEquals(3, tmp.size());
        assertEquals("MiniJo", m.getName());
        assertEquals("Bobby", b.getName());
        assertEquals("Jack", j.getName());
        service.deleteChildren(m.getId());
        service.deleteChildren(b.getId());
        service.deleteChildren(j.getId());
        tmp = service.displayChildren();
        assertEquals(0, tmp.size());
    }
}