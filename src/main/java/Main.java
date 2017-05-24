import CGC.control.Enemy;
import CGC.control.Myself;
import CGC.control.World;
import CGC.controlImpl.EnemyImpl;
import CGC.controlImpl.MyselfImpl;
import CGC.controlImpl.WorldImpl;
import CGC.physics.Physics;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        WorldImpl world = new WorldImpl();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(new EnemyImpl(256, 546, 7*Math.PI/4, 0, -Math.PI/4));
        enemies.add(new EnemyImpl(256, 182, Math.PI/4, 0, Math.PI/2));
        enemies.add(new EnemyImpl(768, 182, 3*Math.PI/4, 0, Math.PI/2));
        enemies.add(new EnemyImpl(768, 546, 5*Math.PI/4, 0, Math.PI/2));
        for (int i = 0; i < enemies.size(); i++) {
            ((EnemyImpl)enemies.get(i)).setId(i+1);
            ((EnemyImpl)enemies.get(i)).setHealthPoints(i*15 + 10);
        }

        world.setEnemies(enemies);

        Visualizer visualizer = new Visualizer();
        visualizer.setVisible(true);

        visualizer.drawWorld(world);
        while (Physics.nextWorld(world, 500)){
            visualizer.drawWorld(world);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
