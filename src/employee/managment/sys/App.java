package employee.managment.sys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App extends JFrame implements ActionListener{

    JLabel heading, image;
    Button btn;
    App() {
        heading = new JLabel("Employee Management");
        heading.setBounds(300, 1, 1000, 80);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("employee/managment/sys/icons/front.jpg"));
        image = new JLabel(icon);
        image.setBounds(55,80,1050,500);

        btn = new Button("CLICK HERE TO CONTINUE");
        btn.setBounds(350,430,250,50);
        btn.setBackground(Color.MAGENTA);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.addActionListener(this);

        setSize(1170, 650);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CRUD Project");
        Color color = new Color(153, 153, 255);
        getContentPane().setBackground(color);
        setLocation(200, 50);
        add(heading);
        add(image);
        image.add(btn);

        while(true){
            heading.setVisible(false);
            try {
                Thread.sleep(650);
            }catch (Exception e){

            }
            heading.setVisible(true);
            try {
                Thread.sleep(650);
            }catch (Exception e){

            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args){
        new App();
    }
}
