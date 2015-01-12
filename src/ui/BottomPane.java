package ui;

import main.Draw;
import main.Start;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class BottomPane {
	
	public static Button btnNext = new Button("Next");
	public static Button btnBack = new Button("Back");
	public static Button btnRandom = new Button("Random");
	public static Button btnClear = new Button("Clear");
	public static Button btnRedraw = new Button("Re-Draw");
	
	public HBox hbox = new HBox();
	public HBox hbox2 = new HBox();
	public HBox hbox3 = new HBox();
	
	public BottomPane() {
		
	}
	
	public void build() {
		
		btnNext.setPrefSize(110, 30);
		btnBack.setPrefSize(110, 30);
		btnRandom.setPrefSize(110, 30);
		btnClear.setPrefSize(110, 30);
		btnRedraw.setPrefSize(110, 30);
		
		btnNext.getStyleClass().add("button-style");
		btnBack.getStyleClass().add("button-style");
		btnRandom.getStyleClass().add("button-style");
		btnClear.getStyleClass().add("button-style");
		btnRedraw.getStyleClass().add("button-style");
		
		btnRandom.setDisable(true);
		btnBack.setDisable(true);
		btnNext.setDisable(true);
		btnRedraw.setDisable(true);
		
		hbox2.getChildren().addAll(btnRandom, btnClear, btnRedraw);
		hbox2.setAlignment(Pos.CENTER_LEFT);
		hbox2.setSpacing(5);
		
		hbox3.getChildren().addAll(btnBack, btnNext);
		hbox3.setAlignment(Pos.CENTER_RIGHT);
		hbox3.setSpacing(5);
		
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.setPadding(new Insets(5));
		HBox.setHgrow(hbox2, Priority.ALWAYS);
		
		hbox.getChildren().addAll(hbox2, hbox3);
		hbox.getStyleClass().add("body-style");
		
		// define button actions
		btnBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				BottomPane.onBackBtn();				
			}
			
		});
		
		btnNext.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				BottomPane.onNextBtn();
			}
			
		});
		
		btnRedraw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				BottomPane.onRedraw();
			}
			
		});
		
		btnClear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				BottomPane.onClear();
			}
			
		});

	}
	
	public static void onRedraw() {
		Draw.clear();
		Draw.loadSelectedPane();
		Draw.shuffle();
		Draw.displayDraw();
	}
	
	public static void onBackBtn() {
		Start.root.setCenter(Start.tabPane);
		Start.root.setRight(Start.selPane.getVisual());
		btnNext.setDisable(false);
		btnRedraw.setDisable(true);
		btnClear.setDisable(false);
		btnBack.setDisable(true);
	}
	
	public static void onClear() {
		int num = SelectedPane.vbox.getChildren().size();
		for (int i=0; i<num; i++) {
			HBox hbox = (HBox) SelectedPane.vbox.getChildren().get(0);
			Button btn = (Button) hbox.getChildren().get(0);
			btn.getOnAction().handle(new ActionEvent());
		}
	}
	
	public static void onNextBtn() {
		Start.root.setRight(null);
		Start.root.setCenter(Start.groupPane.getVisual());
		btnNext.setDisable(true);
		btnBack.setDisable(false);
		btnRedraw.setDisable(false);
		btnClear.setDisable(true);
		Draw.clear();
		Draw.loadSelectedPane();
		Draw.shuffle();
		Draw.displayDraw();
	}
	
	public HBox getVisual() {
		return hbox;
	}
}
