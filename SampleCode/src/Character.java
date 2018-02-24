import javafx.scene.image.Image;

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
