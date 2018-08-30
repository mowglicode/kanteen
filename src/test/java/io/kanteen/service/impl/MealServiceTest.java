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


    @org.junit.Before
    public void setUp() throws Exception {
        // sans id car pas persistes
        childDto = new ChildDto("Dina", "CM2");
        childDto2 = new ChildDto("Tom", "CM2");
        // avec id car persistes avec save
        childAvecId = childService.saveChild(childDto);
        childAvecId2 = childService.saveChild(childDto2);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        childService.deleteChildren(childAvecId.getId());
        childService.deleteChildren(childAvecId2.getId());
    }

    @Test
    public void getAllMeals() {

        Date day = new Date();

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), day);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), day);

        //assert get
        List<MealDto> allMeals = mealService.getAllMeals();
        assertTrue(allMeals.size() > 0);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());

    }


    @Test
    public void saveMealNoDto() {

        Date day = new Date();

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), day);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), day);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());


    }

    @Test
    public void deleteMealById() {

        Date day = new Date();

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), day);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), day);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());
        assertTrue(mealService.getAllMeals().size() == 0);

    }

    @Test
    public void getMealsByDay() {
        Date day = new Date();
        Date day2 = new Date(day.getTime()+1000 * 60 * 60 * 25);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), day);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), day);
        MealDto m3 = mealService.saveMealNoDto(childAvecId2.getId(), day2);

        List<MealDto> listMeals = mealService.getMealsByDay(day);
        assertTrue(listMeals.size()==2);

        //sup les meals
        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());
        mealService.deleteMealById(m3.getId());
    }
}