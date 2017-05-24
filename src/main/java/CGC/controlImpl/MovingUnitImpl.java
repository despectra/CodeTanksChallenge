package CGC.controlImpl;

import CGC.control.MovingUnit;
import CGC.utils.Vector2D;

public class MovingUnitImpl extends UnitImpl implements MovingUnit {
    
    public MovingUnitImpl(double radius, double x, double y, double angle, double speed, double speedAngle) {
        super(radius, x, y, angle);
        inertiaVector = new Vector2D(0, 0);
    }

    public static final double MAX_SPEED = 10.0;
    private double speed;
    private Vector2D inertiaVector;

    @Override
    public double getHorizontalSpeed() {
        return getSpeedVector().getX();
    }

    @Override
    public double getMaxSpeed() {
        return MAX_SPEED;
    }

    @Override
    public double getSpeed() {
        return getSpeedVector().getLength();
    }

    @Override
    public double getSpeedAngle() {
        double polarAngle = getSpeedVector().getPolarAngle();
        if (polarAngle < 0) return 2 * Math.PI + polarAngle;
        else return polarAngle;
    }

    @Override
    public double getVerticalSpeed() {
        return getSpeedVector().getY();
    }

    public Vector2D getInertiaVector() {
        return inertiaVector;
    }

    public void increaseSpeed(double speed) {

        this.speed += speed;
        this.speed = Math.min(Math.max(0, this.speed), MAX_SPEED);
    }

    public void setSpeed(double speed) {

        this.speed = Math.min(Math.max(0, speed), MAX_SPEED);
    }

    public Vector2D getSpeedVector() {
        Vector2D speedVector = new Vector2D(speed * Math.cos(getAngle()), speed * Math.sin(getAngle()));
        speedVector.addVector(inertiaVector);
        return speedVector;
    }

    public void setInertiaVector(Vector2D inertiaVector) {
        this.inertiaVector = inertiaVector;
    }


}
