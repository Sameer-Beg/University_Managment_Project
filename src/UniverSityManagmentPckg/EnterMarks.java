package UniverSityManagmentPckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice rollnumber;
    JComboBox conbobox;
    JTextField sub1 , sub2 , sub3 , sub4, sub5 , mrk1 , mrk2 , mrk3 , mrk4 , mrk5;
    JButton submit ,  cancel;

    EnterMarks(){
        //bg
        getContentPane().setBackground(new Color(252,242,210));
        //frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,40,400,300);
        add(img);



        JLabel heading = new JLabel("Enter marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel rollno = new JLabel("Select Roll Number ");
        rollno.setBounds(50,70,150,20);
        add(rollno);

        rollnumber = new Choice();
        rollnumber.setBounds(200,70,150,20);
        add(rollnumber);
        try{
            Conection c = new Conection();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            while (resultSet.next()){
                rollnumber.add(resultSet.getString("Rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel  sam = new JLabel("Select Semester");
        sam.setBounds(50,110,150,20);
        add(sam);

        String semester[] = {"1st Semester","2st Semester","3st Semester","4st Semester","5st Semester","6st Semester","7st Semester","8st Semester"};
        conbobox = new JComboBox(semester);
        conbobox.setBounds(200,110,150,20);
        conbobox.setBackground(Color.WHITE);
        add(conbobox);

        JLabel enterSub = new JLabel("Enter Subject");
        enterSub.setBounds(100,150,200,40);
        add(enterSub);
        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(320,150,200,40);
        add(entermarks);

        //textfields subjects
        sub1 = new JTextField();
        sub1.setBounds(50,200,200,20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(50,230,200,20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(50,260,200,20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(50,290,200,20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(50,320,200,20);
        add(sub5);

        //textfields marks
        mrk1 = new JTextField();
        mrk1.setBounds(250,200,200,20);
        add(mrk1);

        mrk2 = new JTextField();
        mrk2.setBounds(250,230,200,20);
        add(mrk2);

        mrk3 = new JTextField();
        mrk3.setBounds(250,260,200,20);
        add(mrk3);

        mrk4 = new JTextField();
        mrk4.setBounds(250,290,200,20);
        add(mrk4);

        mrk5 = new JTextField();
        mrk5.setBounds(250,320,200,20);
        add(mrk5);

        //buttons
        submit =  new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        cancel =  new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(1000,500);
        setLayout(null);
        setLocation(300,150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            try{
                Conection c = new Conection();
                String Q1 = "insert into subject values('"+rollnumber.getSelectedItem()+"' , '"+conbobox.getSelectedItem()+"' ,  '"+sub1.getText()+"' , '"+sub2.getText()+"' , '"+sub3.getText()+"' , '"+sub4.getText()+"' , '"+sub5.getText()+"') ";
                String Q2 = "insert into marks values('"+rollnumber.getSelectedItem()+"' , '"+conbobox.getSelectedItem()+"' ,  '"+mrk1.getText()+"' , '"+mrk2.getText()+"' , '"+mrk3.getText()+"' , '"+mrk4.getText()+"' , '"+mrk5.getText()+"') ";

                c.statement.executeUpdate(Q1);
                c.statement.executeUpdate(Q2);
                JOptionPane.showMessageDialog(null,"Marks Inserted Sucessfully");
                setVisible(false);


            }catch (Exception E){
                E.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
