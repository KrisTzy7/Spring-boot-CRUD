package finalproject.com.example.demo.Controller;

import finalproject.com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("productmanagement/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Show all products
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product_list"; // Thymeleaf template: product_list.html
    }

    // Show form to add a new product
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form"; // Thymeleaf template: product_form.html
    }

    // Handle form submission
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        product.setCreatedAt(LocalDateTime.now());
        productRepository.save(product);
        return "redirect:/productmanagement/products"; // Corrected redirect path
    }

    // Delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/productmanagement/products"; // Corrected redirect path
    }
}
