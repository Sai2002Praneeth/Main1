import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class register extends JFrame {
static register frame;
 private static final long serialVersionUID = 1L;
 private JTextField textField,txtField;
 private JPasswordField passwordField;
 private JButton btnNewButton;
 private JLabel label;
 private JPanel contentPane;
 public static void main(String[] args) {
 EventQueue.invokeLater(new Runnable() {
 public void run() {
 try {
 frame = new register();
 frame.setVisible(true);
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 });
 }
 
 public register() {
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(450, 190, 800, 500);
 setResizable(false);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 JLabel lblNewLabel = new JLabel("Register");
 lblNewLabel.setForeground(Color.BLACK);
 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
 lblNewLabel.setBounds(320, 13, 273, 93);
 contentPane.add(lblNewLabel);
 txtField = new JTextField();
 txtField.setFont(new Font("Tahoma", Font.PLAIN, 32));
 txtField.setBounds(400,140 , 281, 58);
 contentPane.add(txtField);
 txtField.setColumns(10);
 
 textField = new JTextField();
 textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
 textField.setBounds(400, 199, 281, 58);
 contentPane.add(textField);
 textField.setColumns(10);
 
 passwordField = new JPasswordField();
 passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
 passwordField.setBounds(400, 260, 281, 58);
 contentPane.add(passwordField);
 JLabel lblUsername = new JLabel("Student ID");
 lblUsername.setBackground(Color.BLACK);
 lblUsername.setForeground(Color.BLACK);
 lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblUsername.setBounds(160, 140, 193, 52);
 contentPane.add(lblUsername);
 JLabel lblname = new JLabel("Student name");
 lblname.setBackground(Color.BLACK);
 lblname.setForeground(Color.BLACK);
 lblname.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblname.setBounds(160, 199, 193, 52);
 contentPane.add(lblname);
 
 JLabel lblPassword = new JLabel("Password");
 lblPassword.setForeground(Color.BLACK);
 lblPassword.setBackground(Color.CYAN);
 lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblPassword.setBounds(160, 260, 193, 52);
 contentPane.add(lblPassword);
 btnNewButton = new JButton("Register");
 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnNewButton.setBounds(300, 350, 200, 70);
 
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(650, 380, 100, 50);
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
user.main(new String[]{});
frame.dispose();
}
});
contentPane.add(btnBack);
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 String userName = txtField.getText();
 String name=textField.getText();
 String password = passwordField.getText();
 
 try
 {
 Connection connection=DataBase.getConnection();
 PreparedStatement stmt = connection.prepareStatement("INSERT INTO student(student_id,student_name,password) VALUES(?,?,?)");
 
 stmt.setString(1,userName);
 stmt.setString(2,name);
 stmt.setString(3,password);
 stmt.executeUpdate();
JOptionPane.showMessageDialog(register.this,"Registered");
 user.main(new String[]{});
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
 }
 });
 contentPane.add(btnNewButton);
 label = new JLabel("");
 label.setBounds(0, 0, 1008, 562);
 contentPane.add(label);
 }
}
