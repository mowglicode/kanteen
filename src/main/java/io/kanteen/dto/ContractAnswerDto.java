package io.kanteen.dto;

import io.kanteen.persistance.entity.ContractOption;

public class ContractAnswerDto {

    private long id;

    private ContractOption option = null;

    public ContractAnswerDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
