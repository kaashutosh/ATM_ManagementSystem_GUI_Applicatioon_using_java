package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm4.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-100,-30,1550,830);
        //image.setBounds(0,0,1250,830);
        add(image);

        JLabel l1 =new JLabel("MAXIMUM WITHDRAWL IS RS.50,000");
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setBounds(580,230,700,35);
        l1.setForeground(Color.white);
        image.add(l1);
        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(800,265,220,25);
        textField.setFont(new Font("Rale way",Font.BOLD,22));
        image.add(textField);

        JLabel l2 =new JLabel("PLEASE ENTER YOUR AMOUNT :");
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(550,260,700,35);
        l2.setForeground(Color.white);
        image.add(l2);




        b1 = new JButton("withrawl");
        b1.setBounds(880,352,150,25);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(880,385,150,25);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        image.add(b2);






        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "please enter your amount you want to withdrawl");
                } else {
                    ConnectDataBase con = new ConnectDataBase();
                    ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));

                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }

                    con.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + "Debited Successfully");
                    setVisible(false);

                    new main_Class(pin);
                }


            } catch (Exception E) {

            }
        }else if(e.getSource()==b2){
            setVisible(false);
            new main_Class(pin);

        }

    }


}

