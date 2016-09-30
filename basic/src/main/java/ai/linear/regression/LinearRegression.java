package ai.linear.regression;

import ai.model.Point;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class LinearRegression {
    final Stream<Point> pointStream;

    public LinearRegression(Stream<Point> streamOfPoints) {
        pointStream = streamOfPoints;
    }

    public void count() {

    }
}
