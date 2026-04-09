package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminPanel extends JFrame implements ActionListener {

    JButton addRoom;

    AdminPanel() {
        setTitle("Admin Panel");
        setSize(400,300);
        setLayout(null);

        addRoom = new JButton("Add Room");
        addRoom.setBounds(120,100,150,40);
        add(addRoom);

        addRoom.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        new AddRoom();
    }

    public static void main(String[] args){
        new AdminPanel();
    }
}
