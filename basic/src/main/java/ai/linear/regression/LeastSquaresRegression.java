package ai.linear.regression;

import calculator.model.Line;
import calculator.model.Point;
import calculator.statistic.CorrelationCoefficientCalculator;
import ai.model.ObservationContainer;
import calculator.statistic.StandardDeviationCalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LeastSquaresRegression implements LinearRegression {

    private double sumX;
    private double sumY;
    private Optional<Line> line;
    private List<Point> observations = new LinkedList<>();
    @Override
    public void count() {

        final double slope = countSlope();
        final double intercept = countIntercept(slope, observations.get(0));

        line = Optional.of(new Line(slope, intercept));

    }

    @Override
    public LinearRegression addObservation(Point point) {
        sumX+= point.xAxis;
        sumY+= point.yAxis;
        observations.add(point);
        return this;
    }

    @Override
    public LinearRegression addObservations(List<Point> points) {
        points.forEach(this::addObservation);
        return this;
    }

    @Override
    public Line result() {
        return line.get();
    }

    @Override
    public void addObservationContainer(ObservationContainer<Point> container) {
        addObservations(container.listObservation());
    }

    double countSlope(){
        ObservationContainer<Point> observationContainer = ObservationContainer.newContainer(observations);
        Point deviationPoint = StandardDeviationCalculator
                .calc(observationContainer).value();

        double correlation = CorrelationCoefficientCalculator
                .calc(observationContainer).value();

        return correlation*(deviationPoint.yAxis/deviationPoint.xAxis);
    }
    /**
     * The formula is line F(x)=slope*x + intercept
     * the method calculate the slope
     * @param slope - the calculated slope earlier by the method {@link #countSlope()}
     * @return - the calculated intercept for the current status depend on the slope as parameter
     * of the linear regression
     */
    protected double countIntercept(double slope, Point anyObservation){
        return anyObservation.yAxis-(slope*anyObservation.xAxis);
    }
}
