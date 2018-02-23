/*
//Sets up a frame (a.k.a. a window)
import javax.swing.JFrame;
//Manipulates how to close window. Just that. Yeah.
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.Color;
*/

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
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
import java.util.Timer;


public class Game extends Application {
    ArrayList<String> moves = new ArrayList<String>();
    long lastPressProcessed = 0;

    public void start(Stage theStage){
        theStage.setTitle("Let's Play!");

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 500, 500 );
        root.getChildren().add( canvas );



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

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill( Color.LIGHTCORAL );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );

        Character hero = new Character("Froakie.png");
        Sprite enemy = new Character("Froakie.png");
        Character box = new Character("Froakie.png");

        enemy.setSpawn(110, 50);
        box.setSpawn(220, 100);


        new AnimationTimer(){
            public void handle(long currentNanoTime){
                gc.clearRect(0, 0, 500, 500);

                if (moves.contains("LEFT")) {
                        hero.moveL();
                    if(hero.collision(enemy)) {
                        hero.moveR();
                    }
                    if(hero.collision(box)) {
                        box.moveL();
                    }
                    if(box.collision(enemy)) {
                        box.moveR();
                        hero.moveR();
                    }
                }
                if (moves.contains("RIGHT")){
                    hero.moveR();
                    if (hero.collision(enemy)) {
                        hero.moveL();
                    }
                    if(hero.collision(box)) {
                        box.moveR();
                    }
                    if(box.collision(enemy)) {
                        box.moveL();
                        hero.moveL();
                    }
                }
                if (moves.contains("UP")){
                    hero.moveU();
                    if (hero.collision(enemy)) {
                        hero.moveD();
                    }
                    if(hero.collision(box)) {
                        box.moveU();
                    }
                    if(box.collision(enemy)) {
                        box.moveD();
                        hero.moveD();
                    }
                }
                if (moves.contains("DOWN")){
                    hero.moveD();
                    if (hero.collision(enemy)) {
                        hero.moveU();
                    }
                    if(hero.collision(box)) {
                        box.moveD();
                    }
                    if(box.collision(enemy)) {
                        box.moveU();
                        hero.moveU();
                    }
                }

                hero.render(gc);
                enemy.render(gc);
                box.render(gc);
            }
        }.start();



        theStage.show();

    }
}

/*Uses awt and swing
public class Game extends JPanel {
        int x = 0;
        int y = 0;
        private void moveBall() {
            x = x + 1;
            y = y + 1;
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(1));
            g2d.fillOval(x, y, 30, 40);
            g2d.setColor(Color.gray);
        }
        public static void main(String args[]) throws InterruptedException {
            JFrame start = new JFrame("Puzzle Based Game");
            Game game = new Game();
            start.add(game);
            start.setSize(600, 600);
            start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            start.setVisible(true);
            while (true) {
                game.moveBall();
                game.repaint();
                Thread.sleep(10);
            }
        }

}
*/
