package dao;
import java.sql.*;
public class ConnexionBase {
	Connection COO=null;
	public Statement st=null;
	String user="root";
	String MDP="";
	String Url="jdbc:mysql://localhost/gestion_resto";
	String drive="com.mysql.cj.jdbc.Driver";
	public void conn() {
		try {
			Class.forName(drive);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			COO= DriverManager.getConnection(Url, user, MDP);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st=COO.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
