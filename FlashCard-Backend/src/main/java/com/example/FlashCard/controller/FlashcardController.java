package com.example.FlashCard.controller;

import com.example.FlashCard.model.FlashCard;
import com.example.FlashCard.service.FlashCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FlashcardController {
    private final FlashCardService flashCardService;

    @PostMapping("/flashcards")
    public Map<String,String> addFlashcard(@RequestBody FlashCard flashCard) {
        FlashCard savedCard = flashCardService.addFlashCard(flashCard.getStudentId(), flashCard.getQuestion(), flashCard.getAnswer());
        return Map.of("message", "Flashcard added successfully", "subject", savedCard.getSubject());
    }

    @GetMapping("/get-subject")
    public List<FlashCard> getFlashCards(@RequestParam String studentId,@RequestParam int limit) {
        return flashCardService.getFlashCardsByStudentId(studentId, limit);
    }
}
