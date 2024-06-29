package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mini_Statement extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Mini_Statement(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 40, 400, 400);
        add(l1);
        JLabel l2 = new JLabel("<html><i>"+"Check Mini Statements:"+"</i><hr></html>");
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(100, 5, 200, 20);
        add(l2);
        JLabel l3 = new JLabel();
        l3.setBounds(95, 25, 300, 20);
        add(l3);
        JLabel l4 = new JLabel();
        l4.setBounds(20, 470, 300, 20);
        add(l4);

        try{
            ConnectDataBase con = new ConnectDataBase();
            ResultSet rs = con.statement.executeQuery("select * from login where pin = "+pin+" ");
            while(rs.next()){
                l3.setText("<html><b><i>"+"Card No: "+rs.getString("card_no").substring(0,4)+"XXXXXXXX"+rs.getString("card_no").substring(12)+"</i></b><hr><html>");

            }
        }catch (Exception E){
            E.printStackTrace();
        }
        try{
            int balance = 0;
            ConnectDataBase con = new ConnectDataBase();
            Statement st = con.statement;
            ResultSet resultSet = st.executeQuery("select * from bank where pin = '" +pin+"'");
            while (resultSet.next()){
                l1.setText(l1.getText()+"<html>"+resultSet.getString("dates")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><html>");

                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));

                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            l4.setText("<html><i>"+"Your total balance Rs. "+balance+"</i></html>");

        } catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,510,100,25);
        button.addActionListener(this);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        add(button);




        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }


}

