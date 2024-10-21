import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculate {
    private static List<String> usedOperations = new ArrayList<>();
    private static List<Double> numbers = new ArrayList<>();

    static String[] listedOperations = {
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
            System.out.println("Insira uma expressão válida: " + e.getMessage());
        }
    }

    public static void simpleMath() {
        for(String listedOperation : listedOperations) {
            while(usedOperations.contains(listedOperation)) {
                int i = usedOperations.indexOf(listedOperation);

                switch(listedOperation) {
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

                numbers.remove(i + 1);
                usedOperations.remove(i);
            }
        }

        System.out.println("Resultado = " + numbers.getFirst());
    }
}
