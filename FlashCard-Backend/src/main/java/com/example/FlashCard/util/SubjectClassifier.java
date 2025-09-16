package com.example.FlashCard.util;

import java.util.Map;

public class SubjectClassifier {
    private static final Map<String,String[]> RULES = Map.of(
            "Math", new String[]{"math", "algebra", "geometry", "calculus", "equation", "number", "integral", "derivative"},
            "Physics", new String[]{"newton", "force", "energy", "momentum", "velocity", "acceleration", "quantum", "relativity", "gravity", "motion"},
            "Chemistry", new String[]{"history", "war", "revolution", "empire", "king", "queen", "treaty", "ancient"},
            "Biology", new String[]{"cell", "organism", "species", "evolution", "gene", "dna", "ecosystem", "photosynthesis","plant","animal"},
            "History", new String[]{"history", "war", "revolution", "empire", "king", "queen", "treaty", "ancient"}
    );

    public static String classify(String question) {
        String lowerQuestion = question.toLowerCase();
        for (Map.Entry<String, String[]> entry : RULES.entrySet()) {
            for (String keyword : entry.getValue()) {
                if (lowerQuestion.contains(keyword)) {
                    return entry.getKey();
                }
            }
        }
        return "General";
    }
}
