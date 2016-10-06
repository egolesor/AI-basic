package calculator;

import ai.model.Point;

/**
 * To calculate the correlation of all observations
 */
public class CorrelationCoefficientCalculator {

    private CorrelationCoefficientCalculator() {
    }

    public static CorrelationCoefficient calc(ObservationContainer<Point> observationContainer) {

        Point meanPoint = MeanCalculator.calc(observationContainer).value();
        double calc1=0;
        double calc2=0;
        double calc3=0;
        double tempX;
        double tempY;

        for(Point point : observationContainer.listObservation()){
            tempX = point.x - meanPoint.x;
            tempY = point.y - meanPoint.y;
            calc1+=tempX*tempY;
            calc2+= Math.pow(tempX,2);
            calc3+= Math.pow(tempY,2);
        }

        calc2 = Math.sqrt(calc2*calc3);

        return new CorrelationCoefficient(calc1/calc2);
    }
}
