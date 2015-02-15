package gui;
import java.sql.*;

import javax.swing.*;

public class Sqlite
{
	Connection c=null;
	public static Connection dbconn()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","harsh");
			JOptionPane.showMessageDialog(null, "connection successful");
			return c;
		}
		catch(Exception e)
		{
			//System.out.println(e);
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
