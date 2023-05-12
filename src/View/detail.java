package View;
import java.util.Date;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
public class detail extends JFrame implements ActionListener {
	JLabel title ,name, nameJob, content, contentJob, emailLb, email, salaryLb, salary, line;  
	JPanel footer, container, TPanel, NameP, NJP, contentP, cjP;
	public void UI() {
		title = new JLabel("<html><p style=\"font-size: 20px\">Chi tiết công việc</p></html>");
		name = new JLabel("<html><u style=\"color: red;\"><b>Tên công việc</b></u></html>");
		nameJob = new JLabel("hack ưebsite");
		content = new JLabel("<html><u style=\"color: red;\"><b>Chi tiết</b></u></html>");
		contentJob = new JLabel(" Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn câcscascascSang Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn   Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn   Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn chuẩn bị máy tính và môi trường đầy đủ để làm bài.");
		contentJob.setText("<html><p style=\"width:400px\">Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn câcscascascSang Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn   Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn   Chủ Nhật ngày 14/5/2023 các bạn sẽ làm bài Test Thực Hành Java vào lúc 7h30 tại C202-C204-C205. Các bạn chuẩn bị máy tính và mô</p></html>");
		salaryLb = new JLabel("Lương : ");
		salary = new JLabel("900000");
		
		line = new JLabel(" | ");
		
		emailLb = new JLabel("Gửi CV vào Email : ");
		email = new JLabel("cty.hr@gmail.com");
		
		footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
		footer.add(salaryLb);
		footer.add(salary);
		footer.add(line);
		footer.add(emailLb);
		footer.add(email);
		
		TPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		TPanel.add(title);
		
		NameP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		NameP.add(name);
		
		NJP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		NJP.add(nameJob);
		
		contentP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contentP.add(content);
		
		cjP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cjP.add(contentJob);
		
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(TPanel);
		container.add(NameP);
		container.add(NJP);
		container.add(contentP);
		container.add(cjP);
		container.add(footer);
		add(container);
		setSize(650,400);
		show();
	}
	public void actionPerformed(ActionEvent e) {}
	public detail() {
		super();
		UI();
	}
}
