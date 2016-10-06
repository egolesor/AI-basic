package ai.model;

public class LocationOnSphere {
    private final double latitude;
    private final double longitude;
    public LocationOnSphere(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }
}
