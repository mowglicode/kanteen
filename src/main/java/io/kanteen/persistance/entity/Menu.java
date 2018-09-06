package io.kanteen.persistance.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Lob
    @Column
    private String content;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private int week;

    public Menu(String content) {
        this.content = content;
    }



    public Menu() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWeek() { return week; }

    public void setWeek(int week) { this.week = week; }
}
