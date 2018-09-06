package io.kanteen.dto;


public class InformationDto {

    private long id;
    private String description;
    private String expiry;
    boolean hasExpiration = true;

    public InformationDto() {
    }

    public InformationDto(long id, String description, String expiry, boolean hasExpiration) {
        this.id = id;
        this.description = description;
        this.expiry = expiry;
        this.hasExpiration = hasExpiration;
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

    public boolean isHasExpiration() {
        return hasExpiration;
    }

    public void setHasExpiration(boolean hasExpiration) {
        this.hasExpiration = hasExpiration;
    }
}
