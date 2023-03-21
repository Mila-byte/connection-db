package org.example;

import org.example.model.Question;
import org.example.repository.ConnectionSingleton;
import org.example.repository.QuestionRepositoryImpl;
import org.example.service.QuestionService;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static QuestionService questionService = new QuestionService(new QuestionRepositoryImpl(ConnectionSingleton.getConnection()));

    public static void main(String[] args) {
        System.out.println("write command: GENERATE, INSERT or DELETE");
        String command = scanner.next();
        switch (command.toUpperCase()) {
            case "GENERATE" -> getRndQuestionByTopic();
            case "INSERT" -> addQuestion();
            case "DELETE" -> deleteQuestionById();
            default -> close();
        }
    }

    private static void close() {
        System.out.println("not found command");
        scanner.close();
    }

    private static void getRndQuestionByTopic() {
        System.out.println("write topic");
        String topic = scanner.next();
        Question question = questionService.getRndQuestionByTopic(topic);
        System.out.println(question.getText());
        System.out.println("Do you wanna a next question? write 'yes' if want");
        if (scanner.next().equals("yes")) {
            getRndQuestionByTopic();
        } else if (!scanner.next().equals("yes")) {
            scanner.close();
        }
    }

    private static void addQuestion() {
        System.out.println("write topic");
        String topic = scanner.useDelimiter("\n").next();
        System.out.println("write text");
        String text = scanner.useDelimiter("\n").next();
        questionService.recordQuestion(new Question(text, topic));
        System.out.println("Do you wanna add question? write 'yes' if want");
        if (scanner.next().equals("yes")) {
            addQuestion();
        } else {
            scanner.close();
        }
    }

    private static void deleteQuestionById() {
        System.out.println("write id Question what do you want to delete");
        int id = scanner.nextInt();
        questionService.deleteQuestion(id);
        System.out.println("Delete another question? write 'yes' if want");
        if (scanner.next().equals("yes")) {
            deleteQuestionById();
        } else {
            scanner.close();
        }
    }
}