import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your math problem: ");

        while(true) {
            String[] mathProblem = scanner.nextLine().split(" ");

            Calculate.interpret(mathProblem);
            Calculate.simpleMath();
        }
    }
}

