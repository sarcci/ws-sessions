package com.example.wsproject.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import jakarta.annotation.Resource;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.wsproject.Dto.UserDTO;
import com.example.wsproject.Dto.LoginDTO;
import com.example.wsproject.Entity.User;
import com.example.wsproject.Repo.UserRepo;
import com.example.wsproject.Service.UserService;
import com.example.wsproject.response.LoginResponse;
import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override

    public String addUser(UserDTO userDTO) {
            User user = new User(
            userDTO.getUserID(),
            userDTO.getName(),
            userDTO.getEmail(),
            this.passwordEncoder.encode(userDTO.getPassword())
        );

        userRepo.save(user);
        return user.getName();
    }
    UserDTO userDTO;
    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        //String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Logged in succesfully.", true);
                } else {
                    return new LoginResponse("Login failed", false);
                }
            } else {
                return new LoginResponse("Incorrect password.", false);
            }
        } else {
            return new LoginResponse("Email does not exist.", false);
        }
    }
}
