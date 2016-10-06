package calculator;

import ai.linear.regression.PointsGeneratorForTest;
import ai.model.Point;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CorrelationCoefficientCalculatorTest {

    @Test
    public void test1(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints12();
        ObservationContainer<Point> observationContainer = ObservationContainer.newContainer(points);

        CorrelationCoefficient correlationCoefficient = CorrelationCoefficientCalculator.calc(observationContainer);

        assertEquals(correlationCoefficient.value(), 1d);
    }

    @Test
    public void test2(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints1();
        ObservationContainer<Point> observationContainer = ObservationContainer.newContainer(points);

        CorrelationCoefficient correlationCoefficient = CorrelationCoefficientCalculator.calc(observationContainer);
        System.out.println(correlationCoefficient.value());
        assertTrue(correlationCoefficient.value() < 0.7 && correlationCoefficient.value() > 0.6093936);
    }

}
