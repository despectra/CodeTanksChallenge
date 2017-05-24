package visualizer;

import CGC.control.Enemy;
import CGC.control.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArenaCanvas extends JComponent {

    private final static int TANK_GREEN = 1;
    private final static int TANK_YELLOW = 2;
    private final static int TANK_BLUE = 3;
    private final static int TANK_RED = 4;
    private final static Color cols[] = {Color.GREEN, Color.YELLOW, Color.BLUE, Color.RED};

    private int height;
    private int width;

    private World world;
    private BufferedImage grassTexture;
    private BufferedImage bulletTexture;
    private Map<Integer, BufferedImage> tankTextures;

    public ArenaCanvas() {
        super();
        width = 1024;
        height = 768;
        InputStream[] textures = {
                getClass().getResourceAsStream("/tz.png"),
                getClass().getResourceAsStream("/tj.png"),
                getClass().getResourceAsStream("/ts.png"),
                getClass().getResourceAsStream("/tk.png")
        };
        try {
            tankTextures = new HashMap<>();
            tankTextures.put(TANK_GREEN, ImageIO.read(textures[TANK_GREEN - 1]));
            tankTextures.put(TANK_YELLOW, ImageIO.read(textures[TANK_YELLOW - 1]));
            tankTextures.put(TANK_BLUE, ImageIO.read(textures[TANK_BLUE - 1]));
            tankTextures.put(TANK_RED, ImageIO.read(textures[TANK_RED - 1]));

            grassTexture = ImageIO.read(getClass().getResourceAsStream("/grass.png"));
            bulletTexture = ImageIO.read(getClass().getResourceAsStream("/bullet.png"));
        } catch (Exception e) {

        }
    }

    private void drawTank(double x, double y, double angle, int tankColor, int hp, Graphics2D g) {
        BufferedImage tankTexture = tankTextures.get(tankColor);

        drawElement(x, y, angle, tankTexture, g);

        g.setPaint(Color.WHITE);
        g.drawRect((int)x, (int)y, 100, 5);
        g.setPaint(Color.RED);
        g.fillRect((int)x, (int)y, hp, 5);
    }

    private void drawTexture(Graphics2D g) {
        Rectangle r = new Rectangle(0,0, grassTexture.getWidth(), grassTexture.getHeight());
        g.setPaint(new TexturePaint(grassTexture, r));
        Rectangle rect = new Rectangle(0, 0, width, height);
        g.fill(rect);
    }

    private void drawCredentials(Graphics2D g) {
        Color col = new Color(255, 255, 255, 50);
        g.setPaint(col);
        int x = 10;
        int y = 10;
        g.fillRect(x, y, 400, 100);

        Font font = new Font ("Sans-Serif", Font.BOLD, 16);
        g.setFont(font);
        ArrayList<Enemy> enemies = world.getEnemies();

        for (int i = 0; i < enemies.size(); i++) {
            g.setPaint(cols[enemies.get(i).getId() - 1]);
            g.drawString( enemies.get(i).getName(), x + 10, y + 20 + i*25);
            g.drawString( String.valueOf(enemies.get(i).getHealthPoints()), x + 350, y + 20 + i*25);
            g.drawString( String.valueOf(enemies.get(i).getScorePoints()), x + 375, y + 20 + i*25);
        }
    }

    private void drawElement(double x, double y, double angle, BufferedImage texture, Graphics2D g) {
        int w = texture.getWidth();
        int h = texture.getHeight();
        AffineTransform tx = AffineTransform.getRotateInstance(-angle, w / 2, h / 2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g.drawImage(op.filter(texture, null), (int)x - w / 2, ((int)y - h / 2), this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

        //Отрисовка тексуры боя
        drawTexture(g2d);

        //Отрисовка танков
        for (Enemy e: world.getEnemies()) {
            drawTank(e.getX(), height - e.getY(), e.getAngle(), e.getId(), e.getHealthPoints(), g2d);
        }

        drawCredentials(g2d);

        //Отрисовка номера тика
        g2d.setPaint(Color.WHITE);
        Font font = new Font ("Sans-Serif", Font.BOLD, 24);
        g2d.setFont(font);
        g2d.drawString(String.valueOf(world.getTick()), width - 100, height - 50);

        super.repaint();
    }

    public void setWorld(World world) {
        this.world = world;
    }

}
