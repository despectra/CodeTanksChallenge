package CGC.control;

public interface Unit {
    double getAngle();
    double getAngleTo(double x, double y);
    double getAngleTo(Unit unit);
    double getDistanceTo(double x, double y);
    double getDistanceTo(Unit unit);
    double getRadius();
    double getX();
    double getY();
}
