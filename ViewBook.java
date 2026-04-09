package hotelmanagement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewBook extends JFrame {

    JTable table;
    DefaultTableModel model;

    ViewBook() {
        setTitle("View Bookings");
        setSize(600,400);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(20,30,50));

        JLabel title = new JLabel("All Bookings", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // Table Columns
        String[] columns = {"ID", "Name", "Room Type", "Price", "Status"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);

        loadBookings();

        setVisible(true);
    }

    void loadBookings() {
        try {
            Connection con = DBConnection.getConnection();

            ResultSet rs = con.createStatement().executeQuery(
                "SELECT * FROM bookings"
            );

            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("room_type"),
                    rs.getInt("price"),
                    rs.getString("status")
                });
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new ViewBook();
    }
}
