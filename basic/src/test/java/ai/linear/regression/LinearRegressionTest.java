package ai.linear.regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LinearRegressionTest {

    @DataProvider
    protected Object[][] testTimeData(){
        return new Object[][]{
                {LinearRegression.newSimpleLinear().addObservations(PointsGeneratorForTest.getListOfPoints1()), 10},
                {LinearRegression.newSimpleLinear().addObservations(PointsGeneratorForTest.getListOfPoints2()), 100},
                {LinearRegression.newSimpleLinear().addObservations(PointsGeneratorForTest.getListOfPoints3()), 50},

        };
    }

    @Test(dataProvider = "testTimeData")
    public void testTheResults(SimpleLinearRegression linearRegression, long timeExcepted){
        long spent = System.currentTimeMillis();
        linearRegression.count();
        spent = System.currentTimeMillis()-spent;
        assertTrue(spent<=timeExcepted);
        System.out.println(linearRegression.result());
    }

}
