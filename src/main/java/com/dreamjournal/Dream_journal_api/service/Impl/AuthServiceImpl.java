package com.dreamjournal.Dream_journal_api.service.Impl;

import com.dreamjournal.Dream_journal_api.dto.request.RegistrationRequest;
import com.dreamjournal.Dream_journal_api.dto.response.UserResponse;
import com.dreamjournal.Dream_journal_api.mapper.UserMapper;
import com.dreamjournal.Dream_journal_api.model.User;
import com.dreamjournal.Dream_journal_api.repository.UserRepository;
import com.dreamjournal.Dream_journal_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        User user = new User();
        userMapper.mapToUserEntity(user,registrationRequest);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }


}
