package calculator;

import ai.model.LocationOnSphere;
import ai.model.Point;
import ai.model.Sphere;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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
    protected Object[][] sphericalToCartesianData(){
        return new Object[][]{
                {
                        SphereCalculator.cartesianPoint(
                                new LocationOnSphere(0,0),
                                new Sphere(1)),
                        Point._3DNewInstanceOf(1,0,0)
                },
                {
                        SphereCalculator.cartesianPoint(
                                new LocationOnSphere(0,Math.toRadians(90)),
                                new Sphere(1)),
                        Point._3DNewInstanceOf(0,1,0)
                },
                {
                        SphereCalculator.cartesianPoint(
                                new LocationOnSphere(Math.toRadians(90), 0),
                                new Sphere(5)),
                        Point._3DNewInstanceOf(0,0,5)
                },
                {
                        SphereCalculator.cartesianPoint(
                                new LocationOnSphere(Math.toRadians(90), Math.toRadians(90)),
                                new Sphere(14)),
                        Point._3DNewInstanceOf(0, 0, 14)
                }
        };
    }

    @DataProvider
    protected Object[][] angle2VectorData(){
        return new Object[][]{
                {
                        SphereCalculator.angle2Point(
                        Point._3DNewInstanceOf(0,0,6378),
                        Point._3DNewInstanceOf(0,0,6378)
                ),0
                },
        };
    }

    @DataProvider
    protected Object[][] distanceDataProvider(){
        return new Object[][]{
                {SphereCalculator.simpleDistance2Point(
                        new LocationOnSphere(0, 0),
                        new LocationOnSphere(0, 0),
                        new Sphere(1)), 0
                },
                {SphereCalculator.simpleDistance2Point(
                        new LocationOnSphere(Math.toRadians(10), Math.toRadians(10)),
                        new LocationOnSphere(Math.toRadians(20), Math.toRadians(10)),
                        new Sphere(6378)), 1113.1
                },
                {SphereCalculator.simpleDistance2Point(
                        new LocationOnSphere(Math.toRadians(0), Math.toRadians(0)),
                        new LocationOnSphere(Math.toRadians(0), Math.toRadians(40)),
                        new Sphere(6378)), 4452.6
                },
                {SphereCalculator.simpleDistance2Point(
                        new LocationOnSphere(Math.toRadians(20), Math.toRadians(44)),
                        new LocationOnSphere(Math.toRadians(10), Math.toRadians(40)),
                        new Sphere(6378)), 1193.1
                }
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

    @Test(dataProvider = "sphericalToCartesianData")
    public void testCartesianConvector(Point counted, Point excepted){
        assertEquals(counted, excepted);
    }

    @Test(dataProvider = "angle2VectorData")
    public void testAngle(double angle, double expected){
        assertEquals(angle, expected);
    }

    @Test(dataProvider = "distanceDataProvider")
    public void testDistance(double countedSurface, double exceptedSurface){
        System.out.println(countedSurface);
        assertTrue(countedSurface <exceptedSurface+0.1 && countedSurface > exceptedSurface-0.1);
    }


}
