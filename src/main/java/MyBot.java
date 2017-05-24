import CGC.control.Myself;
import CGC.control.World;

public class MyBot extends Bot {
    @Override
    public void Init(Myself me) {
        me.setName("Simple Bot");
    }

    @Override
    public void Move(World world, Myself me) {
        double x = world.getWidth()/2;
        double y = world.getHeight()/2;
        me.turnTo(x, y);
        me.speedUp(2E18);
    }
}
