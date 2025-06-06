package src;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = List.of(
                new Question("Какой язык компилируется в байт-код?", List.of("Java", "Python", "HTML"), 1),
                new Question("Сколько бит в байте?", List.of("8", "16", "32"), 1),
                new Question("Сколько рук у человека?", List.of("2", "4", "6"), 1),
                new Question("Сколько байт в 1 килобайте?", List.of("8", "1024", "1000"), 2),
                new Question("Сколько ног у человека ?", List.of("8", "2", "32"), 2),
                new Question("Сколько байт в int?", List.of("1", "2", "4", "8"), 3),
                new Question("Что такое null?", List.of("Псевдоним для 0", "В java такого нет", "Специальное значение для ссылок"), 3)
        );
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) {
            System.out.println("\n" + q.getText());
            List<String> options = q.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Ваш ответ: ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("Правильно!");
                score++;
            } else {
                System.out.println("Неправильно. Правильный ответ: " + q.getCorrectAnswerIndex());
            }
        }

        System.out.println("\nВаш результат: " + score + "/" + questions.size());
        scanner.close();
    }
}
