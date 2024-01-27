import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculatorDAO {

    private Connection connection;

    public CalculatorDAO() {
        String url =  "jdbc:sqlite:calculator.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCalculation(String operation, double operand1, double operand2, double result) {
        String sql = "INSERT INTO calculations (operation, operand1, operand2, result) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, operation);
            statement.setDouble(2, operand1);
            statement.setDouble(3, operand2);
            statement.setDouble(4, result);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
