package UniverSityManagmentPckg;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Studentdetials extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;


    Studentdetials(){
        //bg color
        getContentPane().setBackground(new Color(210,252,218));

        //heading
        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        //search student from the DB using roll no.
        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);
        try {
            Conection c = new Conection();   // ✅ Correct spelling: Connection
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM students");  // ✅ Correct: ResultSet (capital S, camelCase variable)
            while (resultSet.next()){
                choice.add(resultSet.getString("Rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conection c = new Conection();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 100,900,600);
        add(js);

        //buttons
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);





        //layout
        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search){
            String q  = "select * from students where Rollno = '"+choice.getSelectedItem()+"'";
            try {
                Conection c = new Conection();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();

            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (e.getSource() == update) {
            //empty
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Studentdetials();
    }
}
