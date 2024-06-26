import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class admin extends JFrame {
static admin frame;
private JPanel contentPane;
private JButton btn1,btn2,btn3;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame= new admin();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public admin()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(450, 190, 800, 500);
 setResizable(false);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 //contentPane.setBackground(Color.CYAN);
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 JLabel lblNewLabel = new JLabel("ADMIN");
 lblNewLabel.setForeground(Color.BLACK);
 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
 lblNewLabel.setBounds(300, 13, 273, 93);
 contentPane.add(lblNewLabel);
 
 btn1 = new JButton("Issued Books");
 btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn1.setBounds(270, 100, 200, 70);
 
 btn2 = new JButton("Returned Books");
 btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn2.setBounds(270, 200, 200, 70);
 
 btn3 = new JButton("Students");
 btn3.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btn3.setBounds(270, 300, 200, 70);
 
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(620, 350, 100, 70);
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
LMS.main(new String[]{});
frame.dispose();
}
});
 
 btn1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try
 {
 String data[][]=new String[10][3];
 String column[]={ "Student ID","Book No","Issue Date" };
 
 Connection connection=DataBase.getConnection();
 
 String query = "select book_no,student_id,issue_date from issue";
 
 Statement stm = connection.createStatement();
 ResultSet res = stm.executeQuery(query);
 int i=0; 
 while (res.next()) 
 { 
 int book_no = res.getInt("book_no");
 String student_id = res.getString("student_id");
 String issue_date = res.getString("issue_date");
 
 data[i][0] = student_id;
 data[i][1] = Integer.toString(book_no);
 data[i][2] = issue_date;
 i++;
 }
 DefaultTableModel model = new DefaultTableModel(data, column);
 JTable table = new JTable(model);
 table.setShowGrid(true);
 table.setShowVerticalLines(true);
 JScrollPane pane = new JScrollPane(table);
 JFrame f = new JFrame("Issued Books");
 JPanel panel = new JPanel();
 panel.add(pane);
 JButton btnBack = new JButton("Back");
 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
 btnBack.setBounds(650, 380, 100, 50);
 btnBack.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 admin.main(new String[]{});
 }
 });
 f.add(btnBack);
 f.add(panel);
 f.setSize(800, 250);
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setBounds(450, 190, 800, 500);
 f.setVisible(true);
 
 
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
}
 });
btn2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try
{
String data[][]=new String[10][3];
 String column[]={ "Student ID","Book No","Return Date" };
 
 Connection connection=DataBase.getConnection();
 
 String query = "select book_no,student_id,return_date from return";
 
 Statement stm = connection.createStatement();
 ResultSet res = stm.executeQuery(query);
 int i=0; 
 while (res.next()) 
 { 
 int book_no = res.getInt("book_no");
 String student_id = res.getString("student_id");
 String return_date = res.getString("return_date");
 
 data[i][0] = student_id;
 data[i][1] = Integer.toString(book_no);
 data[i][2] = return_date;
 i++;
 }
 DefaultTableModel model = new DefaultTableModel(data, column);
 JTable table = new JTable(model);
 table.setShowGrid(true);
 table.setShowVerticalLines(true);
 JScrollPane pane = new JScrollPane(table);
 JFrame f = new JFrame("Returned Books");
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
});
btn3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try
{
String data[][]=new String[10][2];
 String column[]={ "Student ID","Student Name"};
 
 Connection connection=DataBase.getConnection();
 
 String query = "select student_id,student_name from student";
 
 Statement stm = connection.createStatement();
 ResultSet res = stm.executeQuery(query);
 int i=0; 
 while (res.next()) 
 { 
 
 String student_id = res.getString("student_id");
 String student_name = res.getString("student_name");
 
 data[i][0] = student_id;
 data[i][1] = student_name;
 i++;
 }
 DefaultTableModel model = new DefaultTableModel(data, column);
 JTable table = new JTable(model);
 table.setShowGrid(true);
 table.setShowVerticalLines(true);
 JScrollPane pane = new JScrollPane(table);
 JFrame f = new JFrame("Students");
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
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setBounds(450, 190, 800, 500);
 f.setVisible(true);
 
 
 }
 catch (Exception ex) 
 {
 System.out.println(ex);
 }
}
});
 contentPane.add(btn1);
 contentPane.add(btn2);
 contentPane.add(btn3);
 contentPane.add(btnBack);
}
}
