import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
public class returnBook extends JFrame
{
static returnBook frame;
 private static final long serialVersionUID = 1L;
 private JButton btnNewButton;
 private JTextField textField,textField_2;
 private JPanel contentPane;
 
public static void main(String userID) 
{
EventQueue.invokeLater(new Runnable() 
{
public void run() 
{
try
{
frame = new returnBook(userID);
frame.setVisible(true);
} catch (Exception e) 
{
e.printStackTrace();
}
}
});
}
public returnBook(String userID)
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(450, 190, 800, 500);
 setResizable(false);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 textField = new JTextField();
 textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
 textField.setBounds(400,140 , 281, 58);
 contentPane.add(textField);
 textField.setColumns(10);
 
 /*textField_1 = new JTextField();
 textField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
 textField_1.setBounds(400, 199, 281, 58);
 contentPane.add(textField_1);
 textField_1.setColumns(10);*/
 
 textField_2 = new JTextField();
 textField_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
 textField_2.setBounds(400, 199, 281, 58);
 contentPane.add(textField_2);
 textField_2.setColumns(10);
 
 JLabel lblUsername = new JLabel("Book No");
 lblUsername.setBackground(Color.BLACK);
 lblUsername.setForeground(Color.BLACK);
 lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblUsername.setBounds(160, 140, 193, 52);
 contentPane.add(lblUsername);
 /*JLabel lblname = new JLabel("Student ID");
 lblname.setBackground(Color.BLACK);
 lblname.setForeground(Color.BLACK);
 lblname.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblname.setBounds(160, 199, 193, 52);
 contentPane.add(lblname);*/
 
 JLabel lblPassword = new JLabel("Return Date");
 lblPassword.setForeground(Color.BLACK);
 lblPassword.setBackground(Color.CYAN);
 lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblPassword.setBounds(160, 199, 193, 52);
 contentPane.add(lblPassword);
 
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(650, 380, 100, 50);
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
books.main(userID);
frame.dispose();
}
});
contentPane.add(btnBack);
 
 btnNewButton = new JButton("Return");
 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnNewButton.setBounds(300, 350, 200, 70);
 contentPane.add(btnNewButton);
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 int book_no=Integer.parseInt(textField.getText());
 String student_id=userID;
 String return_date=textField_2.getText();
 int status=0;
 try
 {
 int no_of_copies=0;
 int no_of_books=0;
 int rack_no=0;
 
 Connection connection=DataBase.getConnection();
 
 
 PreparedStatement stmt = connection.prepareStatement("insert into return(book_no,student_id,return_date) values(?,?,?)");
 stmt.setInt(1,book_no);
 stmt.setString(2,student_id);
 stmt.setString(3,return_date);
 status=stmt.executeUpdate();
 
 PreparedStatement ps=connection.prepareStatement("select no_of_copies from book where book_no=?");
 ps.setInt(1,book_no);
 ResultSet rs=ps.executeQuery();
 if(rs.next())
 {
 no_of_copies=rs.getInt("no_of_copies");
 }
 
 PreparedStatement ps0=connection.prepareStatement("select rack_no from book where book_no=?");
 ps0.setInt(1,rack_no);
 ps0.setInt(2,book_no);
 ResultSet rs1=ps0.executeQuery();
 if(rs1.next())
 {
 rack_no=rs1.getInt("rack_no");
 book_no=rs1.getInt("book_no");
 }
 
 PreparedStatement ps1=connection.prepareStatement("update book set no_of_copies=? where book_no=?");
 ps1.setInt(1,no_of_copies+1);
 ps1.setInt(2,book_no); 
 status=ps1.executeUpdate();
 
 PreparedStatement ps2=connection.prepareStatement("delete from issue where book_no=? and student_id=?");
 ps2.setInt(1,book_no);
 ps2.setString(2,student_id);
 status=ps2.executeUpdate();
 
 PreparedStatement ps3=connection.prepareStatement("update rack set no_of_books=? where rack_no=?");
 ps3.setInt(1,no_of_books-1);
 ps3.setInt(2,rack_no); 
 status=ps3.executeUpdate();
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
 } 
 });
}
}
