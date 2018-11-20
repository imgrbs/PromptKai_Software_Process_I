package promptkai.sit.OrderService;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private Date orderDate;
    private int amount;
    private double total;


    public Order() {
    }

    public Order(Date orderDate, int amount, double total) {
        this.orderDate = orderDate;
        this.amount = amount;
        this.total = total;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
