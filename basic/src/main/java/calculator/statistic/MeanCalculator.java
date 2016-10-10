package calculator.statistic;

import calculator.model.Point;
import ai.model.ObservationContainer;
import calculator.model.Mean;

public class MeanCalculator {
    public static Mean<Point> calc(ObservationContainer<Point> container) {
        double sumX, sumY;
        sumX = sumY = 0;
        for (Point point : container.listObservation()) {
            sumX += point.xAxis();
            sumY += point.yAxis();
        }
        sumX /= container.size();
        sumY /= container.size();
        return new Mean<>(Point._2DNewInstanceOf(sumX, sumY));
    }
}
