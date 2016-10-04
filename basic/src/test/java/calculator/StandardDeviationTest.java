package calculator;

import ai.linear.regression.PointsGeneratorForTest;
import ai.model.Point;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class StandardDeviationTest {

    @Test
    public void standardDeviationTest1(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints12();
        ObservationContainer<Point> container = ObservationContainer.newContainer(points);

        StandardDeviation<Point> standardDeviation = StandardDeviationCalculator.calc(container);

        assertTrue(standardDeviation.value().x> 2.87 & standardDeviation.value().x < 2.88);
        assertTrue(standardDeviation.value().y> 2.87 & standardDeviation.value().y < 2.88);
    }

    @Test
    public void standardDeviationTest2(){
        List<Point> points = PointsGeneratorForTest.getListOfPoints1();
        ObservationContainer<Point> container = ObservationContainer.newContainer(points);

        StandardDeviation<Point> standardDeviation = StandardDeviationCalculator.calc(container);

        assertTrue(standardDeviation.value().x< 2.8722813233 & standardDeviation.value().x > 2.87228132);
        assertTrue(standardDeviation.value().y> 1.42 & standardDeviation.value().y < 1.43);
    }

}
