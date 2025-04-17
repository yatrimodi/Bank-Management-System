package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber)
    {
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 900);
        add(imageLabel);
        
        
       back = new JButton("Back");
       back.setBounds(355,520, 150, 30);
       back.addActionListener(this);
       imageLabel.add(back);
       
       
       Conn c = new Conn();
       int balance1 =0;
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance1 += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance1 -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
                catch(Exception e){
                        System.out.println(e);
                        }
        JLabel textLabel = new JLabel("Your Current Account balance is RS:="+balance1);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("System", Font.BOLD, 16));
        textLabel.setBounds(170, 300, 400, 20); 
        imageLabel.add(textLabel);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
     public void actionPerformed(ActionEvent ae){
         
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
     }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
