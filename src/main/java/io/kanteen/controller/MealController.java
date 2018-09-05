package io.kanteen.controller;

import io.kanteen.dto.MealDto;
import io.kanteen.service.IMealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private IMealService mealService;

    @ApiOperation(value = "Get meals")
    @RequestMapping(method = RequestMethod.GET)
    public List<MealDto> getAllMeals(){
        return mealService.getAllMeals();
    }

    @ApiOperation(value = "Get meal by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MealDto getMealById(@PathVariable(name = "id") long id){
        return mealService.getMealById(id);
    }


    @ApiOperation(value = "Get meals by day")
    @RequestMapping(value = "/{day}", method =RequestMethod.GET)
    public List<MealDto> getMealsByDay(@PathVariable(name="day") String day){
        return mealService.getMealsByDay(day);
    }

    @ApiOperation(value = "Get meals by billed parent")
    @RequestMapping(value = "/{id_parent}",method = RequestMethod.GET)
    public List<MealDto> getMealsByParentId (@PathVariable(name="id_parent") long id){
        return mealService.getMealsByParentId(id);


    }

//    @ApiOperation(value = "Save meal", notes = "The meal saved comes from a MealDto")
//    @RequestMapping(method = RequestMethod.POST)
//    public MealDto saveMeal(@RequestBody MealDto mealDto){
//        return mealService.saveMeal(mealDto);
//    }

//    @ApiOperation(value = "Save multiple meals",notes = "The meals are saved according to a list of MealDto")
//    @RequestMapping(value = "/list",method = RequestMethod.POST)
//    public List<MealDto> saveMeals(@RequestBody List<MealDto> mealDtos){
//        return mealService.saveMeals(mealDtos);
//    }

    @ApiOperation(value = "Save meal without DTO",
            notes = "While child already exists, the meal can be create with the child ID and the date (yyyy-mm-dd format)")
    @RequestMapping(value = "/{id_child}/{day}", method = RequestMethod.POST)
    public MealDto saveMealNoDto(@PathVariable(name = "id_child") long idChild, @PathVariable(name = "day") String day){
        return mealService.saveMealNoDto(idChild,day);
    }

    @ApiOperation(value = "Delete meal by ID")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteMealById(@PathVariable(name = "id") long idMeal){
        mealService.deleteMealById(idMeal);
    }
}

