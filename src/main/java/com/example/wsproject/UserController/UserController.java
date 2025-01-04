package com.example.wsproject.UserController;
import com.example.wsproject.Dto.UserDTO;
import com.example.wsproject.Dto.LoginDTO;
//import com.example.wsproject.Entity.User;
import com.example.wsproject.Service.UserService;
import com.example.wsproject.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;


@RestController
@CrossOrigin

public class UserController {

    @Autowired
    private UserService userService;

    /*public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }*/
    @PostMapping(path = "/Login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(path = "/Register")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }
/* 
    @PostMapping(path = "/login")
    public String login(@ModelAttribute("user") User user) {
        User oauthUser = userService.login(user.getEmail(), user.getPassword());
        System.out.print(oauthUser);
        if(Object.nonNull(oauthUser)) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    } */


    
}
