package CGC.controlImpl;

import CGC.control.Unit;
import CGC.utils.Vector2D;

public class UnitImpl implements Unit {
    private double radius;
    private double x;
    private double y;
    private double angle;
    private Vector2D angleVector;

    public UnitImpl(double radius, double x, double y, double angle) {
        this.radius = radius;
        setX(x);
        setY(y);
        setAngle(angle);
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public double getAngleTo(double x, double y) {
        Vector2D vectorToXY = new Vector2D(getX(), getY(), x, y);
        double angleValue = angleVector.angleBetween(vectorToXY);
        if (angleVector.vectorProduct(vectorToXY) < 0) return -angleValue;
        else return angleValue;

    }

    @Override
    public double getAngleTo(Unit unit) {
        return getAngleTo(unit.getX(), unit.getY());
    }

    @Override
    public double getDistanceTo(double x, double y) {
        return Math.sqrt((x - this.x)*(x - this.x) + (y - this.y)*(y - this.y));
    }

    @Override
    public double getDistanceTo(Unit unit) {
        return getDistanceTo(unit.getX(), unit.getY());
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public Vector2D getAngleVector() {
        return angleVector;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        angleVector = new Vector2D(Math.cos(angle), Math.sin(angle));
    }

    public void increaseAngle(double angle) {
        this.angle += angle;
        if (this.angle > 2 * Math.PI) this.angle = this.angle - 2*Math.PI;
        if (this.angle < 0) this.angle = 2 * Math.PI + this.angle;
        angleVector = new Vector2D(Math.cos(angle), Math.sin(angle));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void changeX(double x) {
        this.x += x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void changeY(double y) {
        this.y += y;
    }
}
