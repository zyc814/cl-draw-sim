package ui;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane {
	
	public HBox hbox = new HBox();
	
	public Button btnNext = new Button("Next");
	public Button btnRandom = new Button("Random");
	public Button btnClear = new Button("Clear");
	
	public ButtonPane() {
		
	}
	
	public void build() {
		hbox.getChildren().addAll(btnRandom, btnClear, btnNext);
	}
	
	public HBox getVisual() {
		return hbox;
	}

}
