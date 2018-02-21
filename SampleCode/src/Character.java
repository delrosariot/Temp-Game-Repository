import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;


public class Character {
    private double x;
    private double y;
    private Image Froak;
    private double width;
    private double height;

    public Character(){
        x = 0;
        y = 0;
        Froak = new Image("Froakie.png");
        height = Froak.getHeight();
        width = Froak.getWidth();
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
        x = x -1;
    }

    //Put gc in constructor so that when we create a character we can just pass the
    // default gc
    public void render (GraphicsContext gc){
        gc.drawImage(Froak, x, y);
    }

    public Rectangle2D getNoPassZone(){
        return new Rectangle2D(x,y, width, height);
    }
    public boolean collision (Character chara){
        return chara.getNoPassZone().intersects(this.getNoPassZone());
    }
}
