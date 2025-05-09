
package finalproject.com.example.demo.Service;
import finalproject.com.example.demo.Controller.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    void deleteProduct(Long id);
}