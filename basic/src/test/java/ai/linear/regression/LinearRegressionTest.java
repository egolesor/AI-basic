package ai.linear.regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LinearRegressionTest {

    @DataProvider
    protected Object[][] testTimeData(){
        return new Object[][]{
                {new SimpleLinearRegression(PointsGeneratorForTest.getListOfPoints(20)), 100},
        };
    }

    @Test(dataProvider = "testTimeData")
    public void testTheResults(SimpleLinearRegression linearRegression, long timeExcepted){
        long spent = System.currentTimeMillis();
        linearRegression.count();
        spent = System.currentTimeMillis()-spent;
        assertTrue(spent<=timeExcepted);
        System.out.println(linearRegression.line);
        linearRegression.points.forEach(System.out::println);
    }

}
