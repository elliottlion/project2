public class Exit extends Block {
    public Exit(double x, double y) {
    super(x,y,"assets/tile-exit.png");
    }
    public boolean isTouching( GameObject player ) {
    return super.isTouchingX(player,0.25) && super.isTouchingY(player, 0.25);
    }
    }
