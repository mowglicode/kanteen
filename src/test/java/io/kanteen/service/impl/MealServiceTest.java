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


import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealServiceTest {

    @Autowired
     MealService mealService;
    @Autowired
    ChildService childService;

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
//        ChildDto childDto = new ChildDto("Dina","CM2");
//        ChildDto childDto2 = new ChildDto("Toto","CM2");
//        Child child = modelMapper.map(childDto,Child.class);
//        Child child2 = modelMapper.map(childDto2,Child.class);
//        Date day = new Date();
//        MealDto mealDto = new MealDto(1452,day,child);
//        MealDto mealDto2 = new MealDto(1572,day,child2);
//
//        MealDto resDto = mealService.saveMealNoDto(child.getId(),day);
//        MealDto resDto2 = mealService.saveMealNoDto(child2.getId(),day);
//
//        //assert get
//        List<MealDto> allMeals =  mealService.getAllMeals();
//        assertTrue(allMeals.size()>0);
//
//        //delete
//        mealService.deleteMealById(mealDto.getId());
//        mealService.deleteMealById(mealDto2.getId());
//        childService.deleteChildren(child.getId());
//        childService.deleteChildren(child2.getId());

    }

    @Test
    public void getMealById() {
    }


    @Test
    public void saveMealNoDto() {
        ChildDto childDto = new ChildDto("Dina","CM2");
        ChildDto childDto2 = new ChildDto("Tom","CM2");

        Child child = modelMapper.map(childDto,Child.class);
        Child child2 = modelMapper.map(childDto2,Child.class);

        Date day = new Date();


    }

    @Test
    public void deleteMealById() {
    }
}