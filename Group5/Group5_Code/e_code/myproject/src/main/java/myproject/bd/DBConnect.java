package myproject.bd;
import java.sql.*;
public class DBConnect {
	private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private String DBURI = "jdbc:mysql://localhost:3306/javauser?useSSL=false&serverTimezone=UTC";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "Dajacky1";
	private Connection conn = null;

public  DBConnect() {
    try {
        Class.forName(DBDRIVER);
        this.conn = DriverManager.getConnection( DBURI,DBUSER,DBPASSWORD);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public Connection getConnection() {
    return this.conn;
}

public void close() {
    try {
        this.conn.close();
    } catch (Exception e) {
    }
}
}