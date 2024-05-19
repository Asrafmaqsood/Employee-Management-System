package employee.managment.sys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends  JFrame implements ActionListener {

    JTable table;
    JLabel search;
    Choice choiceEmpId;
    Button searchbtn, printbtn, updatebtn, backbtn;

    public ViewEmployee(){

        table = new JTable();

        search = new JLabel("Search  by Employee Id");
        search.setBounds(20,20,200,25);
        search.setFont(new Font("serif", Font.BOLD, 15));
        add(search);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(250,20,150,20);
        add(choiceEmpId);

        searchbtn = new Button("Search");
        searchbtn.setBounds(20,70,80,20);
        add(searchbtn);
        searchbtn.addActionListener(this);

        printbtn = new Button("Print");
        printbtn.setBounds(120,70,80,20);
        add(printbtn);
        printbtn.addActionListener(this);

        updatebtn = new Button("Update");
        updatebtn.setBounds(220,70,80,20);
        add(updatebtn);
        updatebtn.addActionListener(this);

        backbtn = new Button("Back");
        backbtn.setBounds(320,70,80,20);
        add(backbtn);
        backbtn.addActionListener(this);

        try {
            EmployeeDAO empDAO = new EmployeeDAO();
            String query = "select * from employee";
            ResultSet set = empDAO.stmt.executeQuery(query);

            while(set.next()){
                choiceEmpId.add(set.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            EmployeeDAO empDAO = new EmployeeDAO();
            String query = "select * from employee";
            ResultSet set = empDAO.stmt.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(set));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        setBounds(300,100,900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(153, 153, 255));
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from employee where empId = '"+choiceEmpId.getSelectedItem()+"'";
            try {
                EmployeeDAO empDAO = new EmployeeDAO();
                ResultSet set = empDAO.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(set));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource() == printbtn) {
            try{
                table.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource() == updatebtn) {
            setVisible(false);
            new UpdateEmployee(choiceEmpId.getSelectedItem());
        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args){
        new ViewEmployee();
    }
}
