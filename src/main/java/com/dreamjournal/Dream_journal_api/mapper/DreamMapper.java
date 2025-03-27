package com.dreamjournal.Dream_journal_api.mapper;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.model.Dream;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DreamMapper {
    List<DreamResponse> mapToListOfDreamResponse(List<Dream> dreams);
}
