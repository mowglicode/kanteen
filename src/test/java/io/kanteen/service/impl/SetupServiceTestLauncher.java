package io.kanteen.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetupServiceTestLauncher {

    @Autowired
    SetupService service;

    @Test
    public void setUp(){
        service.setUp();
    }

    @Test
    public void tearDown(){
        service.tearDown();
    }


}
