package ui;

import main.Start;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class BottomPane {
	
	public Button btnNext = new Button("Next");
	public Button btnRandom = new Button("Random");
	public Button btnClear = new Button("Clear");
	
	public HBox hbox = new HBox();
	public HBox hbox2 = new HBox();
	
	public BottomPane() {
		
	}
	
	public void build() {
		
		btnNext.setPrefSize(110, 30);
		btnRandom.setPrefSize(110, 30);
		btnClear.setPrefSize(110, 30);
		
		btnNext.getStyleClass().add("button-style");
		btnRandom.getStyleClass().add("button-style");
		btnClear.getStyleClass().add("button-style");
		
		hbox2.getChildren().addAll(btnRandom, btnClear);
		hbox2.setAlignment(Pos.CENTER_LEFT);
		hbox2.setSpacing(5);
		
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.setPadding(new Insets(5));
		HBox.setHgrow(hbox2, Priority.ALWAYS);
		
		hbox.getChildren().addAll(hbox2, btnNext);
		hbox.getStyleClass().add("body-style");
		
		// define button actions
		btnNext.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Start.onNextBtn();
			}
			
		});

	}
	
	public HBox getVisual() {
		return hbox;
	}
}
