package calculator.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Sphere {

    private final double radius;

    public Sphere(double radius) {

        this.radius = radius;
    }

    public double radius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                '}';
    }
}
