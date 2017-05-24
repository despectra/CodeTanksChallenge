package CGC.controlImpl;

import java.util.ArrayList;

import CGC.control.*;

public class WorldImpl implements World {
    private static final double width = 1024;
    private static final double height = 728;

    private int tick;
    private ArrayList<Enemy> enemies;
    private ArrayList<Bonus> bonuses;
    private ArrayList<Bullet> bullets;
    private ArrayList<HeavyBullet> heavyBullets;

    @Override
    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }

    @Override
    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    @Override
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public ArrayList<HeavyBullet> getHeavyBullets() {
        return heavyBullets;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public int getTick() {
        return tick;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

}
