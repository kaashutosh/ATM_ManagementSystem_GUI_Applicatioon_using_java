package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin_Change extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin_Change(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm4.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-100,-30,1550,830);
        add(image);
        JLabel l1 =new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(700,230,190,25);
        l1.setForeground(Color.white);
        image.add(l1);
        JLabel l2 =new JLabel("New PIN:");
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(530,260,150,35);
        l2.setForeground(Color.white);
        image.add(l2);
        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.white);
        p1.setBounds(690,295,180,25);
        p1.setFont(new Font("Rale way",Font.BOLD,22));
        image.add(p1);
        JLabel l3 =new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System",Font.BOLD,14));
        l3.setBounds(530,290,400,35);
        l3.setForeground(Color.white);
        image.add(l3);
        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.white);
        p2.setBounds(690,265,180,25);
        p2.setFont(new Font("Rale way",Font.BOLD,22));
        image.add(p2);
        b1 = new JButton("CHANGE");
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



        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();
            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Enter pin does not match: ");
                return;
            }
            if(e.getSource()==b1) {
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New Pin:");
                    return;
                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New Pin");
                    return;
                }

                ConnectDataBase con = new ConnectDataBase();
                String query1 = "Update bank set pin = "+pin1+" where pin = "+pin+" ";
                System.out.println(query1);
                String query2 = "Update login set pin = "+pin1+" where pin = "+pin+" ";
                System.out.println(query2);
                String query3 = "Update signupthree set pin = "+pin1+" where pin = "+pin+" ";
                System.out.println(query3);
                con.statement.executeUpdate(query1);
                con.statement.executeUpdate(query2);
                con.statement.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"pin change sucessfully");
                setVisible(false);
                new main_Class(pin);
            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

}


