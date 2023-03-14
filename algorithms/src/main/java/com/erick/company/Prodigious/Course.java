package com.erick.company.Prodigious;

import java.util.Optional;

public class Course {
    public Course() {

    }

    Room room;

    Optional  getRoom() {
        return Optional.of(room);
    }

    public static void main(String[] args) {
        Course c = new Course();
        //Integer number = c.getRoom().map(Room::getNumber).orElse(42);
    }
}

class Room {
    Integer number;

    Optional getNumber() {
        return Optional.of(number);
    }
}


