package ai.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Line {

    /**
     * lazy to string initialization
     */
    private String toStringVar;

    public final double slope;
    public final double intercept;

    public Line(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    private String initToString(){
        return new StringBuilder()
                .append("y=")
                .append(slope)
                .append("x+")
                .append(intercept).toString();
    }

    @Override
    public String toString() {
        // lazy to String
        if(toStringVar==null){
            toStringVar = initToString();
        }
        return toStringVar;
    }
}
