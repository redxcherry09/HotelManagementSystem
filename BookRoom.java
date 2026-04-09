
package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookRoom extends JFrame implements ActionListener {

    JTextField nameField;
    JComboBox<String> roomTypeBox, priceBox;
    JButton bookBtn;

    BookRoom() {
        setTitle("Book Room");
        setSize(400,350);
        setLayout(null);

        getContentPane().setBackground(new Color(20,40,70));

        // Title
        JLabel title = new JLabel("Book Room");
        title.setBounds(130,20,200,30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial",Font.BOLD,18));
        add(title);

        // Name
        JLabel name = new JLabel("Name:");
        name.setBounds(50,80,100,30);
        name.setForeground(Color.WHITE);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150,80,150,30);
        add(nameField);

        // Room Type
        JLabel type = new JLabel("Room Type:");
        type.setBounds(50,130,100,30);
        type.setForeground(Color.WHITE);
        add(type);

        roomTypeBox = new JComboBox<>(new String[]{"Single","Double"});
        roomTypeBox.setBounds(150,130,150,30);
        add(roomTypeBox);

        // Price
        JLabel price = new JLabel("Select Room:");
        price.setBounds(50,180,100,30);
        price.setForeground(Color.WHITE);
        add(price);

        priceBox = new JComboBox<>();
        priceBox.setBounds(150,180,150,30);
        add(priceBox);

        // Button
        bookBtn = new JButton("Book");
        bookBtn.setBounds(130,240,140,40);
        bookBtn.setBackground(new Color(70,130,180));
        bookBtn.setForeground(Color.WHITE);
        bookBtn.setFocusPainted(false);
        add(bookBtn);

        // Events
        roomTypeBox.addActionListener(e -> loadRooms());
        bookBtn.addActionListener(this);

        loadRooms(); // initial load

        setVisible(true);
    }

    // 🔥 Load available rooms based on type
    void loadRooms() {
        try {
            priceBox.removeAllItems();

            Connection con = DBConnection.getConnection();
            String type = (String) roomTypeBox.getSelectedItem();

            PreparedStatement ps = con.prepareStatement(
                "SELECT id, price FROM rooms WHERE room_type=? AND status='Available'"
            );

            ps.setString(1, type);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while(rs.next()) {
                found = true;
                priceBox.addItem(rs.getInt("id") + " - ₹" + rs.getInt("price"));
            }

            if(!found){
                priceBox.addItem("No Rooms Available");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 Booking Logic
    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            String type = (String) roomTypeBox.getSelectedItem();
            String selected = (String) priceBox.getSelectedItem();

            if(selected.equals("No Rooms Available")) {
                JOptionPane.showMessageDialog(null,"No room available!");
                return;
            }

            int roomId = Integer.parseInt(selected.split(" - ")[0]);
            int price = Integer.parseInt(selected.split("₹")[1]);

            Connection con = DBConnection.getConnection();

            // Insert booking
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bookings(name, room_type, price, status) VALUES(?,?,?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, price);
            ps.setString(4, "Not Paid");

            ps.executeUpdate();

            // Update room status
            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE rooms SET status='Booked' WHERE id=?"
            );

            ps2.setInt(1, roomId);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null,"✅ Room Booked!");

            loadRooms(); // refresh dropdown

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BookRoom();
    }
}
