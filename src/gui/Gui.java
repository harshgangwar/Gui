package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Gui 
{

	Connection c=null;
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
	public Gui() {
		initialize();
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
	}
}
