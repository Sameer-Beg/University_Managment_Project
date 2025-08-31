package UniverSityManagmentPckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textfieldName;
    JPasswordField passwordfield;
    JButton Login, back;

    Login() {
        JLabel LabelName = new JLabel("Username");
        LabelName.setBounds(40, 20, 100, 20);
        add(LabelName);

        textfieldName = new JTextField();
        textfieldName.setBounds(150, 20, 150, 20);
        add(textfieldName);

        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40, 70, 100, 20);
        add(labelpass);

        passwordfield = new JPasswordField();
        passwordfield.setBounds(150, 70, 150, 20);
        add(passwordfield);

        Login = new JButton("Login");
        Login.setBounds(40, 140, 120, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);

        back = new JButton("Back");
        back.setBounds(180, 140, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 600, 300);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            String username = textfieldName.getText();
            String password = new String(passwordfield.getPassword());

            String query = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'";

            try {
                Conection c = new Conection();
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()) {
                    // ✅ Login success → Open main window
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                    setVisible(false);
                    new main_class().setVisible(true);
                } else {
                    // ❌ Login failed
                    JOptionPane.showMessageDialog(this, "Invalid username or password");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
