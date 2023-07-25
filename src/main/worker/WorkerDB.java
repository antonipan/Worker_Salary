import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WorkerDB  {
    private static final String USER = "root";
    private static final String PASSWORD = "Root!123";
    private static final String URL = "jdbc:mysql://localhost:3306/story?userSSL=false";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
        try {
            driver = new FabricMySQLDriver();
        } catch (SQLException e) {
            System.out.println("Произошла ошибка при создании драйвера. ");;
            return;
        }
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Не удалось зарегистрировать драйвер. ");
            return;
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("3 есть. ");
            System.out.println("Code...");
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }


    }

}
