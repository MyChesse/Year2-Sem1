/*package Gkutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GkDBconnect {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		String ussername = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examdatabase?characterEncoding=utf8",ussername,password);
		
		return con;
	}
}
*/

package Gkutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GkDBconnect {
    
    private static GkDBconnect instance;
    private Connection connection;
    private String username = "root";
    private String password = "1234";
    private String url = "jdbc:mysql://localhost:3306/examdatabase?characterEncoding=utf8";

    // Private constructor to prevent direct instantiation
    private GkDBconnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, username, password);
    }

    // Global access point with lazy initialization
    public static GkDBconnect getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new GkDBconnect();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
