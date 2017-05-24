package visualizer;

import CGC.control.World;

import javax.swing.*;

public class Visualizer extends JFrame {

    ArenaCanvas arenaCanvas;

    public Visualizer() {
        super("CGC Tanks: v 0.1 - Visualizer");
        setSize(1024, 768);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        arenaCanvas = new ArenaCanvas();
        add(arenaCanvas);
    }

    public void drawWorld(World world) {
        arenaCanvas.setWorld(world);
        arenaCanvas.repaint();
    }

}
