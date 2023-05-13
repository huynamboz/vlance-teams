package View;
import java.util.Date;
import DAL.DBHelper;
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
	JButton add;
	public void GUI() {
		title = new JLabel("Ứng dụng tìm việc làm");
		header = new JPanel(new FlowLayout(FlowLayout.CENTER));
		header.add(title);
		add = new JButton("Add job");
		add.addActionListener(this);
		
		lb1 = new JLabel("Tìm kiếm :");
		inp = new JTextField(20);
		searchPn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		searchPn.add(lb1);
		searchPn.add(inp);
		searchPn.add(add);
		
		
		lb2 = new JLabel("Ngành :");
		String[] items = {"CNTT", "Kinh tế", "Vận tải", "Xây dựng", "Ngoại ngữ"};
    	cb = new JComboBox<>(items);
    	catePn = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	catePn.add(lb2);
    	catePn.add(cb);
		
		container = new JPanel();
		table = new JTable();
		
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint()); // Xác định hàng được chọn
                
                int columnCount = table.getColumnCount();
                
                String[] data = new String[columnCount];
                
                for (int column = 0; column < columnCount; column++) {
                 
                    Object value = table.getValueAt(row, column);
                    
                    // Chuyển đổi giá trị sang kiểu String và lưu vào mảng data
                    data[column] = String.valueOf(value);
                }
                new detail(data);
                // Sử dụng mảng data theo nhu cầu của bạn
                // Ví dụ: in giá trị lên console
                for (String value : data) {
                    System.out.println("Value: " + value);
                }
            }
        });
		
		
		scrollPane = new JScrollPane(table);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(header);
		container.add(searchPn);
		container.add(catePn);
		container.add(scrollPane);
		add(container);
		setSize(500,500);
		show();
		DefaultTableModel model = new DefaultTableModel();
		//add new column name
		for (String columnName : DBHelper.Instance().getDataCols()) {
		    model.addColumn(columnName);
		}
		for( String[] row : DBHelper.Instance().getDataRows()) {
			model.addRow(row);
		}
		table.setModel(model);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			new addForm();
		}
	}
	 public void itemStateChanged( ItemEvent e) {}
	public home() {
		super();
		GUI();
	}
}
