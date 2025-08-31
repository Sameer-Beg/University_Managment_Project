package UniverSityManagmentPckg;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    //globaly textfield
    JTextField textname , textfather , textAddress , textPhone ,textEmail, textm10, textm12 , textadhar;
    JLabel emptext;
    //dob
    JDateChooser cdob;
    //courses select
    JComboBox coursebox , departmentbox;
    //button
    JButton submit , cancel;


    //Randomply empid
    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L)+1000L);

    AddStudent(){
        //bg color
        getContentPane().setBackground(new Color(128,176,255));
        // Heading
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

// Row 1 - Name & Father's Name
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 120, 30);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        add(name);

        textname = new JTextField();
        textname.setBounds(200, 150, 200, 30);
        add(textname);

        JLabel Fname = new JLabel("Father's Name:");
        Fname.setBounds(450, 150, 150, 30);
        Fname.setFont(new Font("Serif", Font.BOLD, 20));
        add(Fname);

        textfather = new JTextField();
        textfather.setBounds(620, 150, 200, 30);
        add(textfather);

// Row 2 - Employee ID & DOB
        JLabel EmpID = new JLabel("Roll Number:");
        EmpID.setBounds(50, 200, 150, 30);
        EmpID.setFont(new Font("Serif", Font.BOLD, 20));
        add(EmpID);

        emptext = new JLabel("0001" + f4);
        emptext.setBounds(200, 200, 200, 30);
        emptext.setFont(new Font("Serif", Font.BOLD, 20));
        add(emptext);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setBounds(450, 200, 150, 30);
        DOB.setFont(new Font("Serif", Font.BOLD, 20));
        add(DOB);

        cdob = new JDateChooser();
        cdob.setBounds(620, 200, 200, 30);
        add(cdob);

// Row 3 - Address & Phone
        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 120, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 200, 30);
        add(textAddress);

        JLabel phone = new JLabel("Phone number:");
        phone.setBounds(450, 250, 150, 30);
        phone.setFont(new Font("Serif", Font.BOLD, 20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(620, 250, 200, 30);
        add(textPhone);

// Row 4 - Email & Class X
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 300, 120, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 300, 200, 30);
        add(textEmail);

        JLabel m10 = new JLabel("Class X (%):");
        m10.setBounds(450, 300, 150, 30);
        m10.setFont(new Font("Serif", Font.BOLD, 20));
        add(m10);

        textm10 = new JTextField();
        textm10.setBounds(620, 300, 200, 30);
        add(textm10);

// Row 5 - Class XII & Aadhaar
        JLabel m12 = new JLabel("Class XII (%):");
        m12.setBounds(50, 350, 150, 30);
        m12.setFont(new Font("Serif", Font.BOLD, 20));
        add(m12);

        textm12 = new JTextField();
        textm12.setBounds(200, 350, 200, 30);
        add(textm12);

        JLabel adharno = new JLabel("Aadhaar number:");
        adharno.setBounds(450, 350, 170, 30);
        adharno.setFont(new Font("Serif", Font.BOLD, 20));
        add(adharno);

        textadhar = new JTextField();
        textadhar.setBounds(620, 350, 200, 30);
        add(textadhar);

// Row 6 - Qualification & Department
        JLabel qualificatio = new JLabel("Course:");
        qualificatio.setBounds(50, 400, 150, 30);
        qualificatio.setFont(new Font("Serif", Font.BOLD, 20));
        add(qualificatio);

        String course[] = {"B.Tech" , "BBA" , "MCA" , "MBA" , "MSC" , "MCom" , "MA" , "BA"};
        coursebox  = new JComboBox(course);
        coursebox.setBounds(200, 400, 200, 30);
        coursebox.setBackground(Color.WHITE);
        add(coursebox);

        JLabel department = new JLabel("Branch:");
        department.setBounds(450, 400, 150, 30);
        department.setFont(new Font("Serif", Font.BOLD, 20));
        add(department);

        String Department[] = {"Computer Science" , "Civil" , "Mechanical" , "IT" , "Electronics"};
        departmentbox  = new JComboBox(Department);
        departmentbox.setBounds(620, 400, 200, 30);
        departmentbox.setBackground(Color.WHITE);
        add(departmentbox);

// Buttons
        submit = new JButton("Submit");
        submit.setBounds(250, 500, 120, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(350 , 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            //data ko nikal liya h yha
            String name = textname.getText();
            String Fname = textfather.getText();
            String empid = emptext.getText();
            String dbo = ((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String addres = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String m10 = textm10.getText();
            String m12 = textm12.getText();
            String addhar = textadhar.getText();
            String course = (String) coursebox.getSelectedItem();
            String deparment = (String) departmentbox.getSelectedItem();
            try {
                String query = "insert into students values('"+name+"' , '"+Fname+"' , '"+empid+"', '"+dbo+"' , '"+addres+"', '"+phone+"', '"+email+"', '"+m10+"', '"+m12+"' , '"+addhar+"' , '"+course+"' , '"+deparment+"')";
                Conection c = new Conection(); //Conection file class
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Details Inserted");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
