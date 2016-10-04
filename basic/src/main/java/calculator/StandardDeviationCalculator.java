package calculator;

import ai.model.Point;

public class StandardDeviationCalculator {
    public static StandardDeviation<Point> calc(ObservationContainer<Point> container) {
        Variance<Point> variance = VarianceCalculator.calc(container);

        Point standardDeviation = Point._2DNewInstanceOf(Math.sqrt(variance.value().x), Math.sqrt(variance.value().y));

        return new StandardDeviation<>(standardDeviation);
    }
}
