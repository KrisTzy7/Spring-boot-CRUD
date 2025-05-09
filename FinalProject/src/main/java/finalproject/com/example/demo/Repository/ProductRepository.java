package finalproject.com.example.demo.Repository;

import finalproject.com.example.demo.Controller.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
