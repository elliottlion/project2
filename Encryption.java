public class Encryption extends Block {
    public Encryption(double x, double y) {
    super(x,y, "assets/Encryption.png");
    }
    public boolean isTouching( GameObject player ) {
    return super.isTouchingX(player, 0.75) && this.isTouchingY(player);
    }
    public boolean isTouchingY( GameObject player ) {
    return this.getY() <= player.getY() + player.getHeight()
    && player.getY() <= this.getY() + this.getHeight()/2 ;
    }
    }
