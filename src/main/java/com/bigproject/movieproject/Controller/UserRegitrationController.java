package com.bigproject.movieproject.Controller;

import com.bigproject.movieproject.Security.Module.UserForm;
import com.bigproject.movieproject.Service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/register")
public class UserRegitrationController {
    @Autowired
    private RegisterService registerService;
    @GetMapping
    public String register(){
        return "register";
    }
    @PostMapping
    public String doRegister(@Valid UserForm userForm){
        registerService.doRegister(userForm);
        return "redirect:/login";
    }
}
