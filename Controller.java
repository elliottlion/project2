public class Controller 
{
    private Player player;
    public Controller(Player player){
        this.player = player;
    }
    public void keyboard()
    {
        //Jumping
        if ( (StdDraw.isKeyPressed(38) || StdDraw.isKeyPressed(32) ) ) 
        {
        player.jump();
        }
        // player holding left
        if (StdDraw.isKeyPressed(37) ) {
            player.moveLeft();
        }
        // player holding right
        if (StdDraw.isKeyPressed(39) ) {
        player.moveRight();
        
        }
    }
    public void update()
    {
        keyboard();
    }

}
