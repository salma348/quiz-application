import java.io.*;
import java.util.*;

public class QuizTaker {
    public static void takeQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0, total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("quiz_data.txt"))) {
            String type;

            while ((type = reader.readLine()) != null) {
                String question = reader.readLine();
                List<String> options = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    options.add(reader.readLine());
                }
                Set<Integer> correctSet = Question.parseAnswers(reader.readLine());

                total++;
                System.out.println("\n" + question);
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }

                System.out.print("Your answer" + (type.equals("MULTI") ? "s (comma-separated)" : "") + ": ");
                Set<Integer> userSet = Question.parseAnswers(sc.nextLine());

                if (userSet.equals(correctSet)) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Incorrect. Correct answer(s): " + correctSet);
                }
            }

            System.out.println("\nQuiz completed! Your Score: " + score + " / " + total);
        } catch (IOException e) {
            System.out.println("Quiz file not found.");
        }
    }
}
