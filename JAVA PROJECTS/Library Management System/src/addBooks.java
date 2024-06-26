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
public class addBooks extends JFrame
{
 private static final long serialVersionUID = 1L;
 private JButton btnNewButton;
 private JTextField textField,textField_2;
 private JPanel contentPane;
 static addBooks frame;
 
public static void main(String userID) 
{
EventQueue.invokeLater(new Runnable() 
{
public void run() 
{
try 
{
frame = new addBooks(userID);
frame.setVisible(true);
} catch (Exception e) 
{
e.printStackTrace();
}
}
});
}
public addBooks(String userID)
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
 
 JLabel lblPassword = new JLabel("Issue Date");
 lblPassword.setForeground(Color.BLACK);
 lblPassword.setBackground(Color.CYAN);
 lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
 lblPassword.setBounds(160, 199, 193, 52);
 contentPane.add(lblPassword);
 
 btnNewButton = new JButton("Add");
 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnNewButton.setBounds(300, 350, 200, 70);
 contentPane.add(btnNewButton);
 
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
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 int book_no=Integer.parseInt(textField.getText());
 String student_id=userID;
 String issue_date=textField_2.getText();
 try 
 {
 int i=addBooks.save(book_no, student_id, issue_date);
 if(i>0){
 JOptionPane.showMessageDialog(addBooks.this,"Book added successfully!");
 frame.dispose();
 
 }else{
 JOptionPane.showMessageDialog(addBooks.this,"Book NOT AVAILABLE");
 }
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
 } 
 });
}
public static int save(int book_no,String student_id,String issue_date){
int status=0;
try{
Connection connection=DataBase.getConnection();
status=updatebook(book_no);
if(status>0){
PreparedStatement ps=connection.prepareStatement("insert into issue(book_no,student_id,issue_date) values(?,?,?)");
ps.setInt(1,book_no);
ps.setString(2,student_id);
ps.setString(3,issue_date);
status=ps.executeUpdate();
}
connection.close();
}catch(Exception e){System.out.println(e);}
return status;
}
public static int updatebook(int book_no){
int status=0;
int no_of_copies=0;
int no_of_books=0;
int rack_no=0;
try{
Connection connection=DataBase.getConnection();
PreparedStatement ps=connection.prepareStatement("select no_of_copies from book where book_no=?");
ps.setInt(1,book_no);
ResultSet rs=ps.executeQuery();
if(rs.next()){
no_of_copies=rs.getInt("no_of_copies");
}
if(no_of_copies>0){
PreparedStatement ps2=connection.prepareStatement("update book set no_of_copies=? where book_no=?");
PreparedStatement ps3=connection.prepareStatement("update rack set no_of_books=? where rack_no=?");
PreparedStatement ps1=connection.prepareStatement("select rack_no from book where book_no=?");
ps1.setInt(1, book_no);
ResultSet rs1=ps1.executeQuery();
if(rs1.next()){
rack_no=rs1.getInt("rack_no");
}
ps1.executeUpdate();
ps2.setInt(1,no_of_copies-1);
ps2.setInt(2,book_no);
ps3.setInt(1, no_of_books-1);
ps3.setInt(2, rack_no);
ps3.executeUpdate();
status=ps2.executeUpdate();
}
connection.close();
}catch(Exception e){System.out.println(e);}
return status;
}
}