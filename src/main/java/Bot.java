import CGC.control.Myself;
import CGC.control.World;

public abstract class Bot{

    abstract public void Init(Myself me);
    abstract public void Move(World world, Myself me);

}
