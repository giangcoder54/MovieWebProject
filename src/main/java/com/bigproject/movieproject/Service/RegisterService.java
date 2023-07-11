package com.bigproject.movieproject.Service;

import com.bigproject.movieproject.Exception.UserAlreadyExistException;
import com.bigproject.movieproject.Security.Module.User;
import com.bigproject.movieproject.Security.Module.UserForm;
import com.bigproject.movieproject.Security.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void doRegister(UserForm userForm) throws UserAlreadyExistException {
        if(existEmail(userForm.getEmail())){
            throw  new UserAlreadyExistException("There is an account with email address: " + userForm.getEmail());
        }
        User user  = UserForm.toUser(userForm);
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(user);
    }
    public boolean existEmail(String email){
      return userRepository.findByEmail(email) != null;
    }
}
