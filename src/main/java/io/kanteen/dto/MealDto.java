package io.kanteen.dto;

import io.kanteen.persistance.entity.Child;

import java.util.Date;

public class MealDto {

    private long id;
    private Date day;
    private Child child;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
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
