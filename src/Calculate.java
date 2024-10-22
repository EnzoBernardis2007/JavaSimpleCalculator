import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Calculate {
    private static List<String> usedOperations = new ArrayList<>();
    private static List<Double> numbers = new ArrayList<>();

    private static String[] listedOperations = {
            "sqrt",
            "^",
            "/",
            "*",
            "-",
            "+"
    };

    public static void interpret(String[] mathProblem) {
        usedOperations.clear();
        numbers.clear();

        try {
            for (String position : mathProblem) {
                boolean isOperation = false;
                for (String listedOperation : listedOperations) {
                    if (Objects.equals(position, listedOperation)) {
                        usedOperations.add(position);
                        isOperation = true;
                        break;
                    }
                }

                if(!isOperation) {
                    numbers.add(Double.parseDouble(position));
                }
            }
        } catch (Exception e){
            System.out.println("Insert a valid expression: " + e.getMessage());
        }
    }

    public static void simpleMath() {
        for(String listedOperation : listedOperations) {
            while(usedOperations.contains(listedOperation)) {
                int i = usedOperations.indexOf(listedOperation);
                boolean isSqrt = false;

                switch(listedOperation) {
                    case "sqrt":
                        numbers.set(i, Math.sqrt(numbers.get(i)));
                        isSqrt = true;
                        break;
                    case "^":
                        numbers.set(i, Math.pow(numbers.get(i), numbers.get(i + 1)));
                        break;
                    case "/":
                        numbers.set(i, numbers.get(i) / numbers.get(i + 1));
                        break;
                    case "*":
                        numbers.set(i, numbers.get(i) * numbers.get(i + 1));
                        break;
                    case "-":
                        numbers.set(i, numbers.get(i) - numbers.get(i + 1));
                        break;
                    case "+":
                        numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                        break;
                }

                usedOperations.remove(i);

                if(!isSqrt) {
                    numbers.remove(i + 1);
                }
            }
        }

        System.out.println("Result = " + numbers.getFirst());
    }
}
