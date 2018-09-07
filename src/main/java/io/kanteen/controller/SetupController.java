package io.kanteen.controller;

import io.kanteen.dto.ParentDtoLight;
import io.kanteen.service.ISetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dbcreate")
public class SetupController {

    @Autowired
    public ISetupService service;


    @RequestMapping(method = RequestMethod.GET)
    public void setUp() {
        service.setUp();
    }
}
