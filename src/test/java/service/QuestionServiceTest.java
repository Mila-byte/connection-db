package service;

import org.example.model.Question;
import org.example.repository.QuestionRepositoryImpl;
import org.example.service.QuestionService;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QuestionServiceTest {
    private String user = "root";
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private Connection connection;

    @Before
    public void init() throws SQLException {
        connection = DriverManager.getConnection(url, user, "root");
    }
    @Test
    public void getRndQuestionByTopic() {
        QuestionService questionService = new QuestionService(new QuestionRepositoryImpl(connection));
        Question result = questionService.getRndQuestionByTopic("Incaptuliation");
        System.out.println(result);
    }
}
