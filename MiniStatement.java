package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    private JButton b1;
    private JLabel l1, l2, l3, l4;
    private String pinnumber;

    public MiniStatement(String pin) {
        pinnumber = pin;
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        l1 = new JLabel();
        l2 = new JLabel("Indian Bank", SwingConstants.CENTER);
        l3 = new JLabel();
        l4 = new JLabel();

        // Panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.add(l2);
        add(headerPanel, BorderLayout.NORTH);

        // Panel for card info and transaction history
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(l3);
        JScrollPane scrollPane = new JScrollPane(l1);
        scrollPane.setPreferredSize(new Dimension(360, 400));
        centerPanel.add(scrollPane);
        centerPanel.add(l4);
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBounds(20,180,300,500);

        // Panel for exit button
        JPanel bottomPanel = new JPanel();
        b1 = new JButton("Exit");
        b1.addActionListener(this);
        bottomPanel.add(b1);
        add(bottomPanel, BorderLayout.SOUTH);

        fetchMiniStatement();
    }

    private void fetchMiniStatement() {
        try {
            Conn c = new Conn();
            // Fetch Card Number
            String cardQuery = "SELECT cardnumber FROM login WHERE pin = ?";
            try (PreparedStatement pstmt = c.conn.prepareStatement(cardQuery)) {
                pstmt.setString(1, pinnumber);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String cardnumber = rs.getString("cardnumber");
                        l3.setText("Card Number: " + cardnumber.substring(0, 4) + "XXXXXXXX" + cardnumber.substring(12));
                    }
                }
            }

            // Fetch Transactions
            int balance = 0;
            StringBuilder statement = new StringBuilder("<html>");
            String transactionQuery = "SELECT date, type, amount FROM bank WHERE pin = ?";
            try (PreparedStatement pstmt = c.conn.prepareStatement(transactionQuery)) {
                pstmt.setString(1, pinnumber);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        statement.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;")
                                .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                                .append(rs.getString("amount")).append("<br>");
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                }
            }
            statement.append("</html>");
            l1.setText(statement.toString());
            l4.setText("Your total Balance is Rs " + balance);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniStatement("1234").setVisible(true));
    }
}
