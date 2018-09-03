package io.kanteen.dto;

import io.kanteen.persistance.entity.ContractOption;

import java.util.List;

public class ContractDto {

    private long id;
    private String title;
    private String description;
    private boolean status;
    private boolean withOption;
    private List<ContractOption> options;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isWithOption() {
        return withOption;
    }

    public void setWithOption(boolean withOption) {
        this.withOption = withOption;
    }

    public List<ContractOption> getOptions() {
        return options;
    }

    public void setOptions(List<ContractOption> options) {
        this.options = options;
    }
}
