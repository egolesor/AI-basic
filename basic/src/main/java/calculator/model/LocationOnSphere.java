package calculator.model;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationOnSphere that = (LocationOnSphere) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        return Double.compare(that.longitude, longitude) == 0;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "" +
                "latitude=" + latitude +
                ", longitude=" + longitude;

    }
}
