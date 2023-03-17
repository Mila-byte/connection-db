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

    @Test
    public void deleteById() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        questionRepository.delete(8);
    }
    @Test
    public void updateById() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        Question result = questionRepository.get(5);
        questionRepository.update(new Question(result.getId(), "Principles OOP", "OOp"));
    }
    @Test
    public void saveByParameters() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        questionRepository.save(new Question("question", "topic"));
    }
}
