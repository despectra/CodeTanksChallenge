package CGC.control;

import java.util.ArrayList;

public interface World {
    ArrayList<Bonus> getBonuses();
    ArrayList<Bullet> getBullets();
    ArrayList<Enemy> getEnemies();
    ArrayList<HeavyBullet> getHeavyBullets();
    double getHeight();
    int getTick();
    double getWidth();
}
