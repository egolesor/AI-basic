package calculator;

import ai.model.Point;

public class CartesianUtil {

    private CartesianUtil() {
    }

    public static Double distance(Point point1, Point point2){
        return Math.sqrt(
                Math.pow(point2.x-point1.x,2) +
                Math.pow(point2.y-point1.y,2) +
                Math.pow(point2.z-point1.z,2)
        );
    }
}
