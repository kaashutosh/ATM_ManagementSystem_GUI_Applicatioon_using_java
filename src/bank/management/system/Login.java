package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JButton Button1, Button2, Button3;
    JPasswordField passwordField3;

    Login() {
        super("Bank mManagement System");

        //For Welcome text
        label1 = new JLabel("WELCOME TO MY BANK");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGArd", Font.BOLD, 30));
        label1.setBounds(230, 70, 450, 40);
        add(label1);
        //For card text
        label2 = new JLabel("Card No:");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Ralway", Font.BOLD, 14));
        label2.setBounds(65, 170, 375, 30);
        add(label2);
        //For card text column or box
        textField2 = new JTextField(15);
        textField2.setBounds(125, 172, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);
        //For Pin text or password
        label3 = new JLabel("Pin:");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Ralway", Font.BOLD, 14));
        label3.setBounds(65, 230, 375, 30);
        add(label3);
        //For pin text or box or password
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(125, 233, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);
        //For sing in button
        Button1 = new JButton("SIGN IN");
        Button1.setFont(new Font("Arial", Font.BOLD, 14));
        Button1.setForeground(Color.white);
        Button1.setBackground(Color.blue);
        Button1.setBounds(125, 300, 100, 30);
        Button1.addActionListener(this);
        add(Button1);
        //For clear button
        Button2 = new JButton("CLEAR");
        Button2.setFont(new Font("Arial", Font.BOLD, 14));
        Button2.setForeground(Color.white);
        Button2.setBackground(Color.blue);
        Button2.setBounds(255, 300, 100, 30);
        Button2.addActionListener(this);
        add(Button2);
        //For sign up button
        Button3 = new JButton("SIGN UP");
        Button3.setFont(new Font("Arial", Font.BOLD, 14));
        Button3.setForeground(Color.white);
        Button3.setBackground(Color.blue);
        Button3.setBounds(125, 350, 230, 30);
        Button3.addActionListener(this);
        add(Button3);
        //For background image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/loginfront.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        //setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == Button1) {
                ConnectDataBase c = new ConnectDataBase();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_no =" + cardno + " and pin = " + pin + " ";
                System.out.println(q);

                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "incorrect card no or pin.............");
                }

            } else if (e.getSource() == Button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == Button3) {
                new Signup();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}




