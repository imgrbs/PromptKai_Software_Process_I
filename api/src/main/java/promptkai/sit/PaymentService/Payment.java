package promptkai.sit.PaymentService;

import promptkai.sit.OrderService.OrderDetail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    private String paymentMethod;

    private Date paidDate;

    private int userId;

    private OrderDetail orderDetail;

    public Payment() {
    }

    public Payment(String paymentMethod, Date paidDate, int userId, OrderDetail orderDetail) {
        this.paymentMethod = paymentMethod;
        this.paidDate = paidDate;
        this.userId = userId;
        this.orderDetail = orderDetail;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
}
