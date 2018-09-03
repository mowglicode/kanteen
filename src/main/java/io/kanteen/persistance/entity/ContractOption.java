package io.kanteen.persistance.entity;

import javax.persistence.*;

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
    }

