package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DAL.DAL;

public class Login extends JFrame implements ActionListener{
	JPanel container, pn1,pn2,pn2_1, pn2_2, pn3;
	JButton btnLogin, btnRegister;
	JTable j;
	JLabel lb, lbUsername, lbPassword;
	TextField txtUsername, txtPassword;
	DAL dal;
	public void GUI() {
		try {
			pn1 = new JPanel(new FlowLayout());
			pn2 = new JPanel(new GridLayout(2,1));
			pn2_1 = new JPanel(new FlowLayout());
			pn2_2 = new JPanel(new FlowLayout()); 
			pn3 = new JPanel(new FlowLayout());
			
			container = new JPanel(new GridLayout(3,1));
	
			lb = new JLabel("Login");
			pn1.add(lb);
			
			lbUsername = new JLabel("Username:");
			txtUsername = new TextField(20);
			pn2_1.add(lbUsername);
			pn2_1.add(txtUsername);
			lbPassword = new JLabel("Password:");
			txtPassword = new TextField(20);
			pn2_2.add(lbPassword);
			pn2_2.add(txtPassword);
			pn2.add(pn2_1);
			pn2.add(pn2_2);
			

			btnLogin = new JButton("Login");
			btnRegister = new JButton("Register");
			pn3.add(btnLogin);
			pn3.add(btnRegister);
			btnLogin.addActionListener(this);
			btnRegister.addActionListener(this);
			
	        setSize(500, 250);
	        // Frame Visible = true
	        container.add(pn1);
			container.add(pn2);
			container.add(pn3);
			
	        add(container);
	        show();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin) {
			try {
				if (dal.login(txtUsername.getText(), txtPassword.getText())) {
					System.out.println("ok");
				} else {
					System.out.println("no");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.print(e1.getMessage());
			}
		}
	}
	public Login() {
		super();
		GUI();
		dal = new DAL();
	}

}
