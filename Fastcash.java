package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcase,ministatement,pinchange,balance,exit;
    String pinnumber;
    Fastcash(String pinnumber) {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 900);
        add(imageLabel);
        
       
        JLabel textLabel = new JLabel("SELECT WITHDRAWL AMOUNT ");
        textLabel.setForeground(Color.WHITE); 
        textLabel.setFont(new Font("System", Font.BOLD, 16));
        textLabel.setBounds(210, 300, 700, 35);
        textLabel.setOpaque(false); 
        imageLabel.add(textLabel);
        
       deposit = new JButton("RS 100");
       deposit.setBounds(170,415, 150, 30);
       deposit.addActionListener(this);
       imageLabel.add(deposit);
       
       withdrawl = new JButton("RS 500");
       withdrawl.setBounds(355,415, 150, 30);
       withdrawl.addActionListener(this);
       imageLabel.add(withdrawl);
       
       fastcase = new JButton("RS 1000");
       fastcase.setBounds(170,450, 150, 30);
       fastcase.addActionListener(this);
       imageLabel.add(fastcase);
       
       ministatement = new JButton("RS 2000");
       ministatement.setBounds(355,450, 150, 30);
       ministatement.addActionListener(this);
       imageLabel.add(ministatement);
       
       pinchange = new JButton("RS 5000");
       pinchange.setBounds(170,485, 150, 30);
       pinchange.addActionListener(this);
       imageLabel.add(pinchange);
       
       balance = new JButton("RS 10000");
       balance.setBounds(355,485, 150, 30);
       balance.addActionListener(this);
       imageLabel.add(balance);
       
       exit = new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount =((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
                int balance1 =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance1 += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance1 -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            
            
            if(ae.getSource()!= exit && balance1 <Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insuficiant Balance!!");
                return;
            }
            
            Date date= new Date();
            String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "RS"+amount+"Debited Successflly!!");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
            
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Fastcash("");
    }
}
