package CGC.controlImpl;

import CGC.control.Bonus;

public class BonusImpl extends UnitImpl implements Bonus{

    public static final int LIFE_TIME = 50;
    public static final int RADIUS = 20;

    private int remainingLifeTime;

    public BonusImpl(double x, double y, int remainingLifeTime) {
        super(RADIUS, x, y, Math.PI/2);
        this.remainingLifeTime = remainingLifeTime;
    }

    @Override
    public int getRemainingLifeTime() {
        return remainingLifeTime;
    }
}
