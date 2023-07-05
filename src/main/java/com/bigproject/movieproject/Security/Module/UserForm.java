package com.bigproject.movieproject.Security.Module;

import com.bigproject.movieproject.Validation.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    @ValidEmail
    @NotBlank
    @Size(min = 5, max = 30, message = "email must be longer than 3 and shorter than 30 character")
    private String email;
    @NotBlank
    @Size(min = 2,  max = 15 , message = "Username must be longer than 2 and shorter than 15 characters")
    private String username;
    @NotBlank
    private LocalDate dob;
    @NotBlank
    @Size(min = 3,  max = 15 , message = "Password must be longer than 2 and shorter than 15 characters")
    private String password;

    public static User toUser(UserForm userForm){
        User user  = new User();
        user.setEmail(userForm.getEmail());
        user.setUsername(userForm.getUsername());
        user.setPassword(user.getPassword());
        user.setDob(userForm.getDob());
        user.setRole("USER");
        return user;
    }
}
