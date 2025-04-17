package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 900);
        add(imageLabel);

        JLabel textLabel = new JLabel("Enter the amount you want to withdraw");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("System", Font.BOLD, 16));
        textLabel.setBounds(170, 300, 400, 20);
        imageLabel.add(textLabel);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        imageLabel.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        imageLabel.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        imageLabel.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String numberStr = amount.getText();
            if (numberStr.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw!!");
                return;
            }

            try {
                int amountToWithdraw = Integer.parseInt(numberStr);

                // Step 1: Check account balance
                Conn c = new Conn();
                String checkBalanceQuery = "SELECT amount FROM bank WHERE pin = '" + pinnumber + "'";
                ResultSet rs = c.s.executeQuery(checkBalanceQuery);

                if (rs.next()) {
                    int balance = rs.getInt("amount");

                    if (amountToWithdraw > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance to withdraw RS" + amountToWithdraw + "!!");
                        return;
                    }

                    // Step 2: Update balance
                    String updateBalanceQuery = "UPDATE bank SET amount = amount - " + amountToWithdraw + " WHERE pin = '" + pinnumber + "'";
                    c.s.executeUpdate(updateBalanceQuery);

                    // Step 3: Record the transaction
                    String recordTransactionQuery = "INSERT INTO transactions VALUES('" + pinnumber + "','" + new Date() + "','withdrawal'," + amountToWithdraw + ")";
                    c.s.executeUpdate(recordTransactionQuery);

                    JOptionPane.showMessageDialog(null, "RS" + amountToWithdraw + " withdrawn successfully!!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found!!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid amount format!!");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdrawl("");
    }
}
