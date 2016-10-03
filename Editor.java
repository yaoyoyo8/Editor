package editor;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by Yao on 2016/10/1.
 */
public class Editor extends Application{
    private static String fileNme = "Tan and Yao";
    private Scene scene;
    private int windowWidth = 500;
    private int windowHeight = 500;
    private Cursor cur;
    private int line_length;
    protected FastLinkedList buffer;


    public void delete () {
        return;
    }
    public void add () {
        return;
    }
    public void handle () {
        return;
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(fileNme);
        Group root = new Group();
        scene = new Scene(root, windowWidth, windowHeight, Color.WHITE);
        //add a scrollbar
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setPrefHeight(windowHeight);
        scrollBar.setMin(10);
        scrollBar.setMax(windowHeight);
        scrollBar.setLayoutX(windowWidth - scrollBar.getLayoutBounds().getWidth() - 8);
        root.getChildren().add(scrollBar);
        //bring in keyEventHandler
        EventHandler<KeyEvent> keyEventHandler = new KeyEventHandler(root, windowWidth, windowHeight);
        scene.setOnKeyTyped(keyEventHandler);
        scene.setOnKeyPressed(keyEventHandler);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main (String[] args){
        launch(args);
    }
}
