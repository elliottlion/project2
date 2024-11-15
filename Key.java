public class Key extends Block {
    public Key(double x, double y) {
    super(x,y, "assets/key.png");
    }
    public boolean isTouching( GameObject player ) {
    return super.isTouchingX(player, 0.75) && this.isTouchingY(player);
    }
    public boolean isTouchingY( GameObject player ) {
    return this.getY() <= player.getY() + player.getHeight()
    && player.getY() <= this.getY() + this.getHeight()/2 ;
    }
    }
