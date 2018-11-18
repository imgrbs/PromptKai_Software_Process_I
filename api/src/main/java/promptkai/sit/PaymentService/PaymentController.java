package promptkai.sit.PaymentService;

import co.omise.Client;
import co.omise.models.Charge;
import co.omise.models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @RequestMapping(
            value = "/payment",
            method = RequestMethod.POST,
            params = {"omiseToken", "description"}
    )
    public ResponseEntity<List<Payment>> savePayments(
            @RequestParam(value = "omiseToken") String token,
            @RequestParam(value = "description") String description
        ) {
        try {
            Client client = new Client("skey_test_5dy8qdzi5g8ofgar25g");
            Charge charge = client.charges()
                    .create(new Charge.Create()
                            .amount(100000)
                            .currency("thb")
                            .card(token));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Payment>>(paymentRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payments",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<List<Payment>>(paymentRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payment/{paymentId:[\\d]}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Payment> getById(@PathVariable("paymentId") Long paymentId){
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
        if (paymentOptional.isPresent()) {
            return  new ResponseEntity<Payment>(paymentOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
    }
}
