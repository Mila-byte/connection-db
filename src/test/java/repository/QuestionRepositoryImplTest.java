package repository;

import org.example.model.Question;
import org.example.repository.QuestionRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class QuestionRepositoryImplTest {
    private String user = "root";
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private Connection connection;

    @Before
    public void init() throws SQLException {
        connection = DriverManager.getConnection(url, user, "root");
    }
    @Test
    public void getText() {
       QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
       Question result = questionRepository.get(5);
       System.out.println(result);
    }

    @Test
    public void getByTopic() {
       QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
       List<Question> result = questionRepository.getByTopic("OOP");
       System.out.println(result);
    }
}
