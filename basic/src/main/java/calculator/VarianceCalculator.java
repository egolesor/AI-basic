package calculator;

import ai.model.Point;

/**
 * To calculate the variance from observations
 */
public class VarianceCalculator {
    private VarianceCalculator() {
    }

    public static Variance<Point> calc(ObservationContainer<Point> container) {

        Point meanPoint = MeanCalculator.calc(container).value();
        double distanceXToMean = 0;
        double distanceYToMean = 0;
        for (Point point : container.listObservation()){
            distanceXToMean += Math.pow(point.x - meanPoint.x, 2);
            distanceYToMean += Math.pow(point.y - meanPoint.y, 2);
        }
        distanceXToMean = distanceXToMean/container.size();
        distanceYToMean = distanceYToMean/container.size();
        return new Variance<>(Point._2DNewInstanceOf(distanceXToMean, distanceYToMean));
    }
}
