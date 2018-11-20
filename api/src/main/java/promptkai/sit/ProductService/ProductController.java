package promptkai.sit.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value="/products")
    public List<Product> getProducts(WebRequest webRequest){
        Map<String, String[]> params = webRequest.getParameterMap();
        String[] filterArr = params.get("filter");
        String filter;
        if( filterArr!=null && filterArr[0]!="" ){
            filter = filterArr[0];
            return productRepository.findByProductType(filter);
        }else{
            return productRepository.findAll();
        }
    }

    @GetMapping(value="/product/{productid}")
    public ResponseEntity<Product> getProducts(@PathVariable String productid, HttpServletResponse res){
        Optional<Product> productOptional = productRepository.findById(Long.parseLong(productid));
        return productOptional.isPresent() ? new ResponseEntity<Product>(productOptional.get(), HttpStatus.OK) : new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
}