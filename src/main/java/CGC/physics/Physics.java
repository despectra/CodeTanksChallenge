package CGC.physics;

import CGC.control.*;
import CGC.controlImpl.EnemyImpl;
import CGC.controlImpl.MovingUnitImpl;
import CGC.controlImpl.WorldImpl;
import CGC.utils.Vector2D;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Physics {

    private final static double EPS = 1E-10;

    public static final double MAX_ROTATION_ANGLE = 0.03;
    public static final double MAX_SPEED = MovingUnitImpl.MAX_SPEED;
    public static final double MAX_ACCELERATION = 0.05;
    public static final double MAX_WIDTH = 1024.0;
    public static final double MAX_HEIGHT = 768.0;


    private static double constrainDouble(double value, double minval, double maxval) {
        return min(max(minval, value), maxval);
    }

    public static void calculateNextLocation(MovingUnitImpl movingUnit, double changeSpeed, double changeAngle) {
        changeSpeed = constrainDouble(changeSpeed, -MAX_ACCELERATION, MAX_ACCELERATION);
        changeAngle = constrainDouble(changeAngle, -MAX_ROTATION_ANGLE, MAX_ROTATION_ANGLE);
        movingUnit.increaseSpeed(changeSpeed);
        movingUnit.increaseAngle(changeAngle);
        movingUnit.changeX(movingUnit.getHorizontalSpeed());
        movingUnit.changeY(movingUnit.getVerticalSpeed());
    }

    public static boolean isCollision(Unit unit1, Unit unit2) {
        return abs(unit1.getDistanceTo(unit2) - unit1.getRadius() - unit2.getRadius()) < EPS;
    }

    public static boolean isCollisionToWall(MovingUnit movingUnit) {
        double x = movingUnit.getX();
        double y = movingUnit.getY();
        double r = movingUnit.getRadius();
        return (x - r < 0 || x + r > MAX_WIDTH || y - r < 0 || y + r > MAX_HEIGHT);
    }

    public static void calculateCollisionToWall(Enemy enemy) {
        Vector2D speedVector = ((EnemyImpl)enemy).getSpeedVector();
        Vector2D inertiaVector = new Vector2D(-speedVector.getY()/speedVector.getLength(),
                speedVector.getX()/speedVector.getLength());
        ((EnemyImpl)enemy).setInertiaVector(inertiaVector);
    }

    public static void calculateEnemiesCollision(Enemy enemy1, Enemy enemy2) {
        /*EnemyImpl first = (EnemyImpl)enemy1;
        EnemyImpl second = (EnemyImpl)enemy2;
        double firstNextX = first.getX() + first.getHorizontalSpeed();
        double firstNextY = first.getY() + first.getVerticalSpeed();
        double secondNextX = second.getX() + second.getHorizontalSpeed();
        double secondNextY = second.getY() + second.getVerticalSpeed();
        double nextDistance = sqrt((firstNextX - secondNextX) * (firstNextX - secondNextX)
                + (firstNextY - secondNextY) * (firstNextY - secondNextY));
        double currDistance = first.getDistanceTo(second);
        if (nextDistance > currDistance) return;
        double firstSpeedAngle = first.getSpeedAngle();
        double secondSpeedAngle = second.getSpeedAngle();
        double firstSpeed = first.getSpeed();
        double secondSpeed = second.getSpeed();
        first.setSpeedAngle(secondSpeedAngle);
        second.setSpeedAngle(firstSpeedAngle);
        first.setSpeed(secondSpeed);
        second.setSpeed(firstSpeed);*/
    }

    public static boolean nextWorld(WorldImpl world, int maxTick) {
        int tick = world.getTick();
        if (tick >= maxTick) return false;
        world.setTick(tick + 1);
        for (Enemy e:world.getEnemies()) {
            calculateNextLocation((MovingUnitImpl)e, 2, 1);
            if (isCollisionToWall(e)) calculateCollisionToWall(e);
        }
        return true;
    }

}
