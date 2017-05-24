package CGC.control;

public interface Myself extends Enemy {
    void fireBullet();
    void fireHeavyBullet();
    void setName(String name);
    void speedUp(double dSpeed);
    void turn(double angle);
    void turnTo(double x, double y);
    void turnTo(Unit unit);

}
