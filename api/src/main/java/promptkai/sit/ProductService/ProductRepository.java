package promptkai.sit.ProductService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM products p WHERE p.product_type = :productType")
    public List<Product> findByProductType(@Param("productType") String productType);
}
