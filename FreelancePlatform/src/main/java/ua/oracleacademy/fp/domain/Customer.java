package ua.oracleacademy.fp.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("CUSTOMER")

public class Customer extends User {

    @Column
    private List<Task> orderHistory;

    public Customer() {
    }

    public List<Task> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Task> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
