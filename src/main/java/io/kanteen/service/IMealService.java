package io.kanteen.service;


import io.kanteen.dto.MealDto;
import io.kanteen.persistance.entity.Meal;

import java.util.Date;
import java.util.List;

public interface IMealService  {

    List<MealDto> getAllMeals();
    MealDto getMealById(long id);
    List<MealDto> getMealsByDay(String day);
    MealDto saveMeal(MealDto mealDto);
    List<MealDto> saveMeals(List<MealDto> meals);
    MealDto saveMealNoDto(long idChild, String day);
    void deleteMealById(long idMeal);
    List<MealDto> getMealsByParentId(long id);
    List<MealDto> getMealsByChildId(long id);

}
