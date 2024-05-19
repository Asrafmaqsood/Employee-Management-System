package employee.managment.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{

    JLabel empIDJL;
    Choice chooseEmpId;
    Button delete,back;

    public RemoveEmployee(){

        empIDJL = new JLabel("Choose employeeId");
        empIDJL.setBounds(50,50,250,30);
        empIDJL.setFont(new Font("serif",Font.BOLD, 25));

        chooseEmpId = new Choice();
        chooseEmpId.setBounds(300,50,150,30);

        try{
            EmployeeDAO empDAO = new EmployeeDAO();
            String query = "select * from employee";
            ResultSet set = empDAO.stmt.executeQuery(query);
            while (set.next()){
                chooseEmpId.add(set.getString("empId"));
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        JLabel nameJL = new JLabel("Name");
        nameJL.setBounds(50,100,100,30);
        nameJL.setFont(new Font("serif",Font.BOLD, 25));

        JLabel lblname = new JLabel();
        lblname.setBounds(250,100,200,30);
        lblname.setFont(new Font("serif",Font.BOLD, 20));

        JLabel phoneJL = new JLabel("Phone_Number");
        phoneJL.setBounds(50,150,180,30);
        phoneJL.setFont(new Font("serif",Font.BOLD, 25));

        JLabel lblphone = new JLabel();
        lblphone.setBounds(250,150,180,30);
        lblname.setFont(new Font("serif",Font.BOLD, 25));

        JLabel emailJL = new JLabel("Email_ID");
        emailJL.setBounds(50,200,150,30);
        emailJL.setFont(new Font("serif",Font.BOLD, 25));

        JLabel lblemail = new JLabel();
        lblemail.setBounds(250,200,250,30);
        lblemail.setFont(new Font("serif",Font.BOLD, 20));

        delete = new Button("Delete");
        delete.setBounds(500,300,150,35);
        delete.setBackground(new Color(255, 92, 51));
        delete.setFont(new Font("serif",Font.BOLD,20));
        delete.addActionListener(this);

        back = new Button("Back");
        back.setBounds(300,300,150,35);
        back.setBackground(new Color(77, 255, 77));
        back.setFont(new Font("serif",Font.BOLD,20));
        back.addActionListener(this);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("employee/managment/sys/icons/delete.png"));
       JLabel image = new JLabel(icon);
       image.setBounds(550,35,380,250);

        try{
            EmployeeDAO empDAO = new EmployeeDAO();
            String query = "select * from employee where empId = '"+chooseEmpId.getSelectedItem()+"'";
            ResultSet set = empDAO.stmt.executeQuery(query);
            while (set.next()){
                lblname.setText(set.getString("name"));
                lblphone.setText(set.getString("Phone_numb"));
                lblemail.setText(set.getString("email"));
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }

        chooseEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    EmployeeDAO empDAO = new EmployeeDAO();
                    String query = "select * from employee where empId = '"+chooseEmpId.getSelectedItem()+"'";
                    ResultSet set = empDAO.stmt.executeQuery(query);
                    while (set.next()){
                        lblname.setText(set.getString("name"));
                        lblphone.setText(set.getString("Phone_numb"));
                        lblemail.setText(set.getString("email"));
                    }
                }catch (Exception exp){
                    exp.printStackTrace();
                }
            }
        });

        setBounds(300,150,1000,400);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(102, 153, 153));
        add(empIDJL);
        add(chooseEmpId);
        add(nameJL);
        add(lblname);
        add(phoneJL);
        add(lblphone);
        add(emailJL);
        add(lblemail);
        add(back);
        add(delete);
        add(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try{
                EmployeeDAO empDAO = new EmployeeDAO();
                String query = "delete from employee where empId = '"+chooseEmpId.getSelectedItem()+"'";
                empDAO.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            }catch (Exception exp){
                exp.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args){
        new RemoveEmployee();
    }
}
