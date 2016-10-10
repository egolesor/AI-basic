package ai.model;

public class Sphere {

    private final double radious;

    public Sphere(double radious) {

        this.radious=radious;
    }

    public double radius() {
        return radious;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radious=" + radious +
                '}';
    }
}
