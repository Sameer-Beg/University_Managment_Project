package UniverSityManagmentPckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice CrollNumber;
    JComboBox coursebox, departmentbox , semesterBox;
    JLabel textName, textFatherName;
    JLabel totalAmount;
    JButton pay, update, back;

    StudentFeeForm() {
        getContentPane().setBackground(new Color(210, 252, 251));

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 50, 500, 300);
        add(img);

        // Roll number
        JLabel rollnumber = new JLabel("Select Roll Number");
        rollnumber.setBounds(40, 60, 150, 20);
        rollnumber.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(rollnumber);

        CrollNumber = new Choice();
        CrollNumber.setBounds(200, 60, 150, 20);
        add(CrollNumber);

        try {
            Conection c = new Conection();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            while (resultSet.next()) {
                CrollNumber.add(resultSet.getString("Rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        add(name);

        textName = new JLabel();
        textName.setBounds(200, 100, 200, 20);
        textName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textName);

        // Father name
        JLabel Fathername = new JLabel("Father Name");
        Fathername.setBounds(40, 140, 150, 20);
        add(Fathername);

        textFatherName = new JLabel();
        textFatherName.setBounds(200, 140, 200, 20);
        textFatherName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textFatherName);

        // Load first roll number details by default
        loadStudentDetails(CrollNumber.getSelectedItem());

        // Update details when roll number changes
        CrollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadStudentDetails(CrollNumber.getSelectedItem());
            }
        });

        JLabel qualificatio = new JLabel("Course:");
        qualificatio.setBounds(40, 180, 150, 30);
        qualificatio.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(qualificatio);

        String course[] = {"BTech" , "BBA" , "MCA" , "MBA" , "MSC" , "MCom" , "MA" , "BA"};
        coursebox  = new JComboBox(course);
        coursebox.setBounds(200, 180, 150, 20);
        coursebox.setBackground(Color.WHITE);
        add(coursebox);

        JLabel department = new JLabel("Branch:");
        department.setBounds(40, 220, 150, 20);
        department.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(department);

        String Department[] = {"Computer Science" , "Civil" , "Mechanical" , "IT" , "Electronics"};
        departmentbox  = new JComboBox(Department);
        departmentbox.setBounds(200, 220, 150, 20);
        departmentbox.setBackground(Color.WHITE);
        add(departmentbox);

        JLabel textsemester = new JLabel("Semester");
        textsemester.setBounds(40,260,150,20);
        add(textsemester);

        String semester[] = {"semester1", "semester2", "semester3","semester4","semester5", "semester6", "semester7","semester8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200,260,150,20);
        add(semesterBox);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        add(total);

        totalAmount = new JLabel("");
        totalAmount.setBounds(200,300,150,20);
        add(totalAmount);

        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);



        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    // Method to load student details
    private void loadStudentDetails(String rollno) {
        try {
            Conection c = new Conection();
            String Q = "select * from students where Rollno = '" + rollno + "'";
            ResultSet resultSet = c.statement.executeQuery(Q);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFatherName.setText(resultSet.getString("Fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // For future buttons (Submit / Cancel etc.)
        if (e.getSource()==update){
            String course = (String) coursebox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            try {
                Conection c = new Conection();
                ResultSet resultSet = c.statement.executeQuery("select * from fee where course = '"+course+"'");
                while (resultSet.next()){
                    totalAmount.setText(resultSet.getString(semester));

                }
            }catch (Exception E){
                E.printStackTrace();

            }
        } else if (e.getSource() ==  pay) {
            String rollno = CrollNumber.getSelectedItem();
            String course = (String) coursebox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            String branch = (String) departmentbox.getSelectedItem();
            String total = totalAmount.getText();
            try {
                Conection c = new Conection();
                String Q = "insert into feecollege values('"+rollno+"', '"+course+"' , '" +branch+"' , '"+semester+"' , '"+total+"')";
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Fee Submited");
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
