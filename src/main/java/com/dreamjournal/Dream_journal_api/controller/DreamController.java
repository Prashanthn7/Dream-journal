package com.dreamjournal.Dream_journal_api.controller;

import com.dreamjournal.Dream_journal_api.model.Dream;
import com.dreamjournal.Dream_journal_api.service.DreamService;
import com.dreamjournal.Dream_journal_api.util.ResponseBuilder;
import com.dreamjournal.Dream_journal_api.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dream")
@AllArgsConstructor
public class DreamController {

    private final DreamService dreamService;

    @PostMapping("/{userId}/dreams")
    public ResponseEntity<ResponseStructure<String>> saveDream(@PathVariable Long userId, @RequestBody Dream dream){
        String dreamResponse= dreamService.saveDream(userId,dream);
        return ResponseBuilder.success(HttpStatus.ACCEPTED,"Dream Saved",dreamResponse);
    }
}
