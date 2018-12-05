package application;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import main.Settings;
import utilities.BoardHelper;
import views.TreeOfLifeView;

public class TreeOfLife {
	private TreeOfLifeView gameView;
	private int boardGridSize;
	private int updateRate;
	private int cells[][];

	public TreeOfLife(Stage stage) {
		boardGridSize = Settings.BOARD_GRID_SIZE;
		updateRate = Settings.TICK_RATE;
		gameView = new TreeOfLifeView(stage, boardGridSize);
		initGame();
		gameView.initBoard(cells);
//		for (int x = 0; x<cells.length; x++)
//		{
//		   for (int y = 0; y<cells.length; y++)
//		   {
//		        BoardHelper.evaluateCell(cells, x, y);
//		   }
//		   //System.out.println();
//		}
		startGame();
	}

	private void startGame() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				updateGOL();
			}
		};
		timer.schedule(task, 0, updateRate);

	}

	private void initGame() {
		cells = new int[boardGridSize][boardGridSize];
		Random rand = new Random();
		for (int c = 0; c < boardGridSize; c++) {
			for (int r = 0; r < boardGridSize; r++) {
				if (c > (boardGridSize / 2)-10 && c < (boardGridSize / 2)+10 && r > (boardGridSize / 2)-10
						&& r < (boardGridSize / 2)+10) {
					int rVal = rand.nextInt(5);
					if (rVal == 1) {
						cells[c][r] = 1;
					} else
						cells[c][r] = 0;
				} else {
					cells[c][r] = 0;
				}
			}
		}
	}

	private void updateGOL() {
		int temp[][] = new int[boardGridSize][boardGridSize];
		for (int c = 0; c < boardGridSize; c++) {
			for (int r = 0; r < boardGridSize; r++) {
				boolean stayAlive = BoardHelper.evaluateCell(cells, c, r);
				if (stayAlive) {
					temp[c][r] = 1;
				} else {
					temp[c][r] = 0;
				}
			}
		}
		cells = temp;
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				gameView.updateGrid(cells);
				System.out.println("tick");
//				for (int[] x : cells)
//				{
//				   for (int y : x)
//				   {
//				        System.out.print(y + " ");
//				   }
//				   System.out.println();
//				}
			}
		});
	}
}
