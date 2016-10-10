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
        return 4*Math.PI*Math.pow(sphere.radius(), 2);
    }

    public static double volume(Sphere sphere){
        return 4*Math.PI*Math.pow(sphere.radius(), 3)/3;
    }

    public static double simpleDistance2Point(final LocationOnSphere location1,
                                       final LocationOnSphere location2,
                                       final Sphere sphere){
        Point point1 = cartesianPoint(location1, sphere);
        Point point2 = cartesianPoint(location2, sphere);
        double normalDistance = CartesianUtil.distance(point1, point2);
        if(normalDistance==0){
            return 0;
        }
        //TODO to make more exact calculation
        return angle2Point(point1, point2, sphere)*sphere.radius();
    }

    public static double simpleDistance2PointOnEarth(LocationOnSphere location1, LocationOnSphere location2){
        double deltaX = (location2.longitude()-location1.longitude()) * meterPerDegree;
        double deltaY = (location2.latitude()-location1.latitude()) * meterPerDegree;

        return Math.sqrt(Math.pow(deltaX, 2)*Math.pow(deltaY, 2));
    }

    public static Point cartesianPoint(LocationOnSphere locationOnSphere, Sphere sphere){
        double xAxis = sphere.radius()*
                Math.cos(locationOnSphere.latitude())*
                Math.cos(locationOnSphere.longitude());

        double yAxis = sphere.radius()*
                Math.cos(locationOnSphere.latitude())*
                Math.sin(locationOnSphere.longitude());

        double zAxis = sphere.radius()*
                Math.sin(locationOnSphere.latitude());

        xAxis = xAxis>0.0000000001 ? xAxis : 0;
        yAxis = yAxis>0.0000000001 ? yAxis : 0;
        zAxis = zAxis>0.0000000001 ? zAxis : 0;
        return Point._3DNewInstanceOf(xAxis, yAxis, zAxis);
    }


    public static double angle2Point(Point point1, Point point2) {
        return Math.acos(
                (point1.x*point2.x+point1.y*point2.y+point1.z*point2.z)/(Math.pow(6378, 2))
        );
    }
    public static double angle2Point(Point point1, Point point2, Sphere sphere) {
        return Math.acos(
                (point1.x*point2.x+point1.y*point2.y+point1.z*point2.z)/(Math.pow(sphere.radius(), 2))
        );
    }
}
