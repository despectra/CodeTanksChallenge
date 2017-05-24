package CGC.controlImpl;

import CGC.control.Enemy;

public class EnemyImpl extends MovingUnitImpl implements Enemy {

    public static final int RADIUS = 35;

    public EnemyImpl(double x, double y, double angle, double speed, double speedAngle) {
        super(RADIUS, x, y, angle, speed, speedAngle);
        name = "Tank";
    }

    private int id;
    protected String name;
    private int hp;
    private int heavyBulletsCount;
    private int sp;

    @Override
    public int getId(){
        return id;
    }

    @Override
    public int getHeavyBullets() {
        return heavyBulletsCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return hp;
    }

    @Override
    public int getScorePoints() {
        return sp;
    }

    public void increaseHealthPoints(int hp) {
        this.hp += hp;
    }

    public void increaseScorePoints(int sp) {
        this.sp += sp;
    }



    public int getHeavyBulletsCount() {
        return heavyBulletsCount;
    }

    public void setHealthPoints(int hp) {
        this.hp = hp;
    }

    public void setHeavyBulletsCount(int heavyBulletsCount) {
        this.heavyBulletsCount = heavyBulletsCount;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setScorePoints(int sp) {
        this.sp = sp;
    }


}
