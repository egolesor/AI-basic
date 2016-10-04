package calculator;

import ai.model.Point;

public class MeanCalculator {
    public static Mean<Point> calc(ObservationContainer<Point> container) {
        double sumX, sumY;
        sumX = sumY = 0;
        for (Point point : container.listObservation()) {
            sumX += point.x;
            sumY += point.y;
        }
        sumX /= container.size();
        sumY /= container.size();
        return new Mean<>(Point._2DNewInstanceOf(sumX, sumY));
    }
}
