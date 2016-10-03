package ai.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Line {

    private String toStringVar;

    public final double alpha0;
    public final double alpha1;

    public Line(double alpha0, double alpha1) {
        this.alpha0 = alpha0;
        this.alpha1 = alpha1;
    }

    private String initToString(){
        return new StringBuilder()
                .append("y=")
                .append(alpha0)
                .append("x+")
                .append(alpha1).toString();
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
