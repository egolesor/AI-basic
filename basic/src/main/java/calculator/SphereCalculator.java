package calculator;

import ai.model.LocationOnSphere;
import ai.model.Sphere;

public class SphereCalculator {

    private final double PI;

    public SphereCalculator() {
        this.PI = Math.PI;
    }

    public SphereCalculator(final double PI) {
        this.PI = PI;
    }

    public double surface(Sphere sphere){
        return 4*PI*sphere.radious()*sphere.radious();
    }

    public double volume(Sphere sphere){
        return surface(sphere)/3;
    }

    public double simpleDistance2Point(final LocationOnSphere point1,
                                       final LocationOnSphere point2,
                                       final Sphere sphere){

        double deltaLongitude = (point2.longitude() - point1.longitude());
        double deltaLatitude = point2.latitude() - point1.latitude();
        double temp = deltaLongitude * Math.cos((point1.latitude()+point2.latitude())/2);
        return sphere.radious() * Math.sqrt(deltaLatitude*deltaLatitude + temp*temp);
    }
}
