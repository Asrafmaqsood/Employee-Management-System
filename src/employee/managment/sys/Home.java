package employee.managment.sys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {

    JLabel image, heading;
    Button addbtn, viewbtn, removebtn, updatebtn;
    Color color = new Color(153, 153, 255);

    public Home() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("employee/managment/sys/icons/home.jpg"));
        image = new JLabel(icon);
        image.setBounds(0, 0, 1120, 630);

        heading = new JLabel("Employee Management System");
        heading.setBounds(650, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        addbtn = new Button("Add Employee");
        addbtn.setBounds(650, 80, 180, 40);
        addbtn.setBackground(color);
        addbtn.setForeground(Color.BLACK);
        addbtn.setFont(new Font("serif",Font.BOLD,20));
        image.add(addbtn);
        addbtn.addActionListener(this);

        viewbtn = new Button("View Employees");
        viewbtn.setBounds(900, 80, 180, 40);
        viewbtn.setBackground(color);
        viewbtn.setForeground(Color.BLACK);
        viewbtn.setFont(new Font("serif",Font.BOLD,20));
        image.add(viewbtn);
        viewbtn.addActionListener(this);

        updatebtn = new Button("Update Employee");
        updatebtn.setBounds(650, 160, 180, 40);
        updatebtn.setBackground(color);
        updatebtn.setForeground(Color.BLACK);
        updatebtn.setFont(new Font("serif",Font.BOLD,20));
        image.add(updatebtn);
        updatebtn.addActionListener(this);

        removebtn = new Button("Remove Employee");
        removebtn.setBounds(900, 160, 180, 40);
        removebtn.setBackground(color);
        removebtn.setForeground(Color.BLACK);
        removebtn.setFont(new Font("serif",Font.BOLD,20));
        image.add(removebtn);
        removebtn.addActionListener(this);

        setBounds(250, 100, 1120, 630);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            setVisible(false);
            new AddEmployee();
        } else if (e.getSource() == viewbtn) {
            setVisible(false);
            new ViewEmployee();
        } else if (e.getSource() == updatebtn) {
            setVisible(false);
            new ViewEmployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}

