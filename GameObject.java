
public class GameObject 
{
    private double x;
    private double y;
    private int width;
    private int height;
    private String image;
    public GameObject(double x, double y, int width, int height, String image) 
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }
    public void draw() 
    {
            double screenX = x + width/2;
            double screenY = y + height/2;
            StdDraw.picture(screenX, screenY, image, width, height);
    }
    public double getX() 
    {
        return this.x;
    }
    public double getY() 
    {
        return this.y;
    }
    public int getWidth() 
    {
        return this.width;
    }
    public int getHeight() 
    {
        return this.height;
    }
    public void move(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }
    public void setImage(String image) {
        this.image = image;
        }
        


    
}
