import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface CustomerService {


    static void addCustomer(String first_name, String last_name) {

        EstablishConnection connection = new EstablishConnection();
        String query = "insert into customer(customer_name,customer_last_name)" +
                "values(?,?)";

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            int resultSet = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Błąd dodawania wartości!");
        }

        connection.shutDownConnection();
    }

    static void deleteCustomerByFullName(String first_name, String last_name) {
        EstablishConnection connection = new EstablishConnection();
        String query = "delete from customer where customer_name = ? and customer_last_name = ?";

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet + " usunięto wartości");
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Błąd dodawania wartości!");
        }

        connection.shutDownConnection();


    }
}
