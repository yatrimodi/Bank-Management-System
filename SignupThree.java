package bank.management.system;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;



public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    JLabel atype,l1,card ,number,cardnumber,pin,pnumber,pinnumber ,services;
    SignupThree(String formn)  {
        formno=formn;
        setLayout(null);
        
        l1 = new JLabel("page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        atype = new JLabel("Account Type");
        atype.setFont(new Font("Raleway", Font.BOLD, 22));
        atype.setBounds(100,140,200,30);
        add(atype);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBounds(100,180,150,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBounds(100,220,250,20);
        add(r3);
        
        r4 = new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100,270,200,30);
        add(card);
        
        number = new JLabel("xxxx-xxxx-xxxx-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(380,270,400,30);
        add(number);
        
        cardnumber = new JLabel("Your 16 digit card number.");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        cardnumber.setBounds(100,300,200,20);
        add(cardnumber);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(200,350,200,30);
        add(pnumber);
        
        pinnumber = new JLabel("Your 4 digit password.");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        pinnumber.setBounds(100,380,200,20);
        add(pinnumber);
        
        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100,430,200,20);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,470,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,510,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(350,470,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMs Alert");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(100,510,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,550,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,550,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,590,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(250,630,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(420,630,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
       setSize(900,980); 
       setVisible(true);
       setLocation(300,00);
    }
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        // Check if atype is null
        if (atype == null) {
            JOptionPane.showMessageDialog(null, "Account type is required!!");
            return;
        }

        // Generate a 12-digit card number
        Random ran = new Random();
        long cardno = 100000000000L + (long) (ran.nextDouble() * 90000000000L);
        String cardnoStr = String.format("%012d", cardno);

        // Generate a 4-digit PIN
        int pin = 1000 + ran.nextInt(9000);
        String pinStr = String.format("%04d", pin);

        // Build the facilities string
        StringBuilder facility = new StringBuilder();
        if (c1.isSelected()) {
            facility.append("ATM CARD, ");
        }
        if (c2.isSelected()) {
            facility.append("Internet Banking, ");
        }
        if (c3.isSelected()) {
            facility.append("Mobile Banking, ");
        }
        if (c4.isSelected()) {
            facility.append("EMAIL & SMS Alert, ");
        }
        if (c5.isSelected()) {
            facility.append("Cheque Book, ");
        }
        if (c6.isSelected()) {
            facility.append("E-Statement, ");
        }

        // Remove the last comma and space
        if (facility.length() > 0) {
            facility.setLength(facility.length() - 2);
        }

        try {
            Conn c = new Conn();
            String query1 = "INSERT INTO signupthree VALUES('" + formno + "', '" + atype + "', '" + cardnoStr + "', '" + pinStr + "', '" + facility.toString() + "')";
            String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardnoStr + "', '" + pinStr + "')";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Card Number: " + cardnoStr + "\nPIN: " + pinStr);
            
            setVisible(false);
            new Deposit(pinStr).setVisible(false);

        } catch (Exception e) {
            System.out.println(e);
        }

    } else if (ae.getSource() == cancel) {
        setVisible(false);
        new Login().setVisible(true);
    }
}

    
    public static void main (String args[]){
       new SignupThree("");
    }
    
}
