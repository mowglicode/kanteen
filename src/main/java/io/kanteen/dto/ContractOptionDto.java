package io.kanteen.dto;

public class ContractOptionDto {

    long id;
    private String optionName;

    public ContractOptionDto() {
    }

    public ContractOptionDto(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
