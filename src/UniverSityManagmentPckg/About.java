package UniverSityManagmentPckg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About() {
        // University Logo / About Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(220, 20, 250, 150);   // Centered at the top
        add(img);

        // Heading
        JLabel heading = new JLabel("<html><center>INVERTIS UNIVERSITY<br/>BAREILLY</center></html>", SwingConstants.CENTER);
        heading.setBounds(150, 180, 400, 60);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setForeground(new Color(60, 40, 90));
        add(heading);

        // Name
        JLabel name = new JLabel("Developed By: Sameer Beg", SwingConstants.CENTER);
        name.setBounds(100, 260, 500, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 24));
        name.setForeground(Color.DARK_GRAY);
        add(name);

        // Contact
        JLabel contact = new JLabel("Email: sameer423j@gmail.com", SwingConstants.CENTER);
        contact.setBounds(100, 320, 500, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contact.setForeground(new Color(80, 80, 80));
        add(contact);

        // Frame Settings
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(252, 228, 210));
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No button actions yet
    }

    public static void main(String[] args) {
        new About();
    }
}
