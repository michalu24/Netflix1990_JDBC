import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Rent {
    final EstablishConnection connection = new EstablishConnection();
    private int movieID;

    public Rent() {
    }

    public void showAvailableMovies() {
        try {
            String query = "select * from movies where status = 'Free';";
            Statement statement = this.connection.getConnection().createStatement();
            ResultSet set = statement.executeQuery(query);

            while (set.next()) {
                System.out.println(set.getString("movie_id") + " | " + set.getString("movie_title")
                        + " | " + set.getString("movie_genre") + " | " + set.getString("status"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
