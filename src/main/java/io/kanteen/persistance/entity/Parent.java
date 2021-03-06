package io.kanteen.persistance.entity;

import io.kanteen.persistance.KanteenUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Parent implements KanteenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @OneToOne
    private Account account;

    @Column
    private String name;

    @Transient
    School school;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column
    private List<Child> children;

    public Parent() {
    }

    public Parent(String name, List<Child> children) {
        this.name = name;
        this.children = children;
    }

    public Parent(Account account, String name, List<Child> children) {
        this.account = account;
        this.name = name;
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setChild(Child child){this.children.add(child); }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }


    @Override
    public boolean isAdmin() {
        return false;
    }
}
