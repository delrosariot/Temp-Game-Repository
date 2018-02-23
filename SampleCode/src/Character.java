import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;


public class Character {
    private double x;
    private double y;
    private Image Front;
    private double width;
    private double height;
    private GraphicsContext gc;

    public Character(GraphicsContext Graphics){
        x = 0;
        y = 0;
        Front = new Image("SpriteT_01.png");
        height = Front.getHeight();
        width = Front.getWidth();
        gc = Graphics;
    }

    public void setSpawn(double px, double py){
        x = px;
        y = py;
    }

    public void moveU(){
        y = y - 1;
    }
    public void moveD(){
        y = y + 1;
    }

    public void moveR(){
        x = x + 1;
    }

    public void moveL(){
        x = x - 1;
    }

    public void render (){
        gc.drawImage(Front, x, y);
    }

    public Rectangle2D getNoPassZone(){
        return new Rectangle2D(x,y, width, height);
    }
    public boolean collision (Character chara){
        return chara.getNoPassZone().intersects(this.getNoPassZone());
    }
}
