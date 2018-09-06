package io.kanteen.dto;

import io.kanteen.persistance.entity.ContractOption;

public class ContractAnswerDto {

    private long id;

    private ContractOptionDto option = null;

    ParentDtoFull parent;
    ContractDto contract;

    public ContractAnswerDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContractAnswerDto{" +
                "id=" + id +
                ", option=" + option.getOptionName() +
                ", parent=" + parent.getName() +
                ", contract=" + contract.getTitle() +
                '}';
    }

    public ContractOptionDto getOption() {
        return option;
    }

    public void setOption(ContractOptionDto option) {
        this.option = option;
    }

    public ParentDtoFull getParent() {
        return parent;
    }

    public void setParent(ParentDtoFull parent) {
        this.parent = parent;
    }

    public ContractDto getContract() {
        return contract;
    }

    public void setContract(ContractDto contract) {
        this.contract = contract;
    }
}
