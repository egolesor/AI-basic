package calculator.statistic;

import calculator.model.Point;
import ai.model.ObservationContainer;
import calculator.model.StandardDeviation;
import calculator.model.Variance;

/**
 * To calculating the standard deviation from observations
 */
public class StandardDeviationCalculator {
    private StandardDeviationCalculator() {
    }

    public static StandardDeviation<Point> calc(ObservationContainer<Point> container) {
        Variance<Point> variance = VarianceCalculator.calc(container);

        Point standardDeviation = Point._2DNewInstanceOf(Math.sqrt(variance.value().xAxis()), Math.sqrt(variance.value().yAxis()));

        return new StandardDeviation<>(standardDeviation);
    }
}
