package com.learn.userauthentication.service;



import com.learn.userauthentication.model.User;
import com.learn.userauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User getUserInfo(String username , String pas)
    {
      return userRepository.findByUserNameAndPassword(username,pas);

    }
   public java.util.List<User> getAllUSer()
   {
       return userRepository.findAll();
   }
    public User addNewUser(User user)
    {
return this.userRepository.save(user);
    }
}
