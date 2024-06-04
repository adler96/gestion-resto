package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBase {

    private Connection conn = null;
    public Statement st = null;

    public Connection conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // or the driver you are using
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
            this.st = this.conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
    }

    public void disconnect() {
        try {
            if (this.st != null) this.st.close();
            if (this.conn != null) this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
