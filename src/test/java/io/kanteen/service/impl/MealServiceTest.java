package io.kanteen.service.impl;

import io.kanteen.dto.ChildDto;
import io.kanteen.dto.MealDto;
import io.kanteen.dto.ParentDtoFull;
import io.kanteen.dto.ParentDtoLight;
import io.kanteen.persistance.entity.Parent;
import org.junit.Ignore;
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
    ParentService parentService;

    @Autowired
    ModelMapper modelMapper;

    ChildDto childDto;
    ChildDto childDto2;
    ChildDto childAvecId;
    ChildDto childAvecId2;
//    ParentDtoFull parentDto;
//    ParentDtoFull parentDtoAvecId;
    String dateString;

    @org.junit.Before
    public void setUp() throws Exception {
        // sans id car pas persistes
        childDto = new ChildDto("Dina", "CM2");
        childDto2 = new ChildDto("Tom", "CM2");
//        parentDto = new ParentDtoFull("Jacques","jc@toto.com");
        // avec id car persistes avec save
//        parentDto = parentService.saveParentWithChildId(parentDto,childAvecId.getId());
//        parentService.saveParentWithChildId(parentDto,childAvecId2.getId());
        childAvecId = childService.saveChild(childDto);
        childAvecId2 = childService.saveChild(childDto2);
        dateString = "2018-08-30";
    }

    @org.junit.After
    public void tearDown() throws Exception {
        childService.deleteChildren(childAvecId.getId());
        childService.deleteChildren(childAvecId2.getId());
//        parentService.displayParentById(parentDto.getId());
    }

    @Test
    public void getAllMeals() {

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

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateString);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());


    }

    @Test
    public void deleteMealById() {

        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateString);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);

        mealService.deleteMealById(m1.getId());
        mealService.deleteMealById(m2.getId());
        assertTrue(mealService.getAllMeals().size() == 0);

    }

    @Test
    public void getMealsByDay() {

        String dateTest = "2018-05-25";
        String dateTest2 = "2018-05-24";

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
    @Ignore
    @Test
    public void getMealsByParentId(){
        MealDto m1 = mealService.saveMealNoDto(childAvecId.getId(), dateString);
        MealDto m2 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);
        MealDto m3 = mealService.saveMealNoDto(childAvecId2.getId(), dateString);


    }

}