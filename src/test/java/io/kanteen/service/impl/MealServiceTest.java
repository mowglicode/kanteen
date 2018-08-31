package io.kanteen.service.impl;

import io.kanteen.dto.ChildDto;
import io.kanteen.dto.MealDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealServiceTest {

    @Autowired
    MealService mealService;
    @Autowired
    ChildService childService;

    @Autowired
    ModelMapper modelMapper;

    ChildDto childDto;
    ChildDto childDto2;
    ChildDto childAvecId;
    ChildDto childAvecId2;
    String dateString;

    @org.junit.Before
    public void setUp() throws Exception {
        // sans id car pas persistes
        childDto = new ChildDto("Dina", "CM2");
        childDto2 = new ChildDto("Tom", "CM2");
        // avec id car persistes avec save
        childAvecId = childService.saveChild(childDto);
        childAvecId2 = childService.saveChild(childDto2);
        dateString = "2018-08-30";
    }

    @org.junit.After
    public void tearDown() throws Exception {
        childService.deleteChildren(childAvecId.getId());
        childService.deleteChildren(childAvecId2.getId());
    }

    @Test
    public void getAllMeals() {

        Date day = new Date();

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateString);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);

        //assert get
        List<MealDto> allMeals = mealService.getAllMeals();
        assertTrue(allMeals.size() > 0);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());

    }


    @Test
    public void saveMealNoDto() {

        Date day = new Date();

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateString);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());


    }

    @Test
    public void deleteMealById() {

        Date day = new Date();

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateString);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());
        assertTrue(mealService.getAllMeals().size()==0);

    }

    @Test
    public void getMealsByDay() {
//        Date day = new Date();
//        Date day2 = new Date(day.getTime()+1000 * 60 * 60 * 25);

        String dateTest = "2018-05-25";
        String dateTest2 = "2018-05-24";

//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateTest);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateTest);
        MealDto m3 = mealService.saveMealNoDto(childAvecId2.getId(), dateTest2);

        List<MealDto> listMeals = mealService.getMealsByDay(dateTest);
        assertTrue(listMeals.size()==2);

        //sup les meals
        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());
        mealService.deleteMealById(m3.getId());
    }
}