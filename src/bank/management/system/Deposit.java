package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Deposit(String pin){
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm4.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-100,-30,1550,830);
        add(image);

        JLabel l1 =new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setBounds(580,230,400,35);
        l1.setForeground(Color.white);
        image.add(l1);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(580,260,320,25);
        textField.setFont(new Font("Rale way",Font.BOLD,22));
        image.add(textField);


        b1 = new JButton("Deposit");
        b1.setBounds(880,352,150,25);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Back");
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
        try{
            String amount = textField.getText();
            Date date =new Date();
            if(e.getSource()==b1) {
                if(textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");
                } else {
                    ConnectDataBase c = new ConnectDataBase();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposit Successfully");
                    setVisible(false);
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }


}
