package com.dreamjournal.Dream_journal_api.service;

import com.dreamjournal.Dream_journal_api.dto.request.RegistrationRequest;
import com.dreamjournal.Dream_journal_api.dto.response.UserResponse;

public interface AuthService {
    public UserResponse registerUser(RegistrationRequest registrationRequest);

    UserResponse findUserById(Long id);
}
