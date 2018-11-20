package promptkai.sit.OrderService;

import promptkai.sit.PaymentService.Payment;
import promptkai.sit.ProductService.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class OrderDetail {
    @Id
    @GeneratedValue
    private int orderDetailId;

    private Product product;

    private Payment payment;

    private int amount;

    private double subTotalPrice;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPaymentId() {
        return payment;
    }

    public void setPaymentId(Payment payment) {
        this.payment = payment;
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
