package bank.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{
   
    JLabel textLabel,PintextLabel,rpintextLabel;
    JPasswordField pin,rpin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinchange)
    { 
        pinnumber=pinchange;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 900);
        add(imageLabel);
        
        
        textLabel = new JLabel("CHANGE YOUR PIN: ");
        textLabel.setForeground(Color.WHITE); 
        textLabel.setFont(new Font("System", Font.BOLD, 16));
        textLabel.setBounds(250, 280, 500, 35);
        textLabel.setOpaque(false); 
        imageLabel.add(textLabel);
        
        PintextLabel = new JLabel("New PIN: ");
        PintextLabel.setForeground(Color.WHITE); 
        PintextLabel.setFont(new Font("System", Font.BOLD, 16));
        PintextLabel.setBounds(165, 320, 180, 25);
        PintextLabel.setOpaque(false); 
        imageLabel.add(PintextLabel);
        
        pin = new JPasswordField();
        pin.setBounds(330, 320, 180, 25);
        pin.setFont(new Font ("Raleway", Font.BOLD,25));
        imageLabel.add(pin);
        
        rpintextLabel = new JLabel("Re-Enter New PIN: ");
        rpintextLabel.setForeground(Color.WHITE); 
        rpintextLabel.setFont(new Font("System", Font.BOLD, 16));
        rpintextLabel.setBounds(165, 360, 180, 25);
        rpintextLabel.setOpaque(false); 
        imageLabel.add(rpintextLabel);
        
        rpin = new JPasswordField();
        rpin.setBounds(330, 360, 180, 25);
        rpin.setFont(new Font ("Raleway", Font.BOLD,25));
        imageLabel.add(rpin);
        
       change = new JButton("Change PIN");
       change.setBounds(355,485, 150, 30);
       change.addActionListener(this);
       imageLabel.add(change);
       
       back = new JButton("Back");
       back.setBounds(355,520, 150, 30);
       back.addActionListener(this);
       imageLabel.add(back);
       
       
        
        
        
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==change){
        try{
                
            String npin=pin.getText();
            String repin=rpin.getText();
            
            if(!npin.equals(repin)){
                JOptionPane.showMessageDialog(null, "Enterd pin does not match");
                return;
             }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter New  pin!!");
                return;
            }
            
            if(repin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-Enter New  pin!!");
                return;
            }
            
            
            Conn c = new Conn();
            String query1="update bank set pin = '"+repin+"'where pin='"+pinnumber+ "'";
            String query2="update login set pin = '"+repin+"'where pin='"+pinnumber+ "'";
            String query3="update signupthree set pin = '"+repin+"'where pin='"+pinnumber+ "'";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN change successfully!");
            
               
        }catch(Exception e){
            System.out.println(e);
        }
      }
        else {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
        
    }
    
    public static void main (String args[]){
        new PinChange("").setVisible(true);
    }
    
}
