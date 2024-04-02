package src.main.java.model;

import java.util.Date;

public class Itinerary {
    private int itinerary_id;
    private String departure_place;
    private String destination;
    private Date departure_time;
    private Date arrival_time;
    private Date check_in;
    private Date check_out;

    public Itinerary(int itinerary_id, String departure_place, String destination, Date departure_time,
                     Date arrival_time) {
        this.itinerary_id = itinerary_id;
        this.departure_place = departure_place;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }

    public int getItinerary_id() {
        return itinerary_id;
    }

    public void setItinerary_id(int itinerary_id) {
        this.itinerary_id = itinerary_id;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }
}
