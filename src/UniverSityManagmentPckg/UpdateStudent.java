package UniverSityManagmentPckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    // Global text fields
    JTextField textAddress, textPhone, textEmail, textadhar, textcourse, textbranch;
    JLabel emptext;
    // Buttons
    JButton submit, cancel;
    Choice choiseEMPID;
    UpdateStudent(){
        // Background color changed
        getContentPane().setBackground(new Color(200, 240, 250));

        // Heading
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(250, 20, 500, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 32));
        heading.setForeground(new Color(50, 50, 120));
        add(heading);

        JLabel empID = new JLabel("Select Roll NUmber ");
        empID.setBounds(100, 100, 200, 25);
        empID.setFont(new Font("serif", Font.PLAIN, 18));
        add(empID);

        choiseEMPID = new Choice();
        choiseEMPID.setBounds(300, 100, 200, 25);
        add(choiseEMPID);

        try {
            Conection c = new Conection();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            while (resultSet.next()) {
                choiseEMPID.add(resultSet.getString("Rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Row 1
        JLabel name = new JLabel("Name:");
        name.setBounds(100, 160, 120, 30);
        name.setFont(new Font("Serif", Font.BOLD, 18));
        add(name);

        JLabel textname = new JLabel();
        textname.setBounds(250, 160, 200, 30);
        add(textname);

        JLabel Fname = new JLabel("Father's Name:");
        Fname.setBounds(500, 160, 150, 30);
        Fname.setFont(new Font("Serif", Font.BOLD, 18));
        add(Fname);

        JLabel textfather = new JLabel();
        textfather.setBounds(670, 160, 200, 30);
        add(textfather);

        // Row 2
        JLabel EmpID = new JLabel("Roll Number:");
        EmpID.setBounds(100, 210, 150, 30);
        EmpID.setFont(new Font("Serif", Font.BOLD, 18));
        add(EmpID);

        emptext = new JLabel();
        emptext.setBounds(250, 210, 200, 30);
        emptext.setFont(new Font("Serif", Font.BOLD, 18));
        add(emptext);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setBounds(500, 210, 150, 30);
        DOB.setFont(new Font("Serif", Font.BOLD, 18));
        add(DOB);

        JLabel dob = new JLabel();
        dob.setBounds(670, 210, 150, 30);
        add(dob);

        // Row 3
        JLabel address = new JLabel("Address:");
        address.setBounds(100, 260, 120, 30);
        address.setFont(new Font("Serif", Font.BOLD, 18));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(250, 260, 200, 30);
        add(textAddress);

        JLabel phone = new JLabel("Phone number:");
        phone.setBounds(500, 260, 150, 30);
        phone.setFont(new Font("Serif", Font.BOLD, 18));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(670, 260, 200, 30);
        add(textPhone);

        // Row 4
        JLabel email = new JLabel("Email:");
        email.setBounds(100, 310, 120, 30);
        email.setFont(new Font("Serif", Font.BOLD, 18));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(250, 310, 200, 30);
        add(textEmail);

        JLabel m10 = new JLabel("Class X (%):");
        m10.setBounds(500, 310, 150, 30);
        m10.setFont(new Font("Serif", Font.BOLD, 18));
        add(m10);

        JLabel textm10 = new JLabel();
        textm10.setBounds(670, 310, 200, 30);
        add(textm10);

        // Row 5
        JLabel m12 = new JLabel("Class XII (%):");
        m12.setBounds(100, 360, 150, 30);
        m12.setFont(new Font("Serif", Font.BOLD, 18));
        add(m12);

        JLabel textm12 = new JLabel();
        textm12.setBounds(250, 360, 200, 30);
        add(textm12);

        JLabel adharno = new JLabel("Aadhaar number:");
        adharno.setBounds(500, 360, 170, 30);
        adharno.setFont(new Font("Serif", Font.BOLD, 18));
        add(adharno);

        textadhar = new JTextField();
        textadhar.setBounds(670, 360, 200, 30);
        add(textadhar);

        // Row 6
        JLabel qualificatio = new JLabel("Course:");
        qualificatio.setBounds(100, 410, 150, 30);
        qualificatio.setFont(new Font("Serif", Font.BOLD, 18));
        add(qualificatio);

        textcourse = new JTextField();
        textcourse.setBounds(250, 410, 200, 30);
        add(textcourse);

        JLabel department = new JLabel("Branch:");
        department.setBounds(500, 410, 150, 30);
        department.setFont(new Font("Serif", Font.BOLD, 18));
        add(department);

        textbranch = new JTextField();
        textbranch.setBounds(670, 410, 200, 30);
        add(textbranch);

        try {
            Conection c = new Conection();
            String query = "select * from students where Rollno = '"+choiseEMPID.getSelectedItem()+"'";
            ResultSet resultSet =  c.statement.executeQuery(query);
            while (resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textfather.setText(resultSet.getString("Fname"));
                dob.setText(resultSet.getString("DOB"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textm10.setText(resultSet.getString("class_10"));
                textm12.setText(resultSet.getString("class_XII"));
                textadhar.setText(resultSet.getString("adharno"));
                emptext.setText(resultSet.getString("Rollno"));
                textcourse.setText(resultSet.getString("Course"));
                textbranch.setText(resultSet.getString("Branch"));

            }
        }catch (Exception E){
            E.printStackTrace();

        }
        choiseEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conection c = new Conection();
                    String query = "select * from students where Rollno = '"+choiseEMPID.getSelectedItem()+"'";
                    ResultSet resultSet =  c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textname.setText(resultSet.getString("name"));
                        textfather.setText(resultSet.getString("Fname"));
                        dob.setText(resultSet.getString("DOB"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        textm10.setText(resultSet.getString("class_10"));
                        textm12.setText(resultSet.getString("class_XII"));
                        textadhar.setText(resultSet.getString("adharno"));
                        emptext.setText(resultSet.getString("Rollno"));
                        textcourse.setText(resultSet.getString("Branch"));
                        textbranch.setText(resultSet.getString("Branch"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        // Buttons
        submit = new JButton("Update");
        submit.setBounds(300, 500, 120, 40);
        submit.setBackground(new Color(70, 130, 180));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(500, 500, 120, 40);
        cancel.setBackground(new Color(200, 50, 50));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1000, 650);
        setLocation(300, 80);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String empid = emptext.getText();
            String address = textAddress.getText();
            String phoneno = textPhone.getText();
            String email = textEmail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try{
                String q =  "update students set address = '"+address+"', phone = '"+phoneno+"' , email = '"+email+"', Branch = '"+course+"' , Branch = '"+branch+"' where Rollno = '"+empid+"'";
                Conection c = new Conection();
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"details Updated");
                setVisible(false);


            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
