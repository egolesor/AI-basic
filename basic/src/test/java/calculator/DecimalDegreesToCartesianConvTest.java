package calculator;

import ai.model.LocationOnSphere;
import ai.model.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DecimalDegreesToCartesianConvTest {

    @DataProvider
    protected Object[][] coordinationConvData(){
        return new Object[][]{
                {DecimalDegreesToCartesianConv.conv(new LocationOnSphere(0,0)), Point._2DNewInstanceOf(0,0)},
                {DecimalDegreesToCartesianConv.conv(new LocationOnSphere(10,0)), Point._2DNewInstanceOf(0,10)},
                {DecimalDegreesToCartesianConv.conv(new LocationOnSphere(-10,0)), Point._2DNewInstanceOf(0,-10)},
                {DecimalDegreesToCartesianConv.conv(new LocationOnSphere(-91,0)), Point._2DNewInstanceOf(0,89)},
                {DecimalDegreesToCartesianConv.conv(new LocationOnSphere(91,0)), Point._2DNewInstanceOf(0,-89)},
                {DecimalDegreesToCartesianConv.conv(new LocationOnSphere(91,190)), Point._2DNewInstanceOf(-170,-89)}
        };
    }

    @Test(dataProvider = "coordinationConvData")
    public void testConverter(Point excepted, Point current){
        assertEquals(excepted.x, current.x);
        assertEquals(excepted.y, current.y);
    }

}
