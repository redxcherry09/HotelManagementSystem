package hotelmanagement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Checkout extends JFrame implements ActionListener {

    JComboBox<String> box;
    JButton pay;

    Checkout() {
        setTitle("Checkout");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);

        box = new JComboBox<>();
        box.setBounds(100,80,200,30);
        add(box);

        pay = new JButton("Pay & Checkout");
        pay.setBounds(100,150,200,40);
        add(pay);

        pay.addActionListener(this);

        loadBookings();

        setVisible(true);
    }

    // 🔥 FIX: Only show NOT PAID bookings
    void loadBookings() {
        try {
            box.removeAllItems();

            Connection con = DBConnection.getConnection();

            ResultSet rs = con.createStatement().executeQuery(
                "SELECT id, name FROM bookings WHERE status='Not Paid'"
            );

            boolean found = false;

            while(rs.next()) {
                found = true;
                box.addItem(rs.getInt("id") + " - " + rs.getString("name"));
            }

            if(!found){
                box.addItem("No Pending Payments");
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String selected = (String) box.getSelectedItem();

            if(selected.equals("No Pending Payments")){
                JOptionPane.showMessageDialog(null,"Nothing to pay!");
                return;
            }

            int id = Integer.parseInt(selected.split(" - ")[0]);

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE bookings SET status='Paid' WHERE id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"✅ Payment Done!");

            loadBookings(); // refresh

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Checkout();
    }
}
