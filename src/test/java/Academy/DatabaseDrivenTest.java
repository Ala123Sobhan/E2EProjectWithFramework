package Academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDrivenTest {
	
	public static void getData() throws SQLException {

	String host="localhost";

	String port= "3306";

	Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "root");

	Statement s=con.createStatement();
	
	boolean rs1 = s.execute("Insert into Employeeinfo values('Momisa', 09, 'Ban', 67)");
		

	ResultSet rs=s.executeQuery("select * from Employeeinfo");

	System.out.println(rs);
	while(rs.next()) {
	System.out.println(rs.getString("name")+" - "+rs.getString("location"));
	}
	}
	
	
	
	public static void main(String [] args) throws SQLException
	{
		getData();
	}
}
