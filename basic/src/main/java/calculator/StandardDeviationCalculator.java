package calculator;

import ai.model.Point;

/**
 * To calculating the standard deviation from observations
 */
public class StandardDeviationCalculator {
    private StandardDeviationCalculator() {
    }

    public static StandardDeviation<Point> calc(ObservationContainer<Point> container) {
        Variance<Point> variance = VarianceCalculator.calc(container);

        Point standardDeviation = Point._2DNewInstanceOf(Math.sqrt(variance.value().x), Math.sqrt(variance.value().y));

        return new StandardDeviation<>(standardDeviation);
    }
}
