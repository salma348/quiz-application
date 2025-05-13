import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Welcome to SmartQuiz ====");
        System.out.println("1. Create Quiz (Admin)");
        System.out.println("2. Take Quiz (User)");
        System.out.print("Choose an option: ");

        int choice = sc.nextInt();
        sc.nextLine();  // consume newline

        if (choice == 1) {
            QuizCreator.createQuiz();
        } else if (choice == 2) {
            QuizTaker.takeQuiz();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
