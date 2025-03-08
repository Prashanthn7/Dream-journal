package com.dreamjournal.Dream_journal_api.service.Impl;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.exception.UserNotFoundByIdException;
import com.dreamjournal.Dream_journal_api.mapper.UserMapper;
import com.dreamjournal.Dream_journal_api.model.Dream;
import com.dreamjournal.Dream_journal_api.model.User;
import com.dreamjournal.Dream_journal_api.repository.DreamRepository;
import com.dreamjournal.Dream_journal_api.repository.UserRepository;
import com.dreamjournal.Dream_journal_api.service.DreamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DreamServiceImpl implements DreamService {

    private final UserMapper userMapper;
    private final DreamRepository dreamRepository;
    private final UserRepository userRepository;

    @Override
    public String saveDream(Long userId, Dream dream) {
        return userRepository.findById(userId)
                .map(user -> {
                    dream.setUser(user);
                    dreamRepository.save(dream);
                    return "Dream has been injected successfully";
                })
                .orElseThrow();
    }
}
