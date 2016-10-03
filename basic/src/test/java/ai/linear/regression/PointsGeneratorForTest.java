package ai.linear.regression;

import ai.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsGeneratorForTest {

    public static List<Point> getListOfPoints(int numberOfPoints){

        List<Point> points = new ArrayList<>(numberOfPoints);
        points.add(Point._2DNewInstanceOf(1, 8));
        points.add(Point._2DNewInstanceOf(2, 9));
        points.add(Point._2DNewInstanceOf(3, 7));
        points.add(Point._2DNewInstanceOf(4, 6));
        points.add(Point._2DNewInstanceOf(5, 8));
        points.add(Point._2DNewInstanceOf(6, 10));
        points.add(Point._2DNewInstanceOf(7, 9));
        points.add(Point._2DNewInstanceOf(8, 8));
        points.add(Point._2DNewInstanceOf(9, 10));
        points.add(Point._2DNewInstanceOf(10, 11));
        return points;
    }

    public static Point getRandomPoint(){
        Random random = new Random();
        return Point._2DNewInstanceOf(random.nextInt(100), random.nextInt(100));
    }
}
