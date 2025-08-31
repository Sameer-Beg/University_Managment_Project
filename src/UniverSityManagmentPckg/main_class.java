package UniverSityManagmentPckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        // Menu Bar
        JMenuBar mb = new JMenuBar();

        // New Information
        JMenu newinfo = new JMenu("New Information");
        newinfo.setForeground(Color.BLACK);
        mb.add(newinfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setForeground(Color.BLUE);
        facultyInfo.addActionListener(this);
        newinfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setForeground(Color.BLUE);
        studentInfo.addActionListener(this);
        newinfo.add(studentInfo);

        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setForeground(Color.BLUE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setForeground(Color.BLUE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        // Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setForeground(Color.BLUE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setForeground(Color.BLUE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        // Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        mb.add(leaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setForeground(Color.BLUE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setForeground(Color.BLUE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        // Examination
        JMenu examMenu = new JMenu("Examination");
        examMenu.setForeground(Color.BLACK);
        mb.add(examMenu);

        JMenuItem examResults = new JMenuItem("Examination Results");
        examResults.setForeground(Color.BLUE);
        examResults.addActionListener(this);
        examMenu.add(examResults);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setForeground(Color.BLUE);
        enterMarks.addActionListener(this);
        examMenu.add(enterMarks);

        // Update Info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.setForeground(Color.BLUE);
        updateFaculty.addActionListener(this);
        updateInfo.add(updateFaculty);

        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.setForeground(Color.BLUE);
        updateStudent.addActionListener(this);
        updateInfo.add(updateStudent);

        // Fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setForeground(Color.BLUE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem studentFeeForm = new JMenuItem("Student Fee Form");
        studentFeeForm.setForeground(Color.BLUE);
        studentFeeForm.addActionListener(this);
        fee.add(studentFeeForm);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setForeground(Color.BLUE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setForeground(Color.BLUE);
        notepad.addActionListener(this);
        utility.add(notepad);

        // About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setForeground(Color.BLUE);
        aboutItem.addActionListener(this);
        about.add(aboutItem);

        // Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setForeground(Color.BLUE);
        exitItem.addActionListener(this);
        exit.add(exitItem);

        setJMenuBar(mb);

        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Exit")) {
            System.exit(0);
        } else if (s.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (s.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (s.equals("New Faculty Information")) {
            new Addfaculty();
        } else if (s.equals("New Student Information")) {
            new AddStudent();
        } else if (s.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (s.equals("View Student Details")) {
            new Studentdetials();
        } else if (s.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (s.equals("Student Leave")) {
            new StudentLeave();
        } else if (s.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (s.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (s.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (s.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (s.equals("Enter Marks")) {
            new EnterMarks();
        } else if (s.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (s.equals("Fee Structure")) {
            new FeeStructure();
        } else if (s.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (s.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
