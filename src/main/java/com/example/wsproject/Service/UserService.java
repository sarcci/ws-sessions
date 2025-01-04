package com.example.wsproject.Service;


import com.example.wsproject.Dto.UserDTO;
import com.example.wsproject.Dto.LoginDTO;
import com.example.wsproject.response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);

}
