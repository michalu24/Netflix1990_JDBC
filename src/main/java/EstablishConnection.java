import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class EstablishConnection {
    private String url;
    private String user;
    private String pswd;
    private Connection connection;

    public EstablishConnection() {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream resourceFileInput = loader.getResourceAsStream("config.properties");

        try {
            properties.load(resourceFileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.url = properties.getProperty("url");
        this.user = properties.getProperty("user");
        this.pswd = properties.getProperty("pswd");

        try {
            this.connection = DriverManager.getConnection(
                    this.url,
                    this.user,
                    this.pswd
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void shutDownConnection() {
        try {
            this.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
