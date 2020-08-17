import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        EstablishConnection connection = new EstablishConnection();
        String query = "select * from movies where movie_id = 15;";

        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet set = statement.executeQuery(query);
            while (set.next()) {
                System.out.println(set.getString("movie_id")+"|"+ set.getString("movie_title")+"|"
                        +set.getString("movie_year")+"|"+set.getString("movie_genre"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        connection.shutDownConnection();
    }

}
