package ai.linear.regression;

import ai.model.Line;
import ai.model.Point;

import java.util.LinkedList;
import java.util.List;

public class SimpleLinearRegression implements LinearRegression {

    protected List<Point> points = new LinkedList<>();
    protected Line line;
    private Point meanPoint;
    private double sumX, sumY;
    private long observationNumber;

    public SimpleLinearRegression(List<Point> points) {
        this.points = points;
        meanPoint = Point._2DNewInstanceOf(0,0);
        points.forEach(this::addObservation);
    }

    @Override
    public void count() {
        double slope = countSlope();
        double intercept = countIntercept(slope);

        line=new Line(slope, intercept);
    }

    protected double countSlope(){
        // (x - mean(x))*(y - mean(y))
        double sum_0;

        // (x - mean(x))^2
        double sum_1;

        sum_0=sum_1=0;
        double temp;
        for (Point point:points){
            temp = (point.x - meanPoint.x);
            sum_0 += ( point.y - meanPoint.y ) * temp;
            sum_1 += Math.pow(temp, 2);
        }
        return sum_0/sum_1;
    }

    @Override
    public void addObservation(Point point){
        sumX += point.x;
        sumY += point.y;
        observationNumber++;
        meanPoint=Point._2DNewInstanceOf(sumX/observationNumber, sumY/observationNumber);
    }

    protected double countIntercept(double slope){
        return meanPoint.y-(slope*meanPoint.x);
    }
}
