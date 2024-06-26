import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class login extends JFrame {
static login frame;
private JPanel contentPane;
private JTextField textField;
private JPasswordField passwordField;
private JButton btnNewButton;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame = new login();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public login()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 190, 800, 500);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
 JLabel lblNewLabel = new JLabel("Login");
 lblNewLabel.setForeground(Color.BLACK);
 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
 lblNewLabel.setBounds(320, 13, 273, 93);
 contentPane.add(lblNewLabel);
 
 JLabel lblUsername = new JLabel("Student ID");
 lblUsername.setBackground(Color.BLACK);
 lblUsername.setForeground(Color.BLACK);
 lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblUsername.setBounds(160, 140, 193, 52);
 contentPane.add(lblUsername);
 
 JLabel lblPassword = new JLabel("Password");
 lblPassword.setForeground(Color.BLACK);
 lblPassword.setBackground(Color.CYAN);
 lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblPassword.setBounds(160, 230, 193, 52);
 contentPane.add(lblPassword);
 
 textField = new JTextField();
 textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
 textField.setBounds(400,140 , 281, 58);
 contentPane.add(textField);
 textField.setColumns(10);
 
 passwordField = new JPasswordField();
 passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
 passwordField.setBounds(400, 230, 281, 58);
 contentPane.add(passwordField);
 
 btnNewButton = new JButton("Login");
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
 String userID=textField.getText();
 String password = passwordField.getText();
 
 if(validiate(userID,password))
 {
 books.main(userID);
 frame.dispose();
 }
 else
 {
 JOptionPane.showMessageDialog(login.this, "ID or Password Incorrect","Login Error!", JOptionPane.ERROR_MESSAGE);
 textField.setText("");
 passwordField.setText("");
 } 
 }
 });
 contentPane.add(btnNewButton);
}
public static boolean validiate(String userID,String password)
{
boolean status=false;
try
 { 
Connection connection=DataBase.getConnection();
 
 PreparedStatement ps=connection.prepareStatement("select student_id,password from student where student_id=? and password=?");
 ps.setString(1,userID); 
ps.setString(2,password);
ResultSet rs=ps.executeQuery();
status=rs.next(); 
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
return status;
}
}
