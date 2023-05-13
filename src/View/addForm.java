package View;
import java.util.Date;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAL.DAL;
import BLL.BLL;

import java.text.SimpleDateFormat;
import java.util.Date;
public class addForm extends JFrame implements ActionListener 
{
	JLabel title ,name, nameJob, salary, address, content, time;  
	JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
	JButton btSubmit, btCancel;
	JPanel controlPanel, pn1, pn2, pn3;
	DAL dal;
	BLL bll;
	
	public void GUI() 
	{
		title = new JLabel("Title");
		name = new JLabel("Name");
		nameJob = new JLabel("Job");
		salary = new JLabel("Salary");
		address = new JLabel("Address");
		content = new JLabel("Content");
		// time = new JLabel("Fulltime/PartTime");
	
		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);
		txt4 = new JTextField(20);
		txt5 = new JTextField(20);
		txt6 = new JTextField(20);
		// txt7 = new JTextField(10);
		
		btSubmit = new JButton("Submit");
		btCancel = new JButton("Cancel");
		
		controlPanel = new JPanel(new GridLayout(2,1));
		pn1 = new JPanel(new GridLayout(6,1));
		pn2 = new JPanel(new FlowLayout()); 
		pn3 = new JPanel(new GridLayout(2,1));
		
		pn1.add(title);
		pn1.add(txt1);
		
		pn1.add(name);
		pn1.add(txt2);
		
		pn1.add(nameJob);
		pn1.add(txt3);
		
		pn1.add(salary);
		pn1.add(txt4);
		
		pn1.add(address);
		pn1.add(txt5);
		
		pn1.add(content);
		pn1.add(txt6);
		
		pn2.add(btSubmit);
		pn2.add(btCancel);
		
		controlPanel.add(pn1);
		controlPanel.add(pn2);
		
		this.add(controlPanel);
		btSubmit.addActionListener(this);
		btCancel.addActionListener(this);
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void windowClosing(WindowEvent we)
	{
		dispose();
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btCancel) {
			dispose();
			System.exit(0);
		}

		else if(e.getSource() == btSubmit) 
		{
			String q1 = txt1.getText();
			String q2 = txt2.getText();
			String q3 = txt3.getText();
			String q4 = txt4.getText();
			String q5 = txt5.getText();
			String q6 = txt6.getText();
			
			bll.excuteDB(q1,q2,q3,q4,q5,q6);
		}
	}
	
	public addForm() {
		super();
		GUI();
		dal = new DAL();
		bll = new BLL();
	}
}