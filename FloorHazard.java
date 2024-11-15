public class FloorHazard extends Block {
    public FloorHazard(double x, double y) 
    {
    super(x,y, "assets/tile-spikes-floor.png");
    }
    public boolean isTouching( GameObject player ) {
    return super.isTouchingX(player, 0.75) && this.isTouchingY(player);
    }
    public boolean isTouchingY( GameObject player ) {
    return this.getY()+this.getHeight()/2 <= player.getY() + player.getHeight()
    && player.getY() <= this.getY() + this.getHeight();
    }
    }