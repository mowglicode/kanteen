package io.kanteen.dto;

import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.entity.School;

import java.util.ArrayList;
import java.util.List;

public class ParentDtoFull {
    private long id;
    private String name;
    private Account account;
    private List<Child> children = new ArrayList<>();
    private School school;


    public ParentDtoFull() {
    }


    public ParentDtoFull(String name, String email) {
        this.name = name;
        this.school = new School();
        this.account = new Account(email);
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
