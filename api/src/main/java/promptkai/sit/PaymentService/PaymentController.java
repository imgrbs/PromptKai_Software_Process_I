package promptkai.sit.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.omise.Client;
import co.omise.models.Charge;
import co.omise.models.Token;

import promptkai.sit.OrderService.Order;
import promptkai.sit.OrderService.OrderDetail;
import promptkai.sit.OrderService.OrderRepository;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    private String CURRENCY = "thb";
    private int STANG = 100;

    @RequestMapping(
            value = "/payment",
            method = RequestMethod.POST,
            params = {"omiseToken", "description"}
    )
    public RedirectView savePayments(
            @RequestParam(value = "omiseToken") String token,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "totalPrice") String totalPrice,
            @RequestParam(value = "amount") String totalAmount,
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "location") String location
        ) {
        long priceLong = 0;
        double priceDouble = 0;
        int amount = 0;
        try {
            priceLong = Long.parseLong(totalPrice) * STANG;
            priceDouble = priceLong / STANG;
            amount = Integer.parseInt(totalAmount);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            Client client = new Client("skey_test_5dy8qdzi5g8ofgar25g");
            Charge charge = client.charges()
                    .create(new Charge.Create()
                            .amount(priceLong)
                            .currency(this.CURRENCY)
                            .card(token));
            orderRepository.save(new Order(new Date(), amount, priceDouble, location));
            paymentRepository.save(new Payment("Credit Card", new Date(), userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("http://sit-promptkai.netlify.com/success");
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
