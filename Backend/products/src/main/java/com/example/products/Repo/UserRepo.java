package com.example.products.Repo;

import com.example.products.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User,String> {

    public Optional<User> findByUserName(String userName);

    void deleteByUserName(String userName);
}
