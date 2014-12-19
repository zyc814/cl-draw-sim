package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SelectedPane {
	
	public VBox visual = new VBox();
	public ScrollPane scrPane = new ScrollPane();
	
	
	public static VBox vbox = new VBox();
	public static Label label = new Label();
	public static int count = 0;
	
	public SelectedPane() {
		
	}
	
	public void build() {
		VBox.setVgrow(scrPane, Priority.ALWAYS);
		// label setup
		label.setText("Selected Teams:" + 0);
		label.setFont(new Font("Arial", 15));
		label.setAlignment(Pos.CENTER);
		label.setPrefHeight(40);
		label.setPrefWidth(250);
		label.getStyleClass().addAll("teambox-style", "teambox-label");
		
		// node setup
		scrPane.getStyleClass().add("body-style");
		scrPane.setContent(vbox);
		visual.getChildren().addAll(label, scrPane);
		
		
	}
	
	public VBox getVisual() {
		
		return visual;
	}
	
	public static void addTeam() {
		
	}
	
	public static void removeTeam() {
		
	}

}
