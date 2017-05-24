package CGC.controlImpl;

import CGC.control.Enemy;
import CGC.control.Myself;
import CGC.control.Unit;

public class MyselfImpl extends EnemyImpl implements Myself{

    private MyselfActions actions = new MyselfActions();

    public MyselfImpl(double x, double y, double angle, double speed, double speedAngle) {
        super(x, y, angle, speed, speedAngle);
    }

    public MyselfImpl(EnemyImpl enemy) {
        super(enemy.getX(), enemy.getY(), enemy.getAngle(), enemy.getSpeed(), enemy.getSpeedAngle());
        setId(enemy.getId());
        setName(enemy.getName());
        setHealthPoints(enemy.getHealthPoints());
        setScorePoints(enemy.getScorePoints());
        setHeavyBulletsCount(enemy.getHeavyBulletsCount());
    }

    @Override
    public void fireBullet() {
        actions.setFiredBullet(true);
    }

    @Override
    public void fireHeavyBullet() {
        if (getHeavyBullets() > 0) {
            actions.setFiredHeavyBullet(true);
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void speedUp(double dSpeed) {
        actions.setChangeSpeed(dSpeed);
    }

    @Override
    public void turn(double angle) {
        actions.setChangeAngle(angle);
    }

    @Override
    public void turnTo(double x, double y) {
        //TO-DO: Calculate angle and turn(angle)
    }

    @Override
    public void turnTo(Unit unit) {
        turnTo(unit.getX(), unit.getY());
    }

    public MyselfActions getMyselfActions() {
        return actions;
    }
}
