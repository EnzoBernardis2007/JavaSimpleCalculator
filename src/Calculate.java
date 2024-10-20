import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculate {
    private static List<String> usedOperations = new ArrayList<>();
    private static List<Double> numbers = new ArrayList<>();

    public static void interpret(String[] mathProblem) {
        String[] listedOperations = {
                "+",
                "-",
        };

        usedOperations.clear();
        numbers.clear();

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
    }

    public static void simpleMath() {
        while (numbers.size() > 1) {
            switch (usedOperations.getFirst()) {
                case "+":
                    double resultPlus = numbers.get(0) + numbers.get(1);
                    numbers.set(0, resultPlus);
                    numbers.remove(1);
                    break;
                case "-":
                    double resultMinus = numbers.get(0) - numbers.get(1);
                    numbers.set(0, resultMinus);
                    numbers.remove(1);
                    break;
            }

            usedOperations.removeFirst();
        }

        System.out.println("Resultado = " + numbers.getFirst());
    }
}
