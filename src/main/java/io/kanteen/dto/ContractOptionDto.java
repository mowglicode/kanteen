package io.kanteen.dto;

public class ContractOptionDto {
    private long id;
    private String OptionName;

    public ContractOptionDto() {
    }

    public String getOptionName() {
        return OptionName;
    }

    public void setOptionName(String optionName) {
        OptionName = optionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
