package main;
	
import java.util.Random;

import application.GameOfLife;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text; 


public class GOLLauncher extends Application {
	@Override
	public void start(Stage stage) {   
	     new GameOfLife(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
