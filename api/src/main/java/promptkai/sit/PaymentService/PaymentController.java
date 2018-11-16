package promptkai.sit.PaymentService;

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
