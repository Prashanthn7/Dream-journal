package com.dreamjournal.Dream_journal_api.mapper;

import com.dreamjournal.Dream_journal_api.dto.request.RegistrationRequest;
import com.dreamjournal.Dream_journal_api.dto.request.UserRequest;
import com.dreamjournal.Dream_journal_api.dto.response.UserResponse;
import com.dreamjournal.Dream_journal_api.model.Dream;
import com.dreamjournal.Dream_journal_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUserEntity(RegistrationRequest registrationRequest );

    User mapToNewUser(UserRequest source);

    UserResponse mapToUserResponse(User user);

}
