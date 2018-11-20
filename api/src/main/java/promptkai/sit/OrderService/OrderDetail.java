package promptkai.sit.OrderService;

import promptkai.sit.PaymentService.Payment;
import promptkai.sit.ProductService.Product;

import javax.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailId;
    private long productId;
    private long orderId;
    private long paymentId;
    private int amount;
    private double subTotalPrice;

    public OrderDetail() {
    }

    public OrderDetail(long productId, long paymentId, long orderId, int amount, double subTotalPrice) {
        this.productId = productId;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.subTotalPrice = subTotalPrice;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(double subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }
}
