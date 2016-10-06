package ai.linear.regression;

import ai.model.Line;
import ai.model.Point;
import calculator.ObservationContainer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class LeastSquaresRegressionTest {

    @DataProvider
    protected Object[][] testTimeData(){
        List<Point> points1 = PointsGeneratorForTest.getListOfPoints1();
        List<Point> points2 = PointsGeneratorForTest.getListOfPoints2();
        List<Point> points3 = PointsGeneratorForTest.getListOfPoints3();
        return new Object[][]{
                {LinearRegression.newLeastSquaresRegression().addObservations(points1), 10},
                {LinearRegression.newLeastSquaresRegression().addObservations(points2), 100},
                {LinearRegression.newLeastSquaresRegression().addObservations(points3), 50},

        };
    }

    @Test(dataProvider = "testTimeData")
    public void testForBasicObservations(LeastSquaresRegression linearRegression, long timeExcepted){
        long spent = System.currentTimeMillis();
        linearRegression.count();
        spent = System.currentTimeMillis()-spent;
        assertTrue(spent<=timeExcepted);
        System.out.println(linearRegression.result());
    }
}
