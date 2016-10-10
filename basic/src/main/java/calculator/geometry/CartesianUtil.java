package calculator.geometry;

import calculator.model.Point;

public class CartesianUtil {

    private CartesianUtil() {
    }

    public static Double distanceIn2Point(Point point1, Point point2){
        return Math.sqrt(
                Math.pow(point2.xAxis()-point1.xAxis(),2) +
                Math.pow(point2.yAxis()-point1.yAxis(),2) +
                Math.pow(point2.zAxis()-point1.zAxis(),2)
        );
    }
}
