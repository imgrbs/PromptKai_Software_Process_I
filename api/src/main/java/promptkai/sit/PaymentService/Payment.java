package promptkai.sit.PaymentService;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;


    private long payment_method_id;

    private Date paid_date;

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public long getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(long payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public Date getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(Date paid_date) {
        this.paid_date = paid_date;
    }
}
