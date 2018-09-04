package io.kanteen.persistance.entity;

import io.kanteen.persistance.KanteenUser;

import javax.persistence.*;

@Entity
@Table
public class Admin implements KanteenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @OneToOne
    private Account account;

    @Column
    private String name;

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

    @Override
    public boolean isAdmin() {
        return true;
    }
}
