/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Info;

import java.util.List;

/**
 *
 * @author ciclesgs
 */
public class vroom { // We create the valores, constructors, geters and seters
    private int room_id;
    private String number;
    private String places;
    private double price;
    private String availability;
    private String type;

    public vroom(int room_id, String places, double price, String availability, String type) {
        this.room_id = room_id;
        this.places = places;
        this.price = price;
        this.availability = availability;
        this.type = type;
    }



    public vroom() {
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String isAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    
        public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public Object [] toObject(){
        return new Object []{this.room_id, this.price, this.type,this.places};
    }
    public static Object [][] roomsToTable(List<vroom> rooms){
        
        Object [][] table = new Object[rooms.size()][1];

        for (int i = 0; i < rooms.size(); i++) {
            table[i] = rooms.get(i).toObject();
        }
        return table;
    }
    @Override
    public String toString() {
        
        return "ID: " + room_id + ", room number: " + number + ", room type: " + type + ", capacity; "+ places;
    }
}
