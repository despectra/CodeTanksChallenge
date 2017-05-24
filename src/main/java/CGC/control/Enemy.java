package CGC.control;

public interface Enemy extends MovingUnit {
    int getHeavyBullets();
    int getId();
    String getName();
    int getHealthPoints();
    int getScorePoints();
}
