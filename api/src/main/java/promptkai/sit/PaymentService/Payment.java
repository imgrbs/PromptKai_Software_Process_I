package promptkai.sit.PaymentService;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    private long paymentMethodId;

    private Date paidDate;

    private long userId;
    public Payment() {
    }

    public Payment(long paymentMethodId, Date paidDate) {
        this.paymentMethodId = paymentMethodId;
        this.paidDate = paidDate;
    }

    public Payment(long paymentMethodId, Date paidDate, long userId) {
        this.paymentMethodId = paymentMethodId;
        this.paidDate = paidDate;
        this.userId = userId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
}
