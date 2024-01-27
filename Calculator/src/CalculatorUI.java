import java.util.Scanner;

public class CalculatorUI {
    private Calculator calculator;
    private Scanner scanner;

    public CalculatorUI() {
        calculator = new Calculator();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("Введите первое число: ");
            double operand1 = scanner.nextDouble();

            System.out.print("введите operation: ");
            char operator = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            double operand2 = scanner.nextDouble();



            double result = calculator.performOperation(operand1, operand2, operator);
            System.out.println("ответ: " + result);

            System.out.print("хотите продолжить?(д/н): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("д")) {
                break;
            }
        }
    }
}
