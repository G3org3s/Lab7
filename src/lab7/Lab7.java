/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7;

import javafx.animation.Animation;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 6302743
 */
public class Lab7 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Circle circle = new Circle(10);
        circle.setFill(Color.VIOLET);

        Rectangle r = new Rectangle(100, 100, 250, 150);

        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(circle);
        pathTransition.setPath(r);
        pathTransition.setCycleCount(INDEFINITE);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.setAutoReverse(false);
        pathTransition.play();

        Line line = new Line(0, 300, 600, 300);

        Circle objA = new Circle(10);
        objA.setCenterX(100);
        objA.setCenterY(350);
        objA.setFill(Color.BLUE);

//        Rectangle r2 = new Rectangle(100, 350, 300, 200);
//        PathTransition pT = new PathTransition();
//        pT.setDuration(Duration.millis(4000));
//        pT.setNode(objA);
//        pT.setPath(r2);
//        pT.setCycleCount(1);
//        pT.setAutoReverse(false);
//        pT.play();
        Button start = new Button("Start");
        start.setTranslateX(0);
        start.setTranslateY(400);
        Button reset = new Button("Reset");
        reset.setTranslateX(0);
        reset.setTranslateY(450);
        Button exit = new Button("Exit");
        exit.setTranslateX(0);
        exit.setTranslateY(500);

        Polygon objB = new Polygon(125, 100, 100, 150, 150, 150);
        objB.setOpacity(0);
        
        start.setOnAction(e -> {
            objB.setTranslateX(150);
            objB.setTranslateY(350);
            objB.setOpacity(1);
            objB.setRotate(180);
            TranslateTransition move1 = new TranslateTransition(Duration.seconds(2), objA);
            move1.setInterpolator(Interpolator.LINEAR);
            move1.setDuration(Duration.millis(2000));
            move1.setToX(300);
            TranslateTransition move2 = new TranslateTransition(Duration.seconds(2), objA);
            move2.setInterpolator(Interpolator.LINEAR);
            move2.setToY(200);
            TranslateTransition move3 = new TranslateTransition(Duration.seconds(2), objA);
            move3.setInterpolator(Interpolator.LINEAR);
            move3.setToX(0);
            TranslateTransition move4 = new TranslateTransition(Duration.seconds(2), objA);
            move4.setInterpolator(Interpolator.LINEAR);
            move4.setToY(0);
            
            FadeTransition ft = new FadeTransition(new Duration(2000), objB);
            ft.setToValue(0.5);
            ft.play();
            
            ScaleTransition sc = new ScaleTransition(Duration.seconds(2), objB);
            sc.setToX(1.5);
            sc.setToY(1.5);
            
            RotateTransition rt = new RotateTransition(Duration.seconds(2), objB);
            rt.setToAngle(90);
            
            TranslateTransition move5 = new TranslateTransition(Duration.seconds(2), objB);
            move5.setInterpolator(Interpolator.LINEAR);
            move5.setDuration(Duration.millis(2000));
            move5.setToY(250);
            
            SequentialTransition seq = new SequentialTransition(move1, move2, move3, move4);
            SequentialTransition seq2 = new SequentialTransition(move1, sc, rt, move5);
            seq.play();
            seq2.play();
        });

        

        Pane root = new Pane(circle, line, objA, objB, start, reset, exit);
        Scene s = new Scene(root, 600, 600);
        stage.setScene(s);
        stage.show();
    }

}
