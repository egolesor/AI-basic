package calculator.geometry;

import calculator.model.LocationOnSphere;
import calculator.model.Point;
import calculator.model.Sphere;

/**
 * earth perimeter = 40_075_000
 * earth radius = 6_371; //K-meter
 */
public class SphereCalculator {

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
        if(location1.equals(location2)){
            return 0;
        }
        Point point1 = cartesianPoint(location1, sphere);
        Point point2 = cartesianPoint(location2, sphere);

        return angle2Point(point1, point2, sphere)*sphere.radius();
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

        //TODO delete this shit ASAP!!!
        xAxis = xAxis>0.0000000001 ? xAxis : 0;
        yAxis = yAxis>0.0000000001 ? yAxis : 0;
        zAxis = zAxis>0.0000000001 ? zAxis : 0;
        return Point._3DNewInstanceOf(xAxis, yAxis, zAxis);
    }


    public static double angle2Point(Point point1, Point point2) {
        return Math.acos(
                (point1.xAxis()*point2.xAxis()+point1.yAxis()*point2.yAxis()+point1.zAxis()*point2.zAxis())
                        /(Math.pow(6378, 2))
        );
    }
    public static double angle2Point(Point point1, Point point2, Sphere sphere) {
        return Math.acos(
                (point1.xAxis()*point2.xAxis()+point1.yAxis()*point2.yAxis()+point1.zAxis()*point2.zAxis())/(Math.pow(sphere.radius(), 2))
        );
    }
}
