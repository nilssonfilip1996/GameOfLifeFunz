package views;

import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameOfLifeView {
	private Stage primaryStage;
	private int boardSize;
	private TilePane tilePane;

	GridPane gridPane;

	public GameOfLifeView(Stage stage, int boardSize) {
		this.primaryStage = stage;
		this.boardSize = boardSize;
	}

	public void initBoard(int board[][]) {
		tilePane = new TilePane(boardSize, boardSize);
		tilePane.setPrefRows(boardSize);
		tilePane.setPrefColumns(boardSize);
		tilePane.setVgap(0);
		tilePane.setHgap(0);
		for (int c = 0; c < boardSize; c++) {
			for (int r = 0; r < boardSize; r++) {
				Rectangle t = new Rectangle();
				t.setHeight(10);
				t.setWidth(10);
				if (board[c][r] == 1) {
					t.setFill(Color.BLACK);
					tilePane.getChildren().add(t);
				} else {
					t.setFill(Color.WHITE);
					tilePane.getChildren().add(t);
				}
			}
		}

		// Creating a scene object
		Scene scene = new Scene(tilePane);

		// Setting title to the Stage
		primaryStage.setTitle("Game of life");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}

	public void updateGrid(int board[][]) {
		for (int c = 0; c < board.length; c++) {
            for (int r = 0; r < board[0].length; r++) {
                Rectangle rec = (Rectangle) tilePane.getChildren().get(r * boardSize + c);
                if (board[c][r] == 1) {
					rec.setFill(Color.BLACK);
				} else {
					rec.setFill(Color.WHITE);
				}
            }
        }
	}

}
