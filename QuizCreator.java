import java.io.*;
import java.util.*;

public class QuizCreator {
    public static void createQuiz() {
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("quiz_data.txt"))) {
            System.out.print("Enter number of questions: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nQuestion " + (i + 1));

                System.out.print("Question type (SINGLE / MULTI): ");
                String type = sc.nextLine().toUpperCase();

                System.out.print("Enter question: ");
                String question = sc.nextLine();

                List<String> options = new ArrayList<>();
                for (int j = 1; j <= 4; j++) {
                    System.out.print("Option " + j + ": ");
                    options.add(sc.nextLine());
                }

                System.out.print("Enter correct option(s) (e.g., 2 or 1,3): ");
                String correct = sc.nextLine();

                // Write to file
                writer.write(type); writer.newLine();
                writer.write(question); writer.newLine();
                for (String opt : options) {
                    writer.write(opt); writer.newLine();
                }
                writer.write(correct); writer.newLine();
            }

            System.out.println("\n✅ Quiz created successfully and saved!");
        } catch (IOException e) {
            System.out.println("Error saving quiz.");
        }
    }
}
