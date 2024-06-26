import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class books extends JFrame
{
 private static final long serialVersionUID = 1L;
 static books frame;
 private JButton btn1;
 private JButton btn2,btn3,btn4;
 private JLabel label;
 private JPanel contentPane;
 
public static void main(String userID) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
//String ID=userID;
frame = new books(userID);
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public books(String userID)
{
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(450, 190, 800, 500);
 setResizable(false);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 btn1 = new JButton("View Books");
 btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn1.setBounds(270, 80, 200, 70);
 
 btn2 = new JButton("Add Book");
 btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn2.setBounds(270, 160, 200, 70);
 
 btn3 = new JButton("My Books");
 btn3.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn3.setBounds(270, 240, 200, 70);
 
 btn4 = new JButton("Return Book");
 btn4.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn4.setBounds(270, 320, 200, 70);
 
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(650, 380, 100, 50);
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
LMS.main(new String[]{});
frame.dispose();
}
});
contentPane.add(btnBack);
 
 btn1.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 viewBooks.main(userID);
 frame.dispose(); 
 }
 });
 btn2.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 addBooks.main(userID);
 frame.dispose(); 
 }
 });
 btn3.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 myBooks.main(userID);
 frame.dispose(); 
 }
 });
 btn4.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 returnBook.main(userID);
 frame.dispose(); 
 }
 });
 contentPane.add(btn1);
 contentPane.add(btn2);
 contentPane.add(btn3);
 contentPane.add(btn4);
 label = new JLabel("");
 label.setBounds(0, 0, 562, 562);
 contentPane.add(label);
}
}
