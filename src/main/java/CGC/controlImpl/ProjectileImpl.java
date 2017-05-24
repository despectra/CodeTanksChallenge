package CGC.controlImpl;

import CGC.control.Projectile;

public class ProjectileImpl extends MovingUnitImpl implements Projectile {

    protected int damage;

    public ProjectileImpl(double radius, double x, double y, double angle, double speed, double speedAngle) {
        super(radius, x, y, angle, speed, speedAngle);
    }
}

