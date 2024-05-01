package Advanced.Airline_Reservation_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class login extends JFrame implements ActionListener {

    JTextField user_name;
    JPasswordField pass_word;
    JButton login, back;

    login() {
        JLabel title = new JLabel("Airline Reservation System");
        title.setFont(new Font("MONOSPACED", Font.BOLD, 30));
        title.setBounds(125, 40, 600, 50);
        title.setForeground(Color.black);
        add(title);

        JLabel username = new JLabel("Username");
        username.setBounds(450, 130, 100, 30);
        username.setForeground(Color.black);
        add(username);

        user_name = new JTextField();
        user_name.setBounds(450, 170, 200, 30);
        add(user_name);

        JLabel password = new JLabel("Password");
        password.setBounds(450, 210, 100, 30);
        password.setForeground(Color.black);
        add(password);

        pass_word = new JPasswordField();
        pass_word.setBounds(450, 250, 200, 30);
        add(pass_word);

        login = new JButton("LOGIN");
        login.setBounds(450, 310, 200, 30);
        login.setBackground(new Color(255, 165, 0));
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(450, 360, 200, 30);
        back.setBackground(new Color(255, 165, 0));
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        ImageIcon b4 = new ImageIcon(ClassLoader.getSystemResource("Advanced/Airline_Reservation_System/airline-icons/bg.jpg"));
        Image b5 = b4.getImage().getScaledInstance(750, 500, Image.SCALE_DEFAULT);
        ImageIcon b6 = new ImageIcon(b5);
        JLabel img1 = new JLabel(b6);
        img1.setBounds(0, 0, 750, 500);
        add(img1);

        setSize(750, 500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = user_name.getText();
                String password = pass_word.getText();

                Database_Connect connect = new Database_Connect();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet resultSet = connect.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            System.exit(1);
        }
    }
}

class Database_Connect {
    Connection connection;
    Statement statement;

    public Database_Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

class dashboard extends JFrame {
    public dashboard() {

        JLabel jLabel1 = new JLabel();
        jLabel2 = new javax.swing.JLabel();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("DASHBOARD");

        jLabel2.setText("BACK");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getSource() == jLabel2) {
                    new login();
                }
            }
        });

        jButton1.setText("Manage Flight");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Manage Passenger");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Ticket Booking");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Ticket Cancellation");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(119, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap(58, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        manageflight obj = new manageflight();
        obj.setVisible(true);
        dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        managepassenger obj = new managepassenger();
        obj.setVisible(true);
        dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        ticketbooking obj = new ticketbooking();
        obj.setVisible(true);
        dispose();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        ticketcancellation obj = new ticketcancellation();
        obj.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new dashboard().setVisible(true));
    }
    private final javax.swing.JLabel jLabel2;
}

class ticketcancellation extends javax.swing.JFrame {

    public ticketcancellation() {

        JLabel jLabel1 = new JLabel();
        tid = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("TICKET CANCELLATION");

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel2.setText("Delete ticket, Enter Ticket ID:");

        jLabel3.setText("BACK");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(155, 155, 155)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            con.createStatement();

            String ticketid = tid.getText();
            String sql = "DELETE FROM `ticketbooking` WHERE id='" + ticketid + "'";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void jLabel3MouseClicked() {
        dashboard obj = new dashboard();
        obj.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ticketcancellation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new ticketcancellation().setVisible(true));
    }

    private final javax.swing.JTextField tid;
}

class ticketbooking extends javax.swing.JFrame {

    public ticketbooking() {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        pid = new javax.swing.JTextField();
        pn = new javax.swing.JTextField();
        fc = new javax.swing.JTextField();
        g = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new javax.swing.JTable();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JLabel jLabel9 = new JLabel();
        JButton jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("TICKET BOOKING");

        jLabel2.setText("Passengerid");

        jLabel3.setText("Passenger name");

        jLabel4.setText("Flight Code");

        jLabel5.setText("Gender");

        jLabel6.setText("Passportnumber");

        jLabel7.setText("Amount");

        jLabel8.setText("nationality");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[]{
                        "Passenger ID", "PassengerName", "Flight Code", "Gender", "Passport Number", "Amout", "Nationality"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SAVE");
        jButton1.addActionListener(evt -> jButton1ActionPerformed());

        jButton2.setText("RESET");
        jButton2.addActionListener(evt -> jButton2ActionPerformed());

        jLabel9.setText("BACK");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked();
            }
        });

        jButton3.setText("SEARCH");
        jButton3.addActionListener(evt -> jButton3ActionPerformed());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jScrollPane1)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(jLabel2))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(jLabel4)))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(jLabel5))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel6)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jLabel7))))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel1)
                                                                                                .addGap(81, 81, 81)))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel8)
                                                                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(139, 139, 139)
                                                                .addComponent(jButton1)
                                                                .addGap(102, 102, 102)
                                                                .addComponent(jButton2)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(jButton3)))
                                                .addGap(0, 11, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            String sql = "insert into ticketbooking values (?,?,?,?,?,?,?)";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.setString(1, pid.getText());
            ptst.setString(2, pn.getText());
            ptst.setString(3, fc.getText());
            ptst.setString(4, g.getText());
            ptst.setString(5, pass.getText());
            ptst.setString(6, amt.getText());
            ptst.setString(7, n.getText());

            ptst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data inserted Successfully!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jButton2ActionPerformed() {
        pid.setText("");
        pn.setText("");
        fc.setText("");
        g.setText("");
        pass.setText("");
        amt.setText("");
        n.setText("");
    }

    private void jLabel9MouseClicked() {
        dashboard obj = new dashboard();
        obj.setVisible(true);
        dispose();
    }

    private void jButton3ActionPerformed() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            String sql = "SELECT * from ticketbooking";
            PreparedStatement ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            while (rs.next()) {
                Object[] o = {rs.getString("id"), rs.getString("name"), rs.getString("flightcode"), rs.getString("gender"), rs.getString("passportnumber"), rs.getString("amount"), rs.getString("nationality")};
                dt.addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    public static void main(String[] args
    ) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ticketbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new ticketbooking().setVisible(true));
    }

    private final javax.swing.JTextField amt;
    private final javax.swing.JTextField fc;
    private final javax.swing.JTextField g;
    private final javax.swing.JTable jTable1;
    private final javax.swing.JTextField n;
    private final javax.swing.JTextField pass;
    private final javax.swing.JTextField pid;
    private final javax.swing.JTextField pn;

}

class managepassenger extends javax.swing.JFrame {

    public managepassenger() {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        pn = new javax.swing.JTextField();
        g = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        ph = new javax.swing.JTextField();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new javax.swing.JTable();

        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("Manage Passenger");

        jLabel2.setText("Passenger Name:");

        jLabel3.setText("Gender");

        jLabel4.setText("Nationality");

        jLabel5.setText("Passport Number");

        jLabel6.setText("Phone");

        jLabel7.setText("BACK");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "PassengerName", "Gender", "Nationality", "Passportnumber", "Phone"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("INSERT");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("UPDATE");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("SEARCH");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("DELETE");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel7))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel1)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addGap(43, 43, 43)
                                                                                .addComponent(jLabel3)
                                                                                .addGap(56, 56, 56)
                                                                                .addComponent(jLabel4)
                                                                                .addGap(47, 47, 47)
                                                                                .addComponent(jLabel5)))
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel6)))
                                                .addGap(0, 29, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(32, 32, 32)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            String sql = "insert into managepassenger values (?,?,?,?,?)";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.setString(1, pn.getText());
            ptst.setString(2, g.getText());
            ptst.setString(3, n.getText());
            ptst.setString(4, pass.getText());
            ptst.setString(5, ph.getText());
            ptst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data inserted Succesfully!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String name = pn.getText();
            String gender = g.getText();
            String nationaliy = n.getText();
            String passport = pass.getText();
            String phone = ph.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");

            String sql = "UPDATE `managepassenger` SET `name`='" + name + "',`gender`='" + gender + "',`nationality`='" + nationaliy + "',`passportnumber`='" + passport + "',`phone`='" + phone + "'";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.execute();

            JOptionPane.showMessageDialog(this, "Record Updated!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            String sql = "SELECT * from managepassenger";
            PreparedStatement ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            while (rs.next()) {
                Object[] o = {rs.getString("name"), rs.getString("gender"), rs.getString("nationality"), rs.getString("passportnumber"), rs.getString("phone")};
                dt.addRow(o);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            con.createStatement();

            String phone = ph.getText();
            String sql = "DELETE FROM `managepassenger` WHERE phone='" + phone + "'";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted succsessfully");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void jLabel7MouseClicked() {
        dashboard obj = new dashboard();
        obj.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managepassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new managepassenger().setVisible(true));
    }

    private final javax.swing.JTextField g;
    private final javax.swing.JTable jTable1;
    private final javax.swing.JTextField n;
    private final javax.swing.JTextField pass;
    private final javax.swing.JTextField ph;
    private final javax.swing.JTextField pn;

}

class manageflight extends javax.swing.JFrame {

    manageflight() {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new javax.swing.JTable();
        fc = new javax.swing.JTextField();
        s = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        tof = new javax.swing.JTextField();
        nos = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();
        JLabel jLabel7 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("Manage Flight");

        jLabel2.setText("Flight Code");

        jLabel3.setText("Source");

        jLabel4.setText("Destination");

        jLabel5.setText("Take of");

        jLabel6.setText("No of Seats");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "FlightCode", "Source", "Destination", "Take off", "NoofSeats"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("INSERT");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("UPDATE");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("SEARCH");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("DELETE");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jLabel7.setText("BACK");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(jLabel2)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(jLabel3)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel4)
                                                                .addGap(72, 72, 72))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(16, 16, 16)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jButton1)
                                                                                .addGap(46, 46, 46)
                                                                                .addComponent(jButton2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(s)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(jLabel5)
                                                                .addGap(80, 80, 80)
                                                                .addComponent(jLabel6))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(tof, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(nos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jButton3)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(jButton4)))
                                                .addGap(103, 103, 103))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            String sql = "insert into manageflight values (?,?,?,?,?)";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.setString(1, fc.getText());
            ptst.setString(2, s.getText());
            ptst.setString(3, d.getText());
            ptst.setString(4, tof.getText());
            ptst.setString(5, nos.getText());
            ptst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data inserted Succesfully!");
            con.close();
        } catch (Exception ignored) {
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");
            String sql = "SELECT * from manageflight";
            PreparedStatement ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            while (rs.next()) {
                Object[] o = {rs.getString("flightcode"), rs.getString("source"), rs.getString("destination"), rs.getString("takeoff"), rs.getString("noofseat")};
                dt.addRow(o);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");

            String id = fc.getText();
            String sql = "DELETE FROM `manageflight` WHERE flightcode='" + id + "'";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted succsessfully");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String source = s.getText();
            String des = d.getText();
            String tak = tof.getText();
            String noofseat = nos.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_table", "root", "1234");

            String sql = "UPDATE `manageflight` SET `source`='" + source + "',`destination`='" + des + "',`takeoff`='" + tak + "',`noofseat`='" + noofseat + "'";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.execute();

            JOptionPane.showMessageDialog(this, "Record Updated!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void jLabel7MouseClicked() {
        dashboard obj = new dashboard();
        obj.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageflight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new manageflight().setVisible(true));
    }

    private final javax.swing.JTextField d;
    private final javax.swing.JTextField fc;
    private final javax.swing.JTable jTable1;
    private final javax.swing.JTextField nos;
    private final javax.swing.JTextField s;
    private final javax.swing.JTextField tof;
}
