public class CeilingHazard extends Block {
    public CeilingHazard(double x, double y) {
    super(x,y, "assets/tile-spikes-ceiling.png");
    }
    public boolean isTouching( GameObject player ) {
    return super.isTouchingX(player, 0.75) && this.isTouchingY(player);
    }
    public boolean isTouchingY( GameObject player ) {
    return this.getY() <= player.getY() + player.getHeight()
    && player.getY() <= this.getY() + this.getHeight()/2 ;
    }
    }