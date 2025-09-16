package com.example.FlashCard.repository;

import com.example.FlashCard.model.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<FlashCard,Long> {
    List<FlashCard> findByStudentId(String studentId);
}
