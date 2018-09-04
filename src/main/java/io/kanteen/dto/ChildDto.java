package io.kanteen.dto;

import io.kanteen.persistance.entity.Child;

import java.util.Objects;

public class ChildDto {
    private long id;
    private String name;
    private String grade;

    public ChildDto(){
    }

    public ChildDto(long id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    public ChildDto( String name, String grade) {

        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildDto childDto = (ChildDto) o;
        return id == childDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
