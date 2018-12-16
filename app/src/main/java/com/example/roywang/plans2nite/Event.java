package com.example.roywang.plans2nite;

public class Event {
    String name;
    String date;
    String location;
    String plantype;
    String details;

    public Event(String name, String date, String location, String plantype, String details) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.plantype = plantype;
        this.details = details;
    }

    public Event() {
    }
}
