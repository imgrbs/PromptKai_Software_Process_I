package promptkai.sit.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(name="/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping(name="/product/{productid}")
    public ResponseEntity<Product> getProducts(@PathVariable String productid, HttpServletResponse res){
        Optional<Product> productOptional = productRepository.findById(Long.parseLong(productid));
        return productOptional.isPresent() ? new ResponseEntity<Product>(productOptional.get(), HttpStatus.OK) : new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
}