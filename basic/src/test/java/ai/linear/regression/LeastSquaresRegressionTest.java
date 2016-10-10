package ai.linear.regression;

import calculator.model.Point;
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
    }
}
