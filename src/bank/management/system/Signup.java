package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JButton next;
    JRadioButton r1,r2,m1,m2,m3;
    JTextField textName,textFName,textEmail,textAdd,textCity,textPinCode,textState;
    JDateChooser dateChooser;
    Random rand = new Random();
    long first4 = (rand.nextLong() % 9000L)+1000L;
    String first = " " + Math.abs(first4);

    Signup() {
        super("Application Form");
        // For Bank logo or image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);
        // For Application text
        JLabel label1 = new JLabel("Application Form No"+first);
        label1.setBounds(130,20,600,40);
        label1.setFont(new Font("Rale way",Font.BOLD,38));
        add(label1);
        // For page 1 text
        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Rale way",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);
        // For Personal Details text
        JLabel label3 = new JLabel("Personal Details:");
        label3.setFont(new Font("Rale way",Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);
        // For Name text
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Rale way",Font.BOLD,22));
        labelName.setBounds(100,170,100,30);
        add(labelName);
        // For Name Box or text field
        textName = new JTextField();
        textName.setFont(new Font("Rale way",Font.BOLD,14));
        textName.setBounds(300,170,400,30);
        add(textName);
        // For Father Name text
        JLabel labelFName = new JLabel("Father Name :");
        labelFName.setFont(new Font("Rale way",Font.BOLD,22));
        labelFName.setBounds(100,220,200,30);
        add(labelFName);
        // For Father Name Box or text field
        textFName = new JTextField();
        textFName.setFont(new Font("Rale way",Font.BOLD,14));
        textFName.setBounds(300,220,400,30);
        add(textFName);
        // For date of birth text
        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Rale way",Font.BOLD,22));
        DOB.setBounds(100,300,200,30);
        add(DOB);
        // For adding calender
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,300,400,30);
        add(dateChooser);
        // For Gender text
        JLabel labelGender =new JLabel("Gender");
        labelGender.setFont(new Font("Rale way",Font.BOLD,20));
        labelGender.setBounds(100,260,200,30);
        add(labelGender);
        // For radio button for male
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Rale way",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,260,60,30);
        add(r1);
        // Radio button for Female
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Rale way",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,260,90,30);
        add(r2);
        // For select any one button or gander
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        // For email text
        JLabel labelEmail = new JLabel("Email address:");
        labelEmail.setFont(new Font("Rale way",Font.BOLD,20));
        labelEmail.setBounds(100,350,200,30);
        add(labelEmail);
        // For Email Box or text field
        textEmail = new JTextField();
        textEmail.setFont(new Font("Rale way",Font.BOLD,14));
        textEmail.setBounds(300,350,400,30);
        add(textEmail);
        // For married status text
        JLabel labelMS = new JLabel("Married status :");
        labelMS.setFont(new Font("Rale way",Font.BOLD,20));
        labelMS.setBounds(100,400,200,30);
        add(labelMS);
        // Button for married
        m1 = new JRadioButton("Married");
        m1.setBounds(290,400,100,30);
        m1.setBackground(new Color(222,255,228));
        m1.setFont(new Font("Rale way",Font.BOLD,14));
        add(m1);
        // Button for unmarried
        m2 = new JRadioButton("Unmarried");
        m2.setBounds(450,400,100,30);
        m2.setBackground(new Color(222,255,228));
        m2.setFont(new Font("Rale way",Font.BOLD,14));
        add(m2);
        // Button for others
        m3 = new JRadioButton("Others");
        m3.setBounds(630,400,100,30);
        m3.setBackground(new Color(222,255,228));
        m3.setFont(new Font("Rale way",Font.BOLD,14));
        add(m3);
        // select for any one button
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);
        // For Address text
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Rale way",Font.BOLD,20));
        labelAdd.setBounds(100,450,200,30);
        add(labelAdd);
        // For Address Box or text field
        textAdd = new JTextField();
        textAdd.setFont(new Font("Rale way",Font.BOLD,14));
        textAdd.setBounds(300,450,400,30);
        add(textAdd);
        // For city text
        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Rale way",Font.BOLD,20));
        labelCity.setBounds(100,500,200,30);
        add(labelCity);
        // For city box or text field
        textCity = new JTextField();
        textCity.setFont(new Font("Rale way",Font.BOLD,14));
        textCity.setBounds(300,500,400,30);
        add(textCity);
        // For pin code text
        JLabel labelPinCode = new JLabel("Pin Code :");
        labelPinCode.setFont(new Font("Rale way",Font.BOLD,20));
        labelPinCode.setBounds(100,550,200,30);
        add(labelPinCode);
        // For pin code box or text field
        textPinCode = new JTextField();
        textPinCode.setFont(new Font("Rale way",Font.BOLD,14));
        textPinCode.setBounds(300,550,400,30);
        add(textPinCode);
        // For state text
        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Rale way",Font.BOLD,20));
        labelState.setBounds(100,600,200,30);
        add(labelState);
        // For state box or text field
        textState = new JTextField();
        textState.setFont(new Font("Rale way",Font.BOLD,14));
        textState.setBounds(300,600,400,30);
        add(textState);
        // Foe next button text
        next = new JButton("Next");
        next.setFont(new Font("Rale way",Font.BOLD,14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);




        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,900);
        setLocation(360,40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = first;
        String name = textName.getText();
        String fname = textFName.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()) {
            gender = "Male";
        } else if(r2.isSelected()) {
            gender = "Female";
        }
        String email = textEmail.getText();
        String married = null;
        if(m1.isSelected()) {
            married = "Married";
        } else if (m2.isSelected()) {
            married = "Unmarried";
        } else if(m3.isSelected()) {
            married = "Others";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPinCode.getText();
        String state = textState.getText();
        try{
            if(textName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the field");
            } else {
                ConnectDataBase con1 = new ConnectDataBase();
                String query = String.format("insert into signup values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",formNo,name,fname,dob,gender,email,married,address,city,pincode,state);
                con1.statement.executeUpdate(query);
                new Signup2(formNo);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }


}

