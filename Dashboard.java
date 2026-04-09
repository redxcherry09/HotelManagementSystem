package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton bookBtn, roomBtn, bookingBtn, checkoutBtn, adminBtn;

    Dashboard() {
        setTitle("Dashboard");
        setSize(500,450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setBounds(80,30,400,40);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        bookBtn = createButton("Book Room",100);
        roomBtn = createButton("View Rooms",150);
        bookingBtn = createButton("View Bookings",200);
        checkoutBtn = createButton("Checkout",250);
        adminBtn = createButton("Admin Panel",300);

        add(bookBtn); add(roomBtn); add(bookingBtn);
        add(checkoutBtn); add(adminBtn);

        bookBtn.addActionListener(this);
        roomBtn.addActionListener(this);
        bookingBtn.addActionListener(this);
        checkoutBtn.addActionListener(this);
        adminBtn.addActionListener(this);

        setVisible(true);
    }

    JButton createButton(String text,int y){
        JButton b = new JButton(text);
        b.setBounds(150,y,200,35);
        return b;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bookBtn) new BookRoom();
        if(e.getSource()==roomBtn) new ViewRooms();
        if(e.getSource()==bookingBtn) new ViewBook();
        if(e.getSource()==checkoutBtn) new Checkout();
        if(e.getSource()==adminBtn) new AdminPanel();
    }

    public static void main(String[] args){
        new Dashboard();
    }
}
