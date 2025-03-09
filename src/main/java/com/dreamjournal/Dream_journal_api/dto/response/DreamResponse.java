package com.dreamjournal.Dream_journal_api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DreamResponse {
    private String dreamText;
    private LocalDate recordedAt;

}
