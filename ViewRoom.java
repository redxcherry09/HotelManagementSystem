package hotelmanagement;
import javax.swing.*;
import java.sql.*;

public class ViewRooms extends JFrame {

    JTextArea area;

    ViewRooms() {
        setTitle("Rooms");
        setSize(400,400);

        area = new JTextArea();
        add(new JScrollPane(area));

        loadRooms();
        setVisible(true);
    }

    void loadRooms() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM rooms");

            while(rs.next()) {
                area.append(
                    rs.getInt("id")+" | "+
                    rs.getString("room_type")+" | "+
                    rs.getInt("price")+" | "+
                    rs.getString("status")+"\n"
                );
            }

        } catch(Exception e){ e.printStackTrace(); }
    }

    public static void main(String[] args){
        new ViewRooms();
    }
}
