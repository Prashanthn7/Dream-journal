package com.dreamjournal.Dream_journal_api.service.Impl;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.exception.UserNotFoundByIdException;
import com.dreamjournal.Dream_journal_api.mapper.DreamMapper;
import com.dreamjournal.Dream_journal_api.mapper.UserMapper;
import com.dreamjournal.Dream_journal_api.model.Dream;
import com.dreamjournal.Dream_journal_api.repository.DreamRepository;
import com.dreamjournal.Dream_journal_api.repository.UserRepository;
import com.dreamjournal.Dream_journal_api.service.DreamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DreamServiceImpl implements DreamService {

    private final DreamRepository dreamRepository;
    private final DreamMapper dreamMapper;





    @Override
    public List<DreamResponse> getDreamsByUserId(Long userId) {

        List<Dream> dreams = dreamRepository.findByUserId(userId);
        return dreamMapper.mapToListOfDreamResponse(dreams);
    }
}
