/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Info.vroom;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ciclesgs
 */
public class froom {
    private conexion mysql = new conexion();
    private Connection cn= mysql.connect();
    private String sSQL="";
    public Integer totalregisters; // We will use this for show how many reservation there are
    
    public DefaultTableModel show(String search){ // We create the method show that will show the information of the table
        DefaultTableModel model;
        
        String [] title = {"ID", "places", "price", "availability", "type"};
        
        String [] register =new String [8];
        
        totalregisters=0;
        model = new DefaultTableModel(null, title);
        
        sSQL="select * from room" + search + " order by room_id";
        try{
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                register [0]=rs.getString("room_id");
                register [0]=rs.getString("places");
                register [0]=rs.getString("price");
                register [0]=rs.getString("availability");
                register [0]=rs.getString("type");
                
                totalregisters=totalregisters+1;
                model.addRow(register);
                
            }
            return model;
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insert(vroom dts){ // We create the method insert that will add the information to the table
        sSQL="insert into room (room_id, price, places, availability, type)" +
                "values (?,?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumber());
            pst.setString(2, dts.getPlaces());
            pst.setDouble(3, dts.getPrice());
            pst.setString(4, dts.isAvailability());
            pst.setString(5, dts.getType());
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
}
    
        public boolean edit(vroom dts){ // We create the edit method to edit the information on the datebase
            sSQL="update room set places=?,price=?, availability=?"+
                    "where room_id =?";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setString(1, dts.getNumber());
            pst.setString(2, dts.getPlaces());
            pst.setDouble(3, dts.getPrice());
            pst.setString(4, dts.isAvailability());
            pst.setString(5, dts.getType());
            pst.setInt(6, dts.getRoom_id());
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
}
        public boolean eliminar(vroom dts){ // Deletes the information of the database
            sSQL="delete from room where room_id=?";
        try {
             PreparedStatement pst=cn.prepareStatement(sSQL);
             pst.setInt(1, dts.getRoom_id());
             
             int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
        
     
}

