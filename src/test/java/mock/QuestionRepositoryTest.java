package mock;

import org.example.model.Question;
import org.example.repository.dao.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionRepositoryTest implements QuestionRepository {
    private List<Question> testQuestions = List.of(
            Question.builder().id(1).text("1 In object-oriented computer programming (OOP) languages, the notion of encapsulation").topic("encapsulation").build(),
            Question.builder().id(2).text("2 refers to the bundling of data").topic("encapsulation").build(),
            Question.builder().id(3).text("3 refers to the bundling of data").topic("encapsulation").build(),
            Question.builder().id(4).text("4 Containers are just one example").topic("encapsulation").build(),
            Question.builder().id(5).text("5 coding where data and ").topic("encapsulation").build(),
            Question.builder().id(6).text("6 encapsulation").topic("encapsulation").build(),
            Question.builder().id(7).text("7 encapsulation").topic("encapsulation").build(),
            Question.builder().id(8).text("8 encapsulation").topic("encapsulation").build(),
            Question.builder().id(10).text("9 encapsulation").topic("encapsulat").build(),
            Question.builder().id(11).text("10 encapsulation").topic("encapsulation").build(),
            Question.builder().id(12).text("11 encapsulation").topic("encapsuln").build(),
            Question.builder().id(13).text("12 encapsulation").topic("encapsulation").build(),
            Question.builder().id(14).text("13 encapsulation").topic("encapsulation").build(),
            Question.builder().id(15).text("14 encapsulation").topic("encapsulation").build(),
            Question.builder().id(16).text("15 encapsulation").topic("encaplation").build(),
            Question.builder().id(17).text("16 encapsulation").topic("encapsulation").build(),
            Question.builder().id(18).text("17 encapsulation").topic("encapsulation").build(),
            Question.builder().id(19).text("18 encapsulation").topic("encalation").build(),
            Question.builder().id(20).text("19 encapsulation").topic("encapsulation").build()
    );

    public List<Question> mutableQuestions = new ArrayList<>(testQuestions);


    @Override
    public Question get(int id) {
        return null;
    }

    @Override
    public void save(Question question) {
        mutableQuestions.add(question);
    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < mutableQuestions.size(); i++) {
            if (mutableQuestions.get(i).getId() == id) {
                mutableQuestions.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Question> getByTopic(String topic) {
        return testQuestions;
    }

    @Override
    public List<Question> getAllQuestions() {
        return testQuestions;
    }

    @Override
    public Question getRndQuestion() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(testQuestions.size());
        return testQuestions.get(randomIndex);
    }
}
