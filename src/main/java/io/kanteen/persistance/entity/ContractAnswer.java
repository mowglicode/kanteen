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


    // Without action, it's not accepted
    private boolean accepted = false;

    // Nullable :
    @ManyToOne
//    @JoinColumn(nullable = true)
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
