package hotelmanagement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddRoom extends JFrame implements ActionListener {

    JComboBox<String> typeBox, priceBox;
    JButton add;

    AddRoom() {
        setTitle("Add Room");
        setSize(300,250);
        setLayout(null);
        setLocationRelativeTo(null);

        // Room Type
        typeBox = new JComboBox<>(new String[]{"Single","Double"});
        typeBox.setBounds(80,40,120,30);
        add(typeBox);

        // 🔥 Price Dropdown (1000 to 10000)
        priceBox = new JComboBox<>();
        priceBox.setBounds(80,90,120,30);

        for(int i=1000; i<=10000; i+=1000){
            priceBox.addItem(String.valueOf(i));
        }

        add(priceBox);

        // Button
        add = new JButton("Add Room");
        add.setBounds(80,140,120,30);
        add(add);

        add.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try {
            Connection con = DBConnection.getConnection();

            String type = (String) typeBox.getSelectedItem();
            int price = Integer.parseInt((String) priceBox.getSelectedItem());

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO rooms(room_type, price, status) VALUES(?,?,?)"
            );

            ps.setString(1, type);
            ps.setInt(2, price);
            ps.setString(3, "Available");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"✅ Room Added!");

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new AddRoom();
    }
}
