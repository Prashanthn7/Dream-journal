package com.dreamjournal.Dream_journal_api.mapper;

import com.dreamjournal.Dream_journal_api.dto.request.RegistrationRequest;
import com.dreamjournal.Dream_journal_api.dto.request.UserRequest;
import com.dreamjournal.Dream_journal_api.dto.response.UserResponse;
import com.dreamjournal.Dream_journal_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    void mapToUserEntity(@MappingTarget User user, RegistrationRequest registrationRequest );

    void mapToNewUser(UserRequest source, @MappingTarget User target);

    UserResponse mapToUserResponse(User user);
}
