Smart Flashcard Backend (Rule-Based)

This is a Spring Boot REST API for a Smart Flashcard System.
Users can add flashcards (question & answer), and the backend will infer the subject automatically using simple rule-based keyword matching.
Students can also fetch flashcards by subject in a mixed/shuffled way.

⸻

 Features
	•	Add flashcards with automatic subject detection
	•	Fetch flashcards for a given student
	•	Shuffle flashcards from different subjects
	•	Uses Spring Boot + H2 Database (in-memory for quick setup)
	•	Subject detection via rule-based keywords (Physics, Biology, Chemistry, Math, History, General)

⸻

 Tech Stack
	•	Java 21
	•	Spring Boot 3+
	•	Spring Web
	•	Spring Data JPA
	•	H2 Database (default, can be swapped with MySQL/Postgres)
	•	Lombok (optional)

⸻

Running the project
Option 1: Run with maven
mvn spring-boot:run


Option 2: Run in IntelliJ IDEA
	1.	Open IntelliJ IDEA → File → Open → select the project folder.
	2.	Wait for Maven dependencies to download.
	3.	In the Project Explorer, open FlashCardBackendApplication.java.
	4.	Right-click → Run ‘FlashcardBackendApplication’.
	5.	The server will start on http://localhost:8081.

API Endpoints

=> Add Flashcard

POST /flashcards
Request:
{
    "studentId": "stu001",
    "question": "What is photosynthesis?",
    "answer": "A process used by plants to convert light into energy"
}

Response:
{
    "subject": "Biology",
    "message": "Flashcard added successfully"
}


Get Flashcards

GET /get-subject?studentId=stu001&limit=1

Response:
[
    {
        "id": 1,
        "studentId": "stu001",
        "question": "What is Newton's Second Law?",
        "answer": "Force equals mass times acceleration",
        "subject": "Physics"
    }
]


Subject Detection (Rule-Based)

Subjects are inferred based on keywords in the question:
	•	Physics → newton, force, velocity, acceleration, gravity, motion
	•	Biology → cell, photosynthesis, dna, organism, plant, animal
	•	Chemistry → atom, molecule, reaction, acid, base, compound
	•	Math → algebra, geometry, integral, derivative, equation, matrix
	•	History → war, king, empire, revolution, ancient, medieval
	•	General → fallback if no keyword matches

Database
	•	Default DB → H2 (in-memory)
	•	H2 Console → http://localhost:8080/h2-console
	•	JDBC URL → jdbc:h2:mem:flashcards
