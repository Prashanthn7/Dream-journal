package com.dreamjournal.Dream_journal_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {
    @NotEmpty(message = "Username Cannot Be Null or Blank")
    @NotBlank(message = "Email should not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message ="Username can only contain Alphabets, Number and Underscore")
    private String username;

    @NotEmpty(message = "Email Should Not Be Empty")
    @NotBlank(message = "Email should not be blank")
    @Email(regexp = "^[a-zA-Z0-9._]+@gmail.com$")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&])(?=\\S+$).{12,20}$", message = "Password should contain atleast one Uppercase, Lowercase,special characters and Number")
    private String password;
}
