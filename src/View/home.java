package View;
import java.util.Date;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import View.detail;
public class home extends JFrame implements ActionListener,ItemListener {
	JPanel container, searchPn, catePn,header;
	JLabel title, lb1,lb2;
	JTextField inp;
	JComboBox cb;
	JTable table;
	JScrollPane scrollPane;
	public void GUI() {
		title = new JLabel("Ứng dụng tìm việc làm");
		header = new JPanel(new FlowLayout(FlowLayout.CENTER));
		header.add(title);
		
		
		lb1 = new JLabel("Tìm kiếm :");
		inp = new JTextField(20);
		searchPn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		searchPn.add(lb1);
		searchPn.add(inp);
		
		
		lb2 = new JLabel("Ngành :");
		String[] items = {"CNTT", "Kinh tế", "Vận tải", "Xây dựng", "Ngoại ngữ"};
    	cb = new JComboBox<>(items);
    	catePn = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	catePn.add(lb2);
    	catePn.add(cb);
		
		container = new JPanel();
		table = new JTable();
		scrollPane = new JScrollPane(table);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(header);
		container.add(searchPn);
		container.add(catePn);
		container.add(scrollPane);
		add(container);
		setSize(500,500);
		show();
	}
	public void actionPerformed(ActionEvent e) {}
	 public void itemStateChanged( ItemEvent e) {}
	public home() {
		super();
		GUI();
	}
	public static void main(String [] agr) {
		new home();
		new detail();
	}
}
