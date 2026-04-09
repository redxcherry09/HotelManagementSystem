package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton login;

    Login() {
        setTitle("Login");
        setSize(350,250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(50,50,100,30);
        add(l1);

        user = new JTextField();
        user.setBounds(150,50,120,30);
        add(user);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(50,100,100,30);
        add(l2);

        pass = new JPasswordField();
        pass.setBounds(150,100,120,30);
        add(pass);

        login = new JButton("Login");
        login.setBounds(100,150,120,30);
        add(login);

        login.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            ps.setString(1, user.getText());
            ps.setString(2, new String(pass.getPassword()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Invalid Login");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
