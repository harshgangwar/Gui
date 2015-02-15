 package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui 
{

// 	Connection c=null;
	ResultSet r=null;
	PreparedStatement p=null;
	
	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try
				{
					
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection c=null;
	public Gui() {
		initialize();
		c=Sqlite.dbconn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="select * from list where username =? and password=?";
					PreparedStatement p=c.prepareStatement(query);
					p.setString(1,textField.getText());
					p.setString(2,passwordField.getText());
					ResultSet r=p.executeQuery();
					int count=0;
					while(r.next())
					{
						count+=1;
						
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null,"Username and Password is correct");
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null,"Dulpicate Username and Password");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Username and Password is uncorrect..Try Again");
					}
					r.close();// to close the db connection
					p.close();// to close the db connection
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton.setBounds(129, 168, 135, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblUserName = new JLabel("user name");
		lblUserName.setBounds(60, 38, 96, 23);
		frame.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(140, 39, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(60, 84, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 81, 86, 20);
		frame.getContentPane().add(passwordField);
		
		
		//start ur code
		
		
		
		
		
		
	}
}
