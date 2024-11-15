
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class World 
{   public World() 
    {
    //get all map data and save it for later
    
    try {
        File worldFile = new File("worldData.txt");
    Scanner input = new Scanner(worldFile);
    int count = input.nextInt();
    levels = new String[count][][];
    for (int lvl=0; lvl<count; lvl++) {
    int rows = input.nextInt();
    int cols = input.nextInt();
    input.nextLine();
    setLevel(lvl, rows, cols, input);
    }
    
        
    } catch (FileNotFoundException e) {
        System.out.println("filenotfound error");
        e.printStackTrace();}
    }
    
    private String[][][] levels;
    
        private void setLevel(int lvl, int rows, int cols, Scanner input) 
        {
            levels[lvl] = new String[rows][cols];
            input.useDelimiter("");
            for (int y=0; y < rows; y++) 
            {
            for (int x=0; x < cols; x++) 
                {
                String tile = input.next();
                levels[lvl][y][x] = tile;
                //System.out.print(tile);
                }
            input.nextLine();
            //System.out.print("\n");
            }
            input.reset();
        }

            public String[][] getLevel(int level) 
            {
                return levels[level];
            }
            public int getLength() {
                return this.levels.length;
                }
}
