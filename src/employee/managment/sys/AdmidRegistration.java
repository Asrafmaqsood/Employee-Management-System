package employee.managment.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdmidRegistration extends JFrame implements ActionListener {

    JLabel heading, fullName, phoneNumb, emailId, userName, creatPassword;
    JTextField fullNameTF, phoneNumTF, emailIdTF, userNameTF, creatPasswordTF;
    Button submitbtn, backbtn;

    public AdmidRegistration(){

        heading = new JLabel("Admin Registration");
        heading.setBounds(120,10,250,30);
        heading.setFont(new Font("serif",Font.BOLD, 25));
        heading.setForeground(new Color(77,0,0));

        fullName = new JLabel("Full_Name");
        fullName.setBounds(50,80,150,25);
        fullName.setFont(new Font("serif",Font.BOLD, 20));

        fullNameTF = new JTextField();
        fullNameTF.setBounds(240,80,200,25);

        phoneNumb = new JLabel("Mobeil_Number");
        phoneNumb.setBounds(50,130,150,25);
        phoneNumb.setFont(new Font("serif",Font.BOLD, 20));

        phoneNumTF = new JTextField();
        phoneNumTF.setBounds(240,130,200,25);

        emailId = new JLabel("Email_ID");
        emailId.setBounds(50,180,150,25);
        emailId.setFont(new Font("serif",Font.BOLD, 20));

        emailIdTF = new JTextField();
        emailIdTF.setBounds(240,180,200,25);

        userName = new JLabel("Username");
        userName.setBounds(50,230,150,25);
        userName.setFont(new Font("serif",Font.BOLD, 20));

        userNameTF = new JTextField();
        userNameTF.setBounds(240,230,200,25);

        creatPassword = new JLabel("Create Password");
        creatPassword.setBounds(50,280,150,25);
        creatPassword.setFont(new Font("serif",Font.BOLD, 20));

        creatPasswordTF = new JTextField();
        creatPasswordTF.setBounds(240,280,200,25);

        submitbtn = new Button("Submite");
        submitbtn.setBounds(280,370,150,35);
        submitbtn.setBackground(new Color(77, 255, 77));
        submitbtn.setFont(new Font("serif",Font.BOLD,20));
        submitbtn.addActionListener(this);

        backbtn = new Button("Back");
        backbtn.setBounds(80,370,150,35);
        backbtn.setBackground(new Color(26, 255, 198));
        backbtn.setFont(new Font("serif",Font.BOLD,20));
        backbtn.addActionListener(this);

        setBounds(500, 100, 500, 500);
        Color color = new Color(153, 153, 255);
        getContentPane().setBackground(color);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(heading);
        add(fullName);
        add(fullNameTF);
        add(phoneNumb);
        add(phoneNumTF);
        add(emailId);
        add(emailIdTF);
        add(userName);
        add(userNameTF);
        add(creatPassword);
        add(creatPasswordTF);
        add(submitbtn);
        add(backbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submitbtn){
            String Fullname = fullNameTF.getText();
            String Phonumb = phoneNumTF.getText();
            String Email = emailIdTF.getText();
            String username = userNameTF.getText();
            String Password = creatPasswordTF.getText();

            try {
                EmployeeDAO empdao = new EmployeeDAO();
                String query = "insert into Admin_data values('"+Fullname+"', '"+Phonumb+"','"+Email+"', '"+username+"', '"+Password+"')";
                empdao.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Registrations successfully");
                setVisible(false);
                new App();
            }catch (Exception exp){
                exp.printStackTrace();
            }

        }else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String args[]){
        new AdmidRegistration();
    }
}
