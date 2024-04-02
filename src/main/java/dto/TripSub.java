package src.main.java.dto;

public class TripSub {
    private int trip_id;
    private String trip_name;

    public TripSub() {
    }

    public TripSub(int trip_id, String trip_name) {
        this.trip_id = trip_id;
        this.trip_name = trip_name;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public String getTrip_name() {
        return trip_name;
    }

    @Override
    public String toString() {
        return "TripSub{" +
                "trip_id=" + trip_id +
                ", trip_name='" + trip_name + '\'' +
                '}';
    }
}
