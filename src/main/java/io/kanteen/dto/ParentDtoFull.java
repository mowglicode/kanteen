package io.kanteen.dto;

import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.entity.School;

import java.util.List;

public class ParentDtoFull {
    private long id;
    private String name;
    private Account account;
    private List<Child> children;
    private School school;

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
