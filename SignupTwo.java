package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {
    
    long random;
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,Catagory,Income,education,occupation;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
         setTitle ("New Account Application Form Page 2");
        
        JLabel additinalDetails = new JLabel("Page 2: Additional Details");
        additinalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additinalDetails.setBounds(290, 80, 400, 30);
        add(additinalDetails);
        
        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion.setBounds(100, 140, 200, 30);
        add(Religion);
        
        
        String valreligion []={"Hindu","Muslim","Sikh","Christian","other"};
        religion =new JComboBox(valreligion);
        religion.setBounds(300, 140,400,30 );
        add(religion);
        
       
        
        JLabel catagory = new JLabel("Catagory:");
        catagory.setFont(new Font("Raleway", Font.BOLD, 20));
        catagory.setBounds(100, 190, 200, 30);
        add(catagory);
        
        String valcatagory []={"General","OBC","SC","ST","other"};
        Catagory =new JComboBox(valcatagory);
        Catagory.setBounds(300, 190,400,30 );
        add(Catagory );
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valincome []={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        Income =new JComboBox(valincome);
        Income.setBounds(300,240,400,30);
        add(Income);
        
        JLabel educatinal = new JLabel("Educational");
        educatinal.setFont(new Font("Raleway", Font.BOLD, 20));
        educatinal.setBounds(100, 290, 200, 30);
        add(educatinal);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 320, 200, 30);
        add(qualification);
        
        String valeducation []={"Non-Graduation","Graduate","Post-Graduation","Doctarate","Other"};
        education =new JComboBox(valeducation);
        education.setBounds(300, 310,400,30 );
        add(education);
       
        JLabel Occupation= new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 200, 30);
        add(Occupation);
        
        String valoccupation []={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation =new JComboBox(valoccupation);
        occupation.setBounds(300, 390,400,30 );
        add(occupation);
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440,400,30 );
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490,400,30 );
        add(aadharTextField);
        
        JLabel sc = new JLabel("Sinior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        sc.setBounds(100, 540, 200, 30);
        add(sc);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(syes);
        scgroup.add(sno);
        
        JLabel ea = new JLabel("Exisiting Account:");
        ea.setFont(new Font("Raleway", Font.BOLD, 20));
        ea.setBounds(100, 590, 200, 30);
        add(ea);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eagroup = new ButtonGroup();
        eagroup.add(eyes);
        eagroup.add(eno);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660,80,30 );
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+random;
        String Religion =(String)religion.getSelectedItem();
        String catagory =(String)Catagory.getSelectedItem();
        String income=(String)Income.getSelectedItem();
        String educatinal=(String)education.getSelectedItem();
        String Occupation=(String)occupation.getSelectedItem();
        String sc=null;
         if(syes.isSelected()){
             sc="Yes";
         } else if(sno.isSelected()){
             sc="No";
         }
        
        String ea=null;
         if(eyes.isSelected()){
             ea="Yes";
         }  else if(eno.isSelected()){
            ea="Unmarried";
         }  
        String pan=panTextField.getText();
        String aadhar=aadharTextField.getText();
       
        
        
        try{
            if(pan.equals(""))
            {
                JOptionPane.showMessageDialog(null, "PAN is required!!");
            }
            if(aadhar.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Aadhar is required!!");
            }
            
            else {
                Conn c=new Conn();
                String query ="insert into signuptwo values('"+formno+"', '"+Religion+"', '"+catagory+"', '"+income+"', '"+educatinal+"', '"+pan+"', '"+sc+"','"+ea+"','"+pan+"','"+aadhar+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
        
        
    }
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
    
}
