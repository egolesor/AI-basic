package ai.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class LocationOnSphere {
    private final double latitude;
    private final double longitude;
    public  LocationOnSphere(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "" +
                "latitude=" + latitude +
                ", longitude=" + longitude;

    }
}
