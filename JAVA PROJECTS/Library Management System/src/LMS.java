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
public class LMS extends JFrame {
static LMS frame;
private JPanel contentPane;
private JButton userbtn;
private JButton adminbtn;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame= new LMS();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public LMS()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(450, 190, 800, 500);
 setResizable(false);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 JLabel lblNewLabel = new JLabel("LMS");
 lblNewLabel.setForeground(Color.BLACK);
 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
 lblNewLabel.setBounds(320, 13, 273, 93);
 contentPane.add(lblNewLabel);
 
 userbtn = new JButton("USER");
 userbtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
 userbtn.setBounds(270, 150, 200, 70);
 
 adminbtn = new JButton("ADMIN");
 adminbtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
 adminbtn.setBounds(270, 250, 200, 70);
 
 userbtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
user.main(new String[]{});
frame.dispose();
}
 });
adminbtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
admin.main(new String[]{});
frame.dispose();
}
});
 contentPane.add(userbtn);
 contentPane.add(adminbtn);
}
}