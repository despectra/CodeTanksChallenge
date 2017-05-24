package CGC.controlImpl;

import CGC.control.Bullet;

public class BulletImp extends ProjectileImpl implements Bullet {
    public static final int RADIUS = 10;

    public BulletImp(double radius, double x, double y, double angle, double speed, double speedAngle) {
        super(RADIUS, x, y, angle, speed, speedAngle);
        damage = 5;
    }
}
