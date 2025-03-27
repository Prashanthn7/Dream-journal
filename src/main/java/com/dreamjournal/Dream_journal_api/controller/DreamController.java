package com.dreamjournal.Dream_journal_api.controller;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.model.Dream;
import com.dreamjournal.Dream_journal_api.service.DreamService;
import com.dreamjournal.Dream_journal_api.util.ResponseBuilder;
import com.dreamjournal.Dream_journal_api.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dreams")
@AllArgsConstructor
public class DreamController {

    private final DreamService dreamService;


    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<List<DreamResponse>>> getDreams(@PathVariable Long userId) {
        List<DreamResponse> dreams = dreamService.getDreamsByUserId(userId);
        return ResponseBuilder.success(HttpStatus.OK, "Dreams retrieved successfully", dreams);
    }
}
