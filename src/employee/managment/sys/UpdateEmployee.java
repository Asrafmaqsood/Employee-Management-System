package employee.managment.sys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class UpdateEmployee extends JFrame implements ActionListener{

    JLabel heading, namLabel, fname, dobLabel, salaryLable, addressJL, phonumbJL, emailJL, educationJL, designationJL, adharnumJL, employeeidJL, employeeid;
    JTextField namTextField, fnamTextField, salaryTF, addressTF, phonumTF, emailTF, educationTF, designationTF, adharnumTF;
    JDateChooser dobChooser;
    Button addDetailsbtn, backbtn;
    Font font = new Font("serif", Font.BOLD, 20);

    String empId;
    public UpdateEmployee(String empId) {
        this.empId = empId;

        heading = new JLabel("Update Emloyee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));

        namLabel = new JLabel("Name");
        namLabel.setBounds(50, 150, 100, 30);
        namLabel.setFont(font);

        namTextField = new JTextField("Name is non_editable");
        namTextField.setBounds(200, 150, 150, 30);
        namTextField.setEditable(false);

        fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(font);

        fnamTextField = new JTextField("Father name is non_editable");
        fnamTextField.setBounds(600, 150, 150, 30);
        fnamTextField.setEditable(false);

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(50, 200, 150, 30);
        dobLabel.setFont(font);
        dobChooser = new JDateChooser();
        dobChooser.setBounds(200,200,150,30);
        dobChooser.getDateEditor().setEnabled(false);

        salaryLable = new JLabel("Salary");
        salaryLable.setBounds(400, 200, 150, 30);
        salaryLable.setFont(font);

        salaryTF = new JTextField();
        salaryTF.setBounds(600, 200, 150, 30);

        addressJL = new JLabel("Address");
        addressJL.setBounds(50, 250, 150, 30);
        addressJL.setFont(font);

        addressTF = new JTextField();
        addressTF.setBounds(200, 250, 150, 30);

        phonumbJL = new JLabel("Phone Number");
        phonumbJL.setBounds(400, 250, 150, 30);
        phonumbJL.setFont(font);

        phonumTF = new JTextField();
        phonumTF.setBounds(600, 250, 150, 30);

        emailJL = new JLabel("Email");
        emailJL.setBounds(50, 300, 150, 30);
        emailJL.setFont(font);

        emailTF = new JTextField();
        emailTF.setBounds(200, 300, 150, 30);

        educationJL = new JLabel("Highest Education");
        educationJL.setBounds(400, 300, 160, 30);
        educationJL.setFont(font);


        educationTF = new JTextField();
        educationTF.setBackground(Color.WHITE);
        educationTF.setBounds(600, 300, 150, 30);
        educationTF.setEditable(false);

        designationJL = new JLabel("Designation");
        designationJL.setBounds(50, 350, 150, 30);
        designationJL.setFont(font);

        designationTF = new JTextField();
        designationTF.setBounds(200, 350, 150, 30);

        adharnumJL = new JLabel("Aadhar number");
        adharnumJL.setBounds(400, 350, 150, 30);
        adharnumJL.setFont(font);

        adharnumTF = new JTextField();
        adharnumTF.setBounds(600, 350, 150, 30);
        adharnumTF.setEditable(false);

        employeeidJL = new JLabel("Employee ID");
        employeeidJL.setBounds(50, 400, 150, 30);
        employeeidJL.setFont(font);


        employeeid = new JLabel();
        employeeid.setBounds(200, 400, 150, 30);

        try{
            EmployeeDAO empDAO = new EmployeeDAO();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet set = empDAO.stmt.executeQuery(query);

            while (set.next()){
                namTextField.setText(set.getString("name"));
                fnamTextField.setText(set.getString("Father_name"));
                dobChooser.setToolTipText(set.getString("DOB"));
                addressTF.setText(set.getString("address"));
                salaryTF.setText(set.getString("salary"));
                phonumTF.setText(set.getString("Phone_numb"));
                emailTF.setText(set.getString("email"));
                educationTF.setText(set.getString("Qualification"));
                designationTF.setText(set.getString("designation"));
                adharnumTF.setText(set.getString("adhar"));
                employeeid.setText(set.getString("empId"));
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }

        addDetailsbtn = new Button("Update Details");
        addDetailsbtn.setBounds(450, 550, 150, 40);
        addDetailsbtn.setBackground(Color.blue);
        addDetailsbtn.setForeground(Color.white);
        addDetailsbtn.setFont(new Font("Raleway", Font.BOLD, 12));
        addDetailsbtn.addActionListener(this);

        backbtn = new Button("Back");
        backbtn.setBounds(250, 550, 150, 40);
        backbtn.setBackground(Color.pink);
        backbtn.setForeground(Color.BLACK);
        backbtn.setFont(new Font("Raleway", Font.BOLD, 12));
        backbtn.addActionListener(this);

        setLayout(null);
        setBounds(300,50,900,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(153, 153, 255));
        add(heading);
        add(namLabel);
        add(namTextField);
        add(fname);
        add(fnamTextField);
        add(dobLabel);
        add(dobChooser);
        add(salaryLable);
        add(salaryTF);
        add(addressJL);
        add(addressTF);
        add(phonumbJL);
        add(phonumTF);
        add(emailJL);
        add(emailTF);
        add(educationJL);
        add(educationTF);
        add(designationJL);
        add(designationTF);
        add(adharnumJL);
        add(adharnumTF);
        add(employeeidJL);
        add(employeeid);
        add(addDetailsbtn);
        add(backbtn);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addDetailsbtn){
//            String name = namTextField.getText();
//            String fname = fnamTextField.getText();
//            String dob = ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText();
            String salary = salaryTF.getText();
            String address = addressTF.getText();
            String phonNum = phonumTF.getText();
            String email = emailTF.getText();
            String qualification = educationTF.getText();
            String designation = designationTF.getText();
//            String adhar = adharnumTF.getText();
//            String empID = employeeid.getText();


            try {
                EmployeeDAO empdao = new EmployeeDAO();
                String query = "update employee set salary = '"+salary+"', address = '"+address+"', Phone_numb = '"+phonNum+"', email =  '"+email+"', Qualification = '"+qualification+"', designation = '"+designation+"' where empId = '"+empId+"'";
                empdao.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            }catch (Exception exp){
                exp.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}



