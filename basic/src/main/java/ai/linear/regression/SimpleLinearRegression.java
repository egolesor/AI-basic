package ai.linear.regression;

import ai.model.Line;
import ai.model.Point;
import jdk.nashorn.internal.objects.annotations.Constructor;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.LinkedList;
import java.util.List;

/**
 * The simple linear regression is a simple counting for the best
 * fit of line for observations
 * <b>the class is not thread safe yet</b>
 */
class SimpleLinearRegression implements LinearRegression {

    private List<Point> observations = new LinkedList<>();

    private Line resultLine;

    /**
     * real time counting the mean point after adding new observation
     */
    private Point meanPoint;

    /**
     * Stores the sum of all x of observations and the same for y
     */
    private double sumX, sumY;
    /**
     * Used to count the number of observations
     */
    private long observationNumber;

    SimpleLinearRegression() {
        meanPoint = Point._2DNewInstanceOf(0,0);
    }

    @Override
    public void count() {
        double slope = countSlope();
        double intercept = countIntercept(slope);

        resultLine=new Line(slope, intercept);
    }

    @Override
    public LinearRegression addObservation(final Point point){
        sumX += point.x;
        sumY += point.y;
        observationNumber++;
        meanPoint=Point._2DNewInstanceOf(sumX/observationNumber, sumY/observationNumber);
        observations.add(point);
        return this;
    }
    @Override
    public LinearRegression addObservations(List<Point> points){
        this.observations.addAll(points);
        points.forEach(this::addObservation);
        return this;
    }

    @Override
    public Line result() {
        if(resultLine==null){
            throw new InvalidStateException("The result is not set yet");
        }
        return resultLine;
    }

    /**
     * The formula is line F(x)=slope*x + intercept
     * the method calculate the slope
     * @return - the calculated slope for the current status of the linear regression
     */
    protected double countSlope(){
        // sum(x - mean(x))*(y - mean(y))
        double sum_0;

        // sum(x - mean(x))^2
        double sum_1;

        sum_0=sum_1=0;
        double temp;
        for (Point point: observations){
            temp = (point.x - meanPoint.x);
            sum_0 += ( point.y - meanPoint.y ) * temp;
            sum_1 += Math.pow(temp, 2);
        }
        return sum_0/sum_1;
    }

    /**
     * The formula is line F(x)=slope*x + intercept
     * the method calculate the slope
     * @param slope - the calculated slope earlier by the method {@link #countSlope()}
     * @return - the calculated intercept for the current status depend on the slope as parameter
     * of the linear regression
     */
    protected double countIntercept(double slope){
        return meanPoint.y-(slope*meanPoint.x);
    }
}
