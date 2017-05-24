package CGC.controlImpl;

import CGC.control.HeavyBullet;

public class HeavyBulletImpl extends ProjectileImpl implements HeavyBullet {
    public static final int RADIUS = 15;
    public HeavyBulletImpl(double x, double y, double angle, double speed, double speedAngle) {
        super(RADIUS, x, y, angle, speed, speedAngle);
        damage = 15;
    }
}
