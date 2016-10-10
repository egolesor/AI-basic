package calculator.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Point {

    public final double xAxis, yAxis, zAxis;

    private Point(double xAxis, double yAxis, double zAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis=zAxis;
    }

    public static Point _2DNewInstanceOf(double x, double y){
        return new Point(x, y, 0);
    }
    public static Point _3DNewInstanceOf(double x, double y, double z){
        return new Point(x, y, z);
    }

    @Override
    public String toString() {
        return xAxis+" , " + yAxis + " , " + zAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return (xAxis==point.xAxis()) &&(yAxis==point.yAxis()) &&(zAxis==point.zAxis());

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public double yAxis() {
        return yAxis;
    }

    public double xAxis() {
        return xAxis;
    }

    public double zAxis() {
        return zAxis;
    }
}
