package io.kanteen.service.impl;

import io.kanteen.dto.ChildDto;
import io.kanteen.dto.MealDto;
import io.kanteen.persistance.entity.Child;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealServiceTest {

    @Autowired
     MealService mealService;

    @Autowired
     ModelMapper modelMapper;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllMeals() {
        ChildDto childDto = new ChildDto(612,"Dina","CM2");
        ChildDto childDto2 = new ChildDto(321,"Toto","CM2");
        Child child = modelMapper.map(childDto,Child.class);
        Child child2 = modelMapper.map(childDto2,Child.class);
        Date day = new Date();
        MealDto mealDto = new MealDto(14562,day,child);
        MealDto mealDto2 = new MealDto(15752,day,child2);

        MealDto resDto = mealService.saveMeal(mealDto);
        MealDto resDto2 = mealService.saveMeal(mealDto2);

        //assert get
        List<MealDto> allMeals =  mealService.getAllMeals();
        assertTrue(allMeals.size()>0);

        //delete
//        mealService.deleteMealById(mealDto.getId());
//        mealService.deleteMealById(mealDto2.getId());

    }

    @Test
    public void getMealById() {
    }

    @Test
    public void saveMeal() {
    }

    @Test
    public void saveMeals() {
    }

    @Test
    public void saveMealNoDto() {
    }

    @Test
    public void deleteMealById() {
    }
}