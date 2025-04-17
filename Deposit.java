package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Deposit extends JFrame implements ActionListener 
{
    JTextField amount;
    JButton deposit1,back;
    String pinnumber;
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 900);
        add(imageLabel);
        
       
        JLabel textLabel = new JLabel("Enter the amount you want to deposit");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("System", Font.BOLD, 16));
        textLabel.setBounds(170, 300, 400, 20); 
        imageLabel.add(textLabel);
        
         amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25 );
        imageLabel.add(amount);
        
       deposit1 = new JButton("Deposit");
       deposit1.setBounds(355,485, 150, 30);
       deposit1.addActionListener(this);
       imageLabel.add(deposit1);
       
       back = new JButton("Back");
       back.setBounds(355,520, 150, 30);
       back.addActionListener(this);
       imageLabel.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposit1){
            String number=amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit!!");
            } else {
                try{
                Conn c = new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS"+number+"Deposited Successfully!!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
                 catch (SQLException ex) {
                   System.out.println(ex);
                }
                
                
            }
            
        }else 
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }
    
    public static void main(String args [])
    {
        new Deposit("");
    }
}
