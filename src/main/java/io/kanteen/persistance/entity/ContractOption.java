package io.kanteen.persistance.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class ContractOption {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @ManyToOne
        Contract contract;

        private String optionName;

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

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractOption that = (ContractOption) o;
        return id == that.id &&
                Objects.equals(optionName, that.optionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, optionName);
    }

    @Override
    public String toString() {
        return "ContractOptionDto{" +
                "id=" + id +
                ", optionName='" + optionName + '\'' +
                '}';
    }
}

