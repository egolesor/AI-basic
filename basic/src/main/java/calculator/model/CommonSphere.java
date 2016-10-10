package calculator.model;

public enum CommonSphere {
    EARTH(6378);
    public final Sphere theSphere;
    CommonSphere(double radius) {
        theSphere = new Sphere(radius);
    }

    public Sphere sphere(){
        return theSphere;
    }
}
