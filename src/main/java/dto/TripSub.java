package src.main.java.dto;

public class TripSub {
    private int tripId;
    private String tripName;

    public TripSub() {
    }

    public TripSub(int tripId, String tripName) {
        this.tripId = tripId;
        this.tripName = tripName;
    }

    public int getTripId() {
        return tripId;
    }

    public String getTripName() {
        return tripName;
    }

    @Override
    public String toString() {
        return "TripSub{" +
                "trip_id=" + tripId +
                ", trip_name='" + tripName + '\'' +
                '}';
    }
}
