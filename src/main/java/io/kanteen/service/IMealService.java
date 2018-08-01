package io.kanteen.service;


import io.kanteen.dto.MealDto;

import java.util.Date;
import java.util.List;

public interface IMealService  {

    List<MealDto> getAllMeals();
    MealDto getMealById(long id);
    MealDto saveMeal(MealDto mealDto);
    List<MealDto> saveMeals(List<MealDto> meals);
    MealDto saveMealNoDto(long idChild, Date day);
    void deleteMealById(long idMeal);
}
