package io.kanteen.persistance.entity;


import javax.persistence.*;

@Entity
@Table
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String description;

    @Column
    private String expiry;

    private boolean hasExpiry;


    public Information () {

    }

    public Information (String description, String expiry) {
        this.description = description;
        this.expiry = expiry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
