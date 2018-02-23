import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

public class Sprite {
    double x;
    double y;
    Image image;
    double width;
    double height;

    public void setSpawn(double px, double py){
        x = px;
        y = py;
    }

    /*public boolean moveAcceptable(Character chara){
        if (chara.getNoPassZone().intersects(this.getNoPassZone())){
        }
    }
    */
    //Put gc in constructor so that when we create a character we can just pass the
    // default gc
    public void render (GraphicsContext gc){
        gc.drawImage(image, x, y);
    }

    public Rectangle2D getNoPassZone(){
        return new Rectangle2D(x,y, width, height);
    }
    public boolean collision (Sprite sprite){
        return sprite.getNoPassZone().intersects(this.getNoPassZone());
    }
}

