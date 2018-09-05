package io.kanteen.dto;

import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Admin;

public class AdminDto {
    private long id;
    private Account account;
    private String name;

    public AdminDto(){
    }

    public AdminDto(String email, String name) {
        this.account = new Account(email);
        this.name = name;
    }

    public AdminDto(String name) {
        this.name = name;
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
}
