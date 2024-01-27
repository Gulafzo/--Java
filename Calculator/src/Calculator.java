
public class Calculator {
    private CalculatorDAO calculatorDAO;

    public Calculator() {
        calculatorDAO = new CalculatorDAO();
    }

    public double performOperation(double operand1, double operand2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.out.println("Ошибка:деление на ноль");
                }
                break;
            default:
                System.out.println("Ошибка:недопустимый оператор");
        }
        calculatorDAO.saveCalculation(String.valueOf(operator), operand1, operand2, result);
        return result;
    }
}