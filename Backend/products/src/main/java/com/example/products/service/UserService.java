package com.example.products.service;
import com.example.products.exception.productAlreadyExistException;
import com.example.products.model.User;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public void deleteUser(String id);
    User update(User user);
    Optional<User> findById(String id);
    public ResponseEntity<?> addUser(User user) throws productAlreadyExistException;
    public List<User> getUsers();
    List<User> findAll();
}
