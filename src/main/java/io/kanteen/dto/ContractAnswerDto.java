package io.kanteen.dto;

import io.kanteen.persistance.entity.ContractOption;

public class ContractAnswerDto {

    private long id;
    private ContractOption option = null;
    private boolean accepted;

    public ContractAnswerDto() {
    }

    public ContractAnswerDto(long id, ContractOption option) {
        this.id = id;
        this.option = option;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContractOption getOption() {
        return option;
    }

    public void setOption(ContractOption option) {
        this.option = option;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
