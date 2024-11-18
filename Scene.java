import java.util.ArrayList;
public class Scene 
{
        private int rows;
        private int cols;
        private GameObject background;
        private GameObject menuBackground;
        private GameObject[] endBackgrounds;
        private ArrayList<Block> blocks;
        private ArrayList<Block> monsters;
        private Player player;
        private Exit exit;
        private boolean playerHasKey = false;
        
        
        private ArrayList<Key> key;
        private ArrayList<Encryption> encryption;
        public Scene( String[][] map ) 
        {
            this.rows = map.length;
            this.cols = map[0].length;

            int width = cols * 32;
            int height = rows * 32;
            this.background = new GameObject(0, 0, width, height, "assets/background.png");
            this.menuBackground = new GameObject(0, 0, width, height, "assets/backgroundMenu.png");
            this.endBackgrounds = new GameObject[]{
                new GameObject(0, 0, width, height, "assets/endBackground0.png"),
                new GameObject(0, 0, width, height, "assets/endBackground1.png"),
                new GameObject(0, 0, width, height, "assets/endBackground2.png"),
                new GameObject(0, 0, width, height, "assets/endBackground3.png"),
                new GameObject(0, 0, width, height, "assets/endBackground4.png")};
            this.blocks = new ArrayList<Block>();
            this.monsters = new ArrayList<Block>();
            this.key = new ArrayList<>();
            this.encryption = new ArrayList<>();

            for (int y=0; y<rows; y++) 
            {
                for (int x=0; x<cols; x++) 
                {
                    String tile = map[y][x];
                    setTile( x, y, tile);
                }
            }

            StdDraw.setCanvasSize(width, height);
            StdDraw.setXscale(0.0,width);
            StdDraw.setYscale(height,0.0);
            StdDraw.enableDoubleBuffering();
            
        }
        public void showMenu() {
            PlaySound looPlaySound = new PlaySound();
            looPlaySound.playloop("Cyberpunk.wav");
            boolean menu = true;
            while (menu) {
                menuBackground.draw();
                StdDraw.show();
                if (StdDraw.isKeyPressed(65)) { // 'A' key
                    menu = false;
                }
                else if (StdDraw.isKeyPressed(69)){
                    System.exit(0);
                }
            }//multiple defacto vetos requiring minorities consent
        }
        public void draw()
        
        {   
            
            background.draw();
            for ( Block block : this.blocks) 
            {
                block.draw();
            }
            for ( Block spike : this.monsters) 
            {
                spike.draw();
            }
            playerHasKey = hasKey();
            for (Block key : this.key)
            if(playerHasKey == false){
                key.draw();
            }
            
            for (Block encryption :this.encryption)
            {
                encryption.draw();}
            
            player.draw();
            exit.draw();
            StdDraw.show();
            
            
        }
        private void setTile(int x, int y, String tile) 
        {
            if (tile.equals("#") )
            {
            Block block = new Block(x, y);
            this.blocks.add(block);
            }
            else if (tile.equals("@") ) 
            {
                this.player = new Player(x, y);
            }
            else if (tile.equals("A") ) {
                FloorHazard spike = new FloorHazard(x,y);
                this.monsters.add(spike);
            }
            else if (tile.equals("V") ) {
                CeilingHazard spike = new CeilingHazard(x,y);
                this.monsters.add(spike);
            }
            else if (tile.equals("!") ) 
            {
                this.exit = new Exit(x,y);
            }
            else if (tile.equals("k"))
            {
                Key key = new Key(x, y) ;
                this.key.add(key);
            }
            else if (tile.equals("e")){
               
                if (!Decrypt()){
                Encryption encryption = new Encryption(x, y);
                this.encryption.add(encryption);
                }
            }
            
        }
        public boolean isPlayerDead() {
            for ( Block hazard : monsters ) {
            if ( hazard.isTouching(player) ) {
                PlaySound soundPlayer = new PlaySound(); 
                soundPlayer.playSound("longScream.wav");
            return true;
            }
            }
            return false;
            }
        public boolean Decrypt()
        {
            for (Block encryption: encryption){
                if (encryption.isTouching(player)&&playerHasKey){
                    return true;
                }
                
            }return false;
        }
        public boolean hasKey()
        {
            for (Block key : key){
                if (key.isTouching(player)){
                    return true;
                }
                else if (playerHasKey == true){
                    return true;
                }
                
            }return false;
        }
        public Player getPlayer() 
        {
            return this.player;
        }
        public Exit getExit() {
            return this.exit;
            }
        public void update() 
        {
            player.update(blocks);
            encryption.removeIf(enc -> enc.isTouching(player) && playerHasKey);
            
        }
        public void showEndBackgrounds() {
            for (GameObject endBackground : endBackgrounds) {
                endBackground.draw();
                StdDraw.show();
                try {
                    Thread.sleep(2500);
                                } 
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

}

        

