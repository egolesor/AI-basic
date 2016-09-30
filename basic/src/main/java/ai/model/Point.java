package ai.model;

public class Point {

    public final long x, y;

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Point _2DNewInstanceOf(int x, int y){
        return new Point(x, y);
    }

}
