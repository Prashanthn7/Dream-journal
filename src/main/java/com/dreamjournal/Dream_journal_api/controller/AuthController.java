package com.dreamjournal.Dream_journal_api.controller;

import com.dreamjournal.Dream_journal_api.dto.request.RegistrationRequest;
import com.dreamjournal.Dream_journal_api.dto.response.UserResponse;
import com.dreamjournal.Dream_journal_api.service.AuthService;
import com.dreamjournal.Dream_journal_api.util.ResponseBuilder;
import com.dreamjournal.Dream_journal_api.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody RegistrationRequest registrationRequest){
        UserResponse response = userService.registerUser(registrationRequest);

        return ResponseBuilder.success(HttpStatus.CREATED,"User Created",response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserbyId(@PathVariable Long userId){
        UserResponse response = userService.findUserById(userId);

        return ResponseBuilder.success(HttpStatus.OK,"User Found",response);
    }
}
