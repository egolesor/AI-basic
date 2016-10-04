package ai.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Point {

    public final double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point _2DNewInstanceOf(double x, double y){
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return x+" , " + y;
    }
}
