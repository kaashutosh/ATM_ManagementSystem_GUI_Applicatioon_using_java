package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquery extends JFrame implements ActionListener {
    String pin;
    JLabel l1,l2;
    JButton b1,b2;
    BalanceEnquery(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm4.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-100,-30,1550,830);
        add(image);

        l1 =new JLabel("Your Current Balance is Rs. ");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(580,240,700,25);
        l1.setForeground(Color.white);
        image.add(l1);


        l2 =new JLabel();
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(580,280,700,25);
        l2.setForeground(Color.white);
        image.add(l2);

        b1 = new JButton("Back");
        b1.setBounds(880,385,150,25);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);




        int balance = 0;
        try{
            ConnectDataBase con = new ConnectDataBase();
            ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));

                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        l2.setText(""+balance);






        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }


}
