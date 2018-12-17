package com.example.roywang.plans2nite;

public class Event {
    public String name;
    public String date;
    public String location;
    public String plantype;
    public String details;
    public String register;
    public String favorite;
    public String user;

    public Event(String name, String date, String location, String plantype, String details, String register, String favorite, String user )
    {
        this.name = name;
        this.date = date;
        this.location = location;
        this.plantype = plantype;
        this.details = details;
        this.register=register;
        this.favorite=favorite;
        this.user=user;
    }

    public Event() {
    }
}
