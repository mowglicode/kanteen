package io.kanteen.service;


import io.kanteen.dto.MealDto;

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

}
