package com.example.products.Controller;
import com.example.products.Repo.ProductRepo;
import com.example.products.exception.productAlreadyExistException;
import com.example.products.model.Product;
import com.example.products.model.User;
import com.example.products.service.ProductService;
import com.example.products.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class Controller {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepo repository;

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") String id)
    {
        this.productService.deleteProduct(id);
    }

    @GetMapping("/findUser/{userName}")
    public Optional<User> findUser(@PathVariable("userName") String userName)
    {
       return this.userService.findById(userName);
    }
    @PutMapping("updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product)
    {
        return this.productService.update(product);
    }

    @PutMapping("updateUser/{id}")
    public User updateUser(@RequestBody User user )
    {
        return this.userService.update(user);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws productAlreadyExistException {
            return this.productService.addProduct(product);
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws productAlreadyExistException {
        return this.userService.addUser(user);
    }
    @GetMapping("/getAllProducts")
    public List<Product> getProducts()
    {
        return this.productService.findAll();

    }
    @GetMapping("/getAllUsers")
    public List<User> getUsers()
    {
        return this.userService.findAll();
    }
}
