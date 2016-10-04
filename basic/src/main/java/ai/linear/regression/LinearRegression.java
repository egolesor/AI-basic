package ai.linear.regression;

import ai.model.Line;
import ai.model.Point;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.List;

public interface LinearRegression {

    /**
     * Static factory to get a new instance of {@link SimpleLinearRegression}
     * @return
     */
    @Constructor
    static SimpleLinearRegression newSimpleLinear(){
        return new SimpleLinearRegression();
    }

    /**
     * After adding all observations the method count is able to calculate
     * the result of linear regression
     */
    void count();

    /**
     * To add a single observation
     * @param point - obsetvation
     * @return - the LinearRegression object ( not {@link #count()} yet ) after adding the new observation
     */
    LinearRegression addObservation(Point point);

    /**
     * The same as {@link #addObservation(Point)} but makes it possible to add a list
     * of observations
     * @param points - the list of observations
     * @return the actual abject after adding the abservation
     */
    LinearRegression addObservations(List<Point> points);

    /**
     *
     * @return - the result after calling the method {@link #count()}
     */
    Line result();
}
