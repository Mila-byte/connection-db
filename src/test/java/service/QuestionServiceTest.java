package service;

import mock.QuestionRepositoryTest;
import org.example.model.Question;
import org.example.service.QuestionService;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Optional;

public class QuestionServiceTest {
    private QuestionRepositoryTest repository = new QuestionRepositoryTest();


    @Test
    public void getRndQuestionByTopicTest() {
        QuestionService questionService = new QuestionService(repository);
        Question result = questionService.getRndQuestionByTopic("encapsulation");
        System.out.println(result);
    }

    @Test
    public void getRndQuestionTest() throws SQLException {
        QuestionService questionService = new QuestionService(repository);
        Question result = questionService.getRndQuestion();
        System.out.println(result);
    }

    @Test
    public void recordQuestionTest() {
        QuestionService questionService = new QuestionService(repository);
        Question newQuestion = new Question("what is java?", "topic");
        questionService.recordQuestion(newQuestion);
        Assert.assertTrue(repository.mutableQuestions.contains(newQuestion));
    }

    @Test
    public void deleteQuestionByIdTest() {
        QuestionService questionService = new QuestionService(repository);
        questionService.deleteQuestion(11);
        Optional<Question> result = repository.mutableQuestions.stream()
                .filter(question -> question.getId() == 11)
                .findFirst();
        Assert.assertFalse(result.isPresent());
    }
}
