package io.kanteen.dto;

import io.kanteen.persistance.entity.Child;


public class MealDto {

    private long id;
    private String day;
    private Child child;

    public MealDto (){

    }
    public MealDto(long id, String day, Child child) {
        this.id = id;
        this.day = day;
        this.child = child;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
