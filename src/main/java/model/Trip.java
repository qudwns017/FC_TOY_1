package src.main.java.model;

import java.util.Date;
import java.util.List;

public class Trip {
    private int trip_id;
    private String trip_name;
    private Date start_date;
    private Date end_date;
    private List<Itinerary> itineraries;

    public Trip() {
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void addItineraries(Itinerary itinerary) {
        this.itineraries.add(itinerary);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "trip_id=" + trip_id +
                ", trip_name='" + trip_name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", itineraries=" + itineraries +
                '}';
    }
}
