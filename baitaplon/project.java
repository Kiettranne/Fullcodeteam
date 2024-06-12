import javax.swing.*;
import java.awt.*;
import java.util.Hashmap;
import java.util.Map;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class baitap extends JFrame {
	JButton start;
	JLabel heading;
	JButton next;
	JButton tieptuc;
	JTextField ans;
	JLabel que;
	JLabel op1;
	
	JLabel qu1;
	JLabel qu2;
	JLabel qu3;
	JLabel qu4;
	
	JLabel op2;
	JLabel op3;
	JLabel op4;
	JLabel quest;
	JPanel questionPanel;
	
	public static void main(String[] args) {
		public baitap() {
			JFrame j = new JFrame("KHAO SAT ONLINE");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300,200);
			heading = new JLabel("KHAO SAT HOC VIEN");
			frame.add(heading);
			qu1 = new JLabel("1.");
			qu2 = new JLabel("2.");
			qu3 = new JLabel("3.");
			qu4 = new JLabel("4.");
			qu1.setBounds(80,150, 80,30);
			qu2.setBounds(80, 200, 80, 30);
			qu3.setBounds(80, 250, 80, 30);
			qu4.setBounds(80, 300, 80, 30);
			quest = new JLabel("Cau hoi :");
			quest.setBounds(100, 20, 300, 80);
			quest.setForeground(Color.red);
			heading.setFont(new Font("Arial",Font.BOLD,20));
			heading.setBounds(200,20,300,40);
			heading.setForeground(Color.red);
			tieptuc = new JButton("Tiep tuc");		
			next.setBounds(400,300,150,30);
			tieptuc.setBounds(400,450,150,30);
			questionPanel = new JPanel(); // Initialize the panel
			questionPanel.setLayout(null); // Use null layout for precise positioning
			questionPanel.setBounds(0, 0, 600, 600);
			add(questionPanel);
			add(next);
			
			questionPanel.add(heading);
			
			setLayout(null);  
			setSize(600,500);
			setLocationRelativeTo(null);
			setVisible(true);
			next = new JButton("Next");
			frame.add(next);
		button.addActionListener(new ActionListener());
	}
}
	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText("Ban da nhap vao nut!");
		}
		frame.setVisible(true);
}

