package calculator;

import ai.linear.regression.PointsGeneratorForTest;
import ai.model.Point;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MeanTest {

    @Test
    public void testTheMean1(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints1();
        ObservationContainer<Point> observationContainer = ObservationContainer.newContainer(points);
        Mean<Point> mean = MeanCalculator.calc(observationContainer);

        assertEquals(mean.value().x, 5.5);
        assertEquals(mean.value().y, 8.6);

    }

    @Test
    public void testTheMean2(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints12();
        ObservationContainer<Point> observationContainer = ObservationContainer.newContainer(points);
        Mean<Point> mean = MeanCalculator.calc(observationContainer);

        assertEquals(mean.value().x, 5.5);
        assertEquals(mean.value().y, 5.5);

    }
}
