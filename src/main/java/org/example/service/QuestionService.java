package org.example.service;

import org.example.model.Question;
import org.example.repository.dao.QuestionRepository;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionService {
    private final QuestionRepository questionRepository;
    private final Map<String, List<Question>> questionsByTopic = new HashMap<>();

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getRndQuestionByTopic(String topic) {
        List<Question> questions = questionsByTopic.computeIfAbsent(topic, questionRepository::getByTopic);
        questionsByTopic.put(topic, questions);
        int randomNum = ThreadLocalRandom.current().nextInt(questions.size());
        return questions.get(randomNum);
    }


    public Question getRndQuestion() throws SQLException {
        List<Question> questions = questionRepository.getAllQuestions();
        int randomNum = ThreadLocalRandom.current().nextInt(0, questions.size());
        return questions.get(randomNum);
    }

    public void recordQuestion(Question question) {
        questionRepository.save(question);
    }

    public void deleteQuestion(int id) {
        questionRepository.delete(id);
    }
}
