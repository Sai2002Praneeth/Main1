import java.awt.EventQueue;
import javax.swing.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
public class myBooks extends JFrame
{
static myBooks frame;
 private static final long serialVersionUID = 1L;
 
public static void main(String userID) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame = new myBooks(userID);
//frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public myBooks(String userID)
{
 try
 {
 String data[][]=new String[10][2];
 String column[]={ "Student ID","Book No", };
 
 Connection connection=DataBase.getConnection();
 
 PreparedStatement stmt = connection.prepareStatement("select book_no,student_id from issue where student_id=?");
 stmt.setString(1,userID);
 
 //Statement stm = connection.createStatement();
 ResultSet res = stmt.executeQuery();
 int i=0; 
 while (res.next()) 
 { 
 int book_no = res.getInt("book_no");
 String student_id = res.getString("student_id");
 
 data[i][0] = student_id;
 data[i][1] = Integer.toString(book_no);
 i++;
 }
 DefaultTableModel model = new DefaultTableModel(data, column);
 JTable table = new JTable(model);
 table.setShowGrid(true);
 table.setShowVerticalLines(true);
 JScrollPane pane = new JScrollPane(table);
 JFrame f = new JFrame(" My Books");
 JPanel panel = new JPanel();
 panel.add(pane);
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(650, 380, 100, 50);
 btnBack.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 admin.main(new String[]{});
 frame.dispose();
 }
 });
 f.add(btnBack);
 f.add(panel);
 //f.setSize(500, 250);
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setBounds(450, 190, 800, 500);
 f.setVisible(true);
 
 
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
}
}