package ai.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Point {

    public final double x, y, z;

    private Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z=z;
    }

    public static Point _2DNewInstanceOf(double x, double y){
        return new Point(x, y, 0);
    }
    public static Point _3DNewInstanceOf(double x, double y, double z){
        return new Point(x, y, z);
    }

    @Override
    public String toString() {
        return x+" , " + y + " , " + z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return (x==point.x) &&(y==point.y) &&(z==point.z);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
