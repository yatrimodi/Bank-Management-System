package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcase,ministatement,pinchange,balance,exit;
    String pinnumber;
    Transactions(String pinnumber) {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 900);
        add(imageLabel);
        
       
        JLabel textLabel = new JLabel("Please select your Transaction ");
        textLabel.setForeground(Color.WHITE); 
        textLabel.setFont(new Font("System", Font.BOLD, 16));
        textLabel.setBounds(210, 300, 700, 35);
        textLabel.setOpaque(false); 
        imageLabel.add(textLabel);
        
       deposit = new JButton("Deposit");
       deposit.setBounds(170,415, 150, 30);
       deposit.addActionListener(this);
       imageLabel.add(deposit);
       
       withdrawl = new JButton("Case Withdrawal");
       withdrawl.setBounds(355,415, 150, 30);
       withdrawl.addActionListener(this);
       imageLabel.add(withdrawl);
       
       fastcase = new JButton("Fast Cash");
       fastcase.setBounds(170,450, 150, 30);
       fastcase.addActionListener(this);
       imageLabel.add(fastcase);
       
       ministatement = new JButton("Mini Statement");
       ministatement.setBounds(355,450, 150, 30);
       ministatement.addActionListener(this);
       imageLabel.add(ministatement);
       
       pinchange = new JButton("Pin Change");
       pinchange.setBounds(170,485, 150, 30);
       pinchange.addActionListener(this);
       imageLabel.add(pinchange);
       
       balance = new JButton("Balance Enquiry");
       balance.setBounds(355,485, 150, 30);
       balance.addActionListener(this);
       imageLabel.add(balance);
       
       exit = new JButton("Exit");
       exit.setBounds(355,520, 150, 30);
       exit.addActionListener(this);
       imageLabel.add(exit);
       
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource()==fastcase){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
      } else if (ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        } 
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
