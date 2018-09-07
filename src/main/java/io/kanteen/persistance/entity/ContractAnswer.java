package io.kanteen.persistance.entity;

import javax.persistence.*;

@Entity
@Table
public class ContractAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // parents will produce many Answer for each contract
    @ManyToOne
    Contract contract;

    @ManyToOne
    Parent parent;

    public ContractAnswer() {
    }

    public ContractAnswer(Contract contract, Parent parent, boolean accepted, ContractOption option) {
        this.contract = contract;
        this.parent = parent;
        this.accepted = accepted;
        this.option = option;
    }

    public ContractAnswer(Contract contract, boolean accepted, ContractOption option) {
        this.contract = contract;
        this.accepted = accepted;
        this.option = option;
    }

    public ContractAnswer(Contract contract, ContractOption option) {
        this.contract = contract;
        this.option = option;
    }

    // Without action, it's not accepted
    private boolean accepted = false;

    // Nullable :
    @ManyToOne
    private ContractOption option = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public ContractOption getOption() {
        return option;
    }

    public void setOption(ContractOption option) {
        this.option = option;
    }
}
