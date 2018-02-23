import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;


public class Character extends Sprite {

    public Character(String imgFile){
        x = 0;
        y = 0;
        image = new Image(imgFile);
        height = image.getHeight();
        width = image.getWidth();
    }

    public void moveU() {
        y = y - 5;
    }

    public void moveD() {
        y = y + 5;
    }

    public void moveR() {
        x = x + 5;
    }

    public void moveL() {
        x = x - 5;
    }
}
