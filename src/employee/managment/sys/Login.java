package employee.managment.sys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JLabel image, userNameLabel, passwordLabel;
    JTextField usJTextField, pasJTextField;
    Button loginButton, singUpbtn;

    Login() {

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("employee/managment/sys/icons/second.jpg"));
        image = new JLabel(icon);
        image.setBounds(230, 2, 150, 150);

        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(50, 160, 100, 30);
        Font font = new Font("SansSerif", Font.BOLD, 15);
        userNameLabel.setFont(font);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 220, 100, 30);
        passwordLabel.setFont(font);

        usJTextField = new JTextField("Enter Username");
        usJTextField.setBounds(180, 160, 250, 30);
        pasJTextField = new JTextField("Enter Password");
        pasJTextField.setBounds(180, 220, 250, 30);

        loginButton = new Button("Login");
        loginButton.setBounds(150, 300, 120, 30);
        loginButton.setBackground(new Color(148,184,148));
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(font);
        loginButton.addActionListener(this);

        singUpbtn = new Button("Sign Up");
        singUpbtn.setBounds(350, 300, 120, 30);
        singUpbtn.setBackground(new Color(148,148,184));
        singUpbtn.setForeground(Color.BLACK);
        singUpbtn.setFont(font);
        singUpbtn.addActionListener(this);

        setBounds(450, 200, 600, 400);
        Color color = new Color(153, 153, 255);
        getContentPane().setBackground(color);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(userNameLabel);
        add(passwordLabel);
        add(usJTextField);
        add(pasJTextField);
        add(loginButton);
        add(singUpbtn);
        add(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginButton) {
            String username = usJTextField.getText();
            String password = pasJTextField.getText();

            String query = "select * from Admin_Data where Username = '" + username + "'and Password = '" + password + "'";

            EmployeeDAO edao = new EmployeeDAO();
            try {
                ResultSet set = edao.stmt.executeQuery(query);
                if (set.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "invalid username or password");
//                setVisible(false);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
            new AdmidRegistration();
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
