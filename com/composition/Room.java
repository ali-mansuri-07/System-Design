package com.composition;

import java.util.ArrayList;
import java.util.List;

class Room {
    String type;
    double area;


    Room(String type, double area) {
        this.type = type;
        this.area = area;
    }


    double getArea() { return area; }
}


class House {
    String address;
    List<Room> rooms;   // House OWNS rooms


    House(String address) {
        this.address = address;
        this.rooms = new ArrayList<>();


        // Rooms are created INSIDE House — they belong to it
        rooms.add(new Room("Bedroom", 200));
        rooms.add(new Room("Kitchen", 100));
        rooms.add(new Room("Hall", 300));
    }
    void showRooms() {
        for (Room r : rooms) {
            System.out.println(r.type + " - " + r.area + " sqft");
        }
    }
}

