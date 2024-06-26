import java.awt.EventQueue;
import javax.swing.*; 
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
public class viewBooks extends JFrame
{
static viewBooks frame;
 private static final long serialVersionUID = 1L;
 
 
public static void main(String userID) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame = new viewBooks(userID);
//frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public viewBooks(String userID)
{
try
 {
String data[][]=new String[10][5];
 String column[]={ "Book No", "Name", "Author","Rack No","No of copies" };
 
 Connection connection=DataBase.getConnection();
 
 String query = "select * from book";
 
 Statement stm = connection.createStatement();
 ResultSet res = stm.executeQuery(query);
 int i=0; 
 while (res.next()) 
 { 
 int book_no = res.getInt("book_no");
 String book_name = res.getString("book_name");
 String author = res.getString("author");
 int rack_no = res.getInt("rack_no");
 int no_of_copies = res.getInt("no_of_copies");
 data[i][0] = Integer.toString(book_no);
 data[i][1] = book_name;
 data[i][2] = author;
 data[i][3] = Integer.toString(rack_no);
 data[i][4] = Integer.toString(no_of_copies);
 i++;
 }
 DefaultTableModel model = new DefaultTableModel(data, column);
 JTable table = new JTable(model);
 table.setShowGrid(true);
 table.setShowVerticalLines(true);
 JScrollPane pane = new JScrollPane(table);
 JFrame f = new JFrame("Books");
 JPanel panel = new JPanel();
 panel.add(pane);
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(650, 380, 100, 50);
 btnBack.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 books.main(userID);
 frame.dispose();
 }
 });
 f.add(btnBack);
 f.add(panel);
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
