/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Info.vroom;


/**
 *
 * @author ciclesgs
 */
public class conexion { // We create the conexion method to conect all this program to the database
    public String db ="hotelreservationsystem";
    public String url="jdbc:mysql://127.0.0.1/" +db;
    public String users="root";
    public String pass="";
    
    public conexion(){
        
    }
    
    public Connection connect(){ // This will execute the connection
        Connection link=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link=DriverManager.getConnection(this.url, this.users, this.pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;
    }
        public List<vroom> reedRooms() {

        List<vroom> rooms = new ArrayList<vroom>();
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(url, users, pass);

            String insertQuery = "SELECT * FROM room";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int room_id = rs.getInt("room_id");
                String type = rs.getString("type");
                String places = rs.getString("places");
                String aviablility = rs.getString("availability");
                double price = rs.getDouble("price");

                rooms.add(new vroom(room_id, type, price , aviablility, places));

            }
            // Close the connection
            connection.close();
            return rooms;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
