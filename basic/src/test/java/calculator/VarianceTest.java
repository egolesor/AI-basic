package calculator;

import ai.linear.regression.PointsGeneratorForTest;
import ai.model.Point;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class VarianceTest {

    @Test
    public void StandardDeviation1(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints12();
        ObservationContainer<Point> container = ObservationContainer.newContainer(points);

        Variance<Point> variance = VarianceCalculator.calc(container);

        assertEquals(variance.value().x, 8.25);
        assertEquals(variance.value().y, 8.25);
    }
    @Test
    public void StandardDeviation3(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints1();
        ObservationContainer<Point> container = ObservationContainer.newContainer(points);

        Variance<Point> variance = VarianceCalculator.calc(container);

        assertEquals(variance.value().x, 8.25);
        assertEquals(variance.value().y, 2.04);
    }
}
