package com.example.products.service;

import com.example.products.Repo.UserRepo;
import com.example.products.exception.productAlreadyExistException;
import com.example.products.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void deleteUser(String userName) {
        userRepo.deleteByUserName(userName);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findById(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public ResponseEntity<?> addUser(User user) throws productAlreadyExistException {
        final Optional<User> userOptional = this.userRepo.findByUserName(user.getUserName());
        if(userOptional.isPresent())
        {
            throw new productAlreadyExistException("user already Existed");
        }
        User save=  this.userRepo.save(user);
        return ResponseEntity.of(this.userRepo.findByUserName(user.getUserName()));
    }


    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
