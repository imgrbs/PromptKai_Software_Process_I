package promptkai.sit.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(name="/payments")
    public List<Payment> getPayment(){
        return paymentRepository.findAll();
    }

    @GetMapping(name="/payments/{payment_id}" )
    public ResponseEntity<Payment> get(@PathVariable long payment_id, HttpServletResponse res){
        Optional<Payment> paymentOptional = paymentRepository.findById(payment_id);
        return paymentOptional.isPresent() ? new ResponseEntity<Payment>(paymentOptional.get(), HttpStatus.OK) : new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
    }
}
