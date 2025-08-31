package UniverSityManagmentPckg;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice rollnumber;
    JDateChooser selDate;
    JButton submit, cancel;

    Choice chotime;

    StudentLeave(){
        //bg
        getContentPane().setBackground(new Color(210,232,252));

        JLabel headeing = new JLabel("Apply Leave Student");
        headeing.setBounds(40,50,300,30);
        headeing.setFont(new Font("Tahoma" , Font.BOLD,20));
        add(headeing);

        JLabel rollnosearch = new JLabel("Roll Number Search");
        rollnosearch.setBounds(60,100,200,20);
        rollnosearch.setFont(new Font("Tahoma" , Font.PLAIN,18));
        add(rollnosearch);

        rollnumber = new Choice();
        rollnumber.setBounds(60,130,200,20);
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

        //calender
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lbldate);
        selDate = new JDateChooser();
        selDate.setBounds(60,210,200,25);
        add(selDate);

        //time duration
        JLabel time = new JLabel("Time");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(time);
        chotime = new Choice();
        chotime.setBounds(60,290,200,20);
        chotime.add("Full Day");
        chotime.add("Half Day");
        add(chotime);

        //buttons
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);



        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String RollNumber = rollnumber.getSelectedItem();
            String date = ((JTextField)selDate.getDateEditor().getUiComponent()).getText();
            String durationtime =chotime.getSelectedItem();

            String Q = "insert into studentleave values('"+RollNumber+"', '"+date+"' ,  '"+durationtime+"') ";

            try{
                Conection c = new Conection();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
