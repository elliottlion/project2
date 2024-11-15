public class Game
{
    private boolean isOver;
    private World world;
    private int level;
    private Scene scene;
    private Controller controller;
    private boolean menu;
    public Game(){
        
        

       
        startGame();
    }
    /*private void showMenu() {
        int width = 800;
        int height = 600;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(height, 0);
        StdDraw.enableDoubleBuffering();*/

       /*  while (menu) {
            StdDraw.clear();
            StdDraw.picture(width, height, "assets/backgroundMenu.png");
            StdDraw.show();

            // Check for key press
            if (StdDraw.isKeyPressed(65)) {
                menu = false;
            }
        }
    }*/
    private void startGame()
    {
        this.isOver = false;
        this.level = 0;
        world = new World();
        String[][] map = world.getLevel(level);
        this.scene = new Scene(map);
        Player player = scene.getPlayer();
        this.controller = new Controller(player);
    }
    public void update()
    {
        controller.update();
        scene.update();
        this.isOver = scene.isPlayerDead();
        if ( scene.getExit().isTouching( scene.getPlayer() ) ) {
            this.level++;
            if (this.level < world.getLength() ) {
            String[][] map = world.getLevel(this.level);
            this.scene = new Scene(map);
            this.controller = new Controller(this.scene.getPlayer() );
            }
            else {
            PlaySound soundPlayer = new PlaySound(); soundPlayer.playSound("youWin.wav");
            this.isOver = true;
            }
            }
    }
    public void render()
    {
        scene.draw();
        StdDraw.setVisible(true );
    }
    public static void main(String[] args) 
    {
        Game game = new Game();
        while (game.isOver == false) 
        {
        game.update();
        game.render();
        if (game.isOver) { 
            
            game.startGame(); // Restart the game immediately }
        }
        
    }}
    public boolean checkMenu(){
        return menu;
    }
   
    
        
}