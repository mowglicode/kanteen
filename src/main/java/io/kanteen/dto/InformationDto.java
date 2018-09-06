package io.kanteen.dto;


public class InformationDto {

    private long id;
    private String description;
    private String expiry;

    public InformationDto() {
    }

    public InformationDto(long id, String entitled, String description, String expiry) {
        this.id = id;
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
