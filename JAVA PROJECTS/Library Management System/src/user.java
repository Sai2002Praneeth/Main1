import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class user extends JFrame {
static user frame;
private JPanel contentPane;
private JButton registerbtn;
private JButton loginbtn;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame= new user();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public user()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(450, 190, 800, 500);
 setResizable(false);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 JLabel lblNewLabel = new JLabel("USER");
 lblNewLabel.setForeground(Color.BLACK);
 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
 lblNewLabel.setBounds(320, 13, 273, 93);
 contentPane.add(lblNewLabel);
 
 registerbtn = new JButton("Register");
 registerbtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
 registerbtn.setBounds(270, 150, 200, 70);
 
 loginbtn = new JButton("Login");
 loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
 loginbtn.setBounds(270, 250, 200, 70);
 
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(620, 350, 100, 70);
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
LMS.main(new String[]{});
frame.dispose();
}
});
 
 registerbtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
register.main(new String[]{});
frame.dispose();
}
 });
loginbtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
login.main(new String[]{});
frame.dispose();
}
});
 contentPane.add(loginbtn);
 contentPane.add(registerbtn);
 contentPane.add(btnBack);
}
}
