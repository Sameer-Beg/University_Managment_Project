package UniverSityManagmentPckg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conection {

    public Connection connection;
    public Statement statement;

    public Conection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection  = DriverManager.getConnection(
                    "jdbc:mysql:///Universitymanagment",
                    "root",
                    "sameer1j"
            );
            statement = connection.createStatement();
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
