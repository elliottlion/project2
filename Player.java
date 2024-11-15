import java.util.ArrayList;
public class Player extends GameObject{
    private Physics physics;
    private boolean isJumping;
    private Pose currentPose;
    public Player(double x, double y) 
    {
        super( x*Block.SIZE, y*Block.SIZE, Block.SIZE, Block.SIZE, "assets/link-down.png");
        this.physics = new Physics(4);
        this.isJumping = false;
        this.currentPose = Pose.RIGHT; //ANIMATION POSES
        super.setImage( currentPose.getImage() );
    }
    public void move() {
        double dx = this.getX() + physics.getVelocityX();
        double dy = this.getY() + physics.getVelocityY();
        super.move(dx,dy);
    }
    public void jump()
    {
        if(this.isJumping == false){
            physics.jump();
            this.isJumping=true;
        }
    }
    public void moveLeft() 
    {
        physics.moveLeft();
        this.currentPose = Pose.LEFT;
    }
    public void moveRight()
    {
        physics.moveRight();
        this.currentPose = Pose.RIGHT;
    }
    public void isJumping(boolean isJumping) {
        this.isJumping = isJumping;
        }

    public void update(ArrayList<Block> blocks) 
    {
        physics.update(blocks, this);
        this.move();
    }
    public void draw() {
        super.setImage( currentPose.getImage() );
        super.draw();
        }


}
