package io.kanteen.controller;

import io.kanteen.service.IDateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/dates")
public class    DateController {

    @Autowired
    private IDateService dateService;

    @ApiOperation(value = "Get next days available for lunch",
            notes = "The deadline before the first next meal is set to 1 day, then the 5 next available days are displayed skipping wednesdays and week-ends")
    @RequestMapping(value = "/eatableday",method = RequestMethod.GET)
    public List<String> getNextDates(){
        return dateService.getNextDates();
    }

    @ApiOperation(value = "Get next 7 days for the summary")
    @RequestMapping(value = "/week",method = RequestMethod.GET)
    public List<String> getNextWeek(){
        return dateService.getNextWeek();
    }
}
