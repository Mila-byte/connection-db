package org.example.service;

import org.example.model.Question;
import org.example.repository.QuestionRepositoryImpl;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionService {
    private QuestionRepositoryImpl questionRepository;

    public QuestionService(QuestionRepositoryImpl questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getRndQuestionByTopic(String topic) {
        List<Question> topics = questionRepository.getByTopic(topic);
        int randomNum = ThreadLocalRandom.current().nextInt(0, topics.size());
        return topics.get(randomNum);
    }

}
