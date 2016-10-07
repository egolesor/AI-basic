package calculator;

import ai.model.LocationOnSphere;
import ai.model.Point;
import ai.model.Sphere;

/**
 * earth perimeter = 40_075_000
 * earth radius = 6_371; //meter
 */
public class SphereCalculator {
    private final static double meterPerDegree = 111319.444444444;

    private SphereCalculator() {
    }

    public static double surface(Sphere sphere){
        return 4*Math.PI*Math.pow(sphere.radious(), 2);
    }

    public static double volume(Sphere sphere){
        return 4*Math.PI*Math.pow(sphere.radious(), 3)/3;
    }

    public static double simpleDistance2Point(final LocationOnSphere location1,
                                       final LocationOnSphere location2,
                                       final Sphere sphere){

        Point point1 = cartesianPoint(location1, sphere);
        Point point2 = cartesianPoint(location2, sphere);
        double normalDistance = CartesianUtil.distance(point1, point2);

        final double radius2 = Math.pow(sphere.radious(), 2);

        double temp1 = Math.sqrt(4*radius2 - Math.pow(normalDistance, 2));
        double temp2 = normalDistance/(2*radius2);
        double temp = Math.sin(temp1*temp2);
        return sphere.radious()/temp;
    }

    public static double simpleDistance2PointOnEarth(LocationOnSphere location1, LocationOnSphere location2){
        double deltaX = (location2.longitude()-location1.longitude()) * meterPerDegree;
        double deltaY = (location2.latitude()-location1.latitude()) * meterPerDegree;

        return Math.sqrt(Math.pow(deltaX, 2)*Math.pow(deltaY, 2));
    }

    public static Point cartesianPoint(LocationOnSphere locationOnSphere, Sphere sphere){
        double xAxis = sphere.radious()*Math.cos(locationOnSphere.latitude())*Math.cos(locationOnSphere.longitude());
        double yAxis = sphere.radious()*Math.cos(locationOnSphere.latitude())*Math.sin(locationOnSphere.longitude());
        double zAxis = sphere.radious()*Math.sin(locationOnSphere.latitude());

        return Point._3DNewInstanceOf(xAxis, yAxis, zAxis);
    }

}
