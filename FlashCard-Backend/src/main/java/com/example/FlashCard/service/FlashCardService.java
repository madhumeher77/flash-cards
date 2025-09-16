package com.example.FlashCard.service;


import com.example.FlashCard.model.FlashCard;
import com.example.FlashCard.repository.FlashcardRepository;
import com.example.FlashCard.util.SubjectClassifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashCardService {
    private final FlashcardRepository flashcardRepository;

    public FlashCard addFlashCard(String studentId, String question, String answer) {
        String subject = SubjectClassifier.classify(question);
        FlashCard flashCard = new FlashCard();
        flashCard.setStudentId(studentId);
        flashCard.setQuestion(question);
        flashCard.setAnswer(answer);
        flashCard.setSubject(subject);
        return flashcardRepository.save(flashCard);
    }

    public List<FlashCard> getFlashCardsByStudentId(String studentId, int limit) {
        List<FlashCard> flashCards = flashcardRepository.findByStudentId(studentId);
        Collections.shuffle(flashCards);
        return flashCards.stream().limit(limit).toList();
    }
}
