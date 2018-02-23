
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;
import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Game extends Application {
    ArrayList<String> moves = new ArrayList<String>();
    //ADD two arraylists: collidables and interactables (from map)
    //ArrayList maps = MapMaker.create(); ( //Map map1 = new Map(ImageUrl, ListOfCollidables, ListOfInteractables);)


    public void start(Stage theStage){
        //Title of window
        theStage.setTitle("Let's Play!");

        Group root = new Group();
        //Borderpane organizes the layout of the window
        BorderPane borderpane = new BorderPane();
        borderpane.setPrefSize(500, 500);
        //Scene is the window. It takes a node.
        Scene theScene = new Scene(borderpane);
        theStage.setScene(theScene);
        //Create organizational pane within the center of borderpane.
        StackPane centerDisplay = new StackPane();
        //Actual area you draw into.
        Canvas canvas = new Canvas( 320, 320 );
        //Set-style sets the background image/color (THIS WILL PROBABLY BE INSIDE OF MAP OBJECT )
        centerDisplay.setStyle("-fx-background-image: url(map.png);");
        centerDisplay.getChildren().add(canvas);

        root.getChildren().add(centerDisplay);

        borderpane.setCenter(root);


        //This is how we paint on the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Character hero = new Character(gc);
        Character enemy = new Character(gc);


        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                    String code = event.getCode().toString();
                    if (!moves.contains(code)) {
                        moves.add(code);

                    }
                }

        });
        theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                String code = event.getCode().toString();
                moves.remove(code);
            }
        });

        new AnimationTimer(){
            public void handle(long currentNanoTime){
                gc.clearRect(0, 0, 500, 500);
                enemy.setSpawn(110, 50);
                enemy.render();

                if (moves.contains("LEFT")) {
                        hero.moveL();
                    if(hero.collision(enemy)) {
                        hero.moveR();

                    }
                }
                if (moves.contains("RIGHT")){
                    hero.moveR();
                    if(hero.collision(enemy)) {
                        hero.moveL();
                    }
                }
                if (moves.contains("UP")){
                    hero.moveU();
                    if(hero.collision(enemy)) {
                        hero.moveD();

                    }
                }
                if (moves.contains("DOWN")){
                    hero.moveD();
                    if(hero.collision(enemy)) {
                        hero.moveU();
                    }
                }
                    hero.render();



            }
        }.start();

        theStage.show();

    }
}

