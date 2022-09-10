package com.learn.userauthentication.repository;



import com.learn.userauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String  > {

    User findByUserNameAndPassword(String userName ,String password);


}
