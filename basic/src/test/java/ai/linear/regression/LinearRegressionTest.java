package ai.linear.regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LinearRegressionTest {

    @DataProvider
    protected Object[][] testTimeData(){
        return new Object[][]{
                {new LinearRegression(PointsGeneratorForTest.getStreamOfPoints(100)), 1},
                {new LinearRegression(PointsGeneratorForTest.getStreamOfPoints(100)), 1},
                {new LinearRegression(PointsGeneratorForTest.getStreamOfPoints(100)), 1},
                {new LinearRegression(PointsGeneratorForTest.getStreamOfPoints(100)), 1},
                {new LinearRegression(PointsGeneratorForTest.getStreamOfPoints(100)), 1},
        };
    }

    @Test(dataProvider = "testTimeData")
    public void testTheResults(LinearRegression linearRegression, long timeExcepted){
        long spent = System.currentTimeMillis();
        linearRegression.count();
        spent = System.currentTimeMillis()-spent;
        assertTrue(spent<=timeExcepted);
    }

}
