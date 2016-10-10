package calculator;

import ai.model.LocationOnSphere;
import ai.model.Point;

public class DecimalDegreesToCartesianConv {

    private DecimalDegreesToCartesianConv() {
    }

    public static Point conv(LocationOnSphere locationOnSphere){
        double xAsis = locationOnSphere.longitude()%360;
        double yAsis = locationOnSphere.latitude()%180;
        boolean xNegative = xAsis<0 ? true:false;
        boolean yNegative = yAsis<0 ? true:false;
        if(Math.abs(xAsis)>180){
            xAsis = 360 - Math.abs(xAsis);
            if (!xNegative){
                xAsis = -xAsis;
            }
        }

        if(Math.abs(yAsis)>90){
            yAsis = 180 - Math.abs(yAsis);
            if(!yNegative){
                yAsis = -yAsis;
            }
        }

        return Point._2DNewInstanceOf(xAsis, yAsis);
    }
}
