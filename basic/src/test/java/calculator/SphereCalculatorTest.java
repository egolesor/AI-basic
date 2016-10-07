package calculator;

import ai.model.LocationOnSphere;
import ai.model.Sphere;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SphereCalculatorTest {

    @DataProvider
    protected Object[][] volumeDataProvider(){
        return new Object[][]{
                {SphereCalculator.volume(new Sphere(10)),4188.7902047864},
                {SphereCalculator.volume(new Sphere(5)),523.5987755983},
                {SphereCalculator.volume(new Sphere(8)),2144.6605848506},
                {SphereCalculator.volume(new Sphere(0)),0}
        };
    }
    @DataProvider
    protected Object[][] surfaceDataProvider(){
        return new Object[][]{
                {SphereCalculator.surface(new Sphere(10)),1256.6370614359},
                {SphereCalculator.surface(new Sphere(5)) ,314.159265359},
                {SphereCalculator.surface(new Sphere(8)) ,804.247719319},
                {SphereCalculator.surface(new Sphere(0)) ,0}
        };
    }

    @DataProvider
    protected Object[][] distanceDataProvider(){
        LocationOnSphere location1 = new LocationOnSphere(0, 0);
        LocationOnSphere location2 = new LocationOnSphere(0,0);
        return new Object[][]{
                {SphereCalculator.simpleDistance2Point(location1, location2, new Sphere(6371)), 0}
        };
    }

    @Test(dataProvider = "volumeDataProvider")
    public void testVolume(double countedVolume, double exceptedVolume){
        assertTrue(countedVolume<exceptedVolume+0.01 && countedVolume>exceptedVolume-0.01);
    }

    @Test(dataProvider = "surfaceDataProvider")
    public void testSurface(double countedSurface, double exceptedSurface){
        assertTrue(countedSurface<exceptedSurface+0.01 && countedSurface>exceptedSurface-0.01);
    }

    @Test(dataProvider = "distanceDataProvider")
    public void testDistance(double countedSurface, double exceptedSurface){
        assertTrue(countedSurface<exceptedSurface+0.01 && countedSurface>exceptedSurface-0.01);
    }


}
