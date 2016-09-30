package ai.linear.regression;

import ai.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class PointsGeneratorForTest {

    public static Stream<Point> getStreamOfPoints(int numberOfPoints){

        List<Point> points = new ArrayList<Point>(numberOfPoints);
        for(int i=0; i<numberOfPoints; i++){
            points.add(getRandomPoint());
        }
        return points.stream();
    }

    public static Point getRandomPoint(){
        Random random = new Random();
        return Point._2DNewInstanceOf(random.nextInt(), random.nextInt());
    }
}
