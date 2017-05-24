package CGC.controlImpl;

public class MyselfActions {
    private boolean isFiredBullet = false;
    private boolean isFiredHeavyBullet = false;
    private double changeSpeed = 0.0;
    private double changeAngle = 0.0;

    public MyselfActions() {
    }

    public MyselfActions(boolean isFiredBullet, boolean isFiredHeavyBullet, double changeSpeed, double changeAngle) {
        this.isFiredBullet = isFiredBullet;
        this.isFiredHeavyBullet = isFiredHeavyBullet;
        this.changeSpeed = changeSpeed;
        this.changeAngle = changeAngle;
    }

    public boolean isFiredBullet() {
        return isFiredBullet;
    }

    public void setFiredBullet(boolean firedBullet) {
        isFiredBullet = firedBullet;
    }

    public boolean isFiredHeavyBullet() {
        return isFiredHeavyBullet;
    }

    public void setFiredHeavyBullet(boolean firedHeavyBullet) {
        isFiredHeavyBullet = firedHeavyBullet;
    }

    public double getChangeSpeed() {
        return changeSpeed;
    }

    public void setChangeSpeed(double changeSpeed) {
        this.changeSpeed = changeSpeed;
    }

    public double getChangeAngle() {
        return changeAngle;
    }

    public void setChangeAngle(double changeAngle) {
        this.changeAngle = changeAngle;
    }
}
