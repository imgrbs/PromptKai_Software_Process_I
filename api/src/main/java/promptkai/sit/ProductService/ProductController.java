package promptkai.sit.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(name="/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping(name="/product/{productid}")
    public Product getProducts(@PathVariable String productid){
        Product product;
        try {
            product = productRepository.findById(Integer.parseInt(productid));
        }catch(Exception e){
            product = null
        }
        return product;
    }
}