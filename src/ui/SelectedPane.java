package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
		scrPane.setFitToWidth(true);
		
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(5));
		visual.getChildren().addAll(label, scrPane);
		
		
	}
	
	public VBox getVisual() {
		return visual;
	}
	
	public static void addTeam(String name, Image img, final Button btn, final Label lbl) {
		// build team box
		final Button button = new Button("-");
		final Label label = new Label(name);
		label.getStyleClass().add("teambox-label");
		label.setPrefWidth(200);
		final HBox hbox = new HBox();
		hbox.setSpacing(10);
		//hbox.setPadding(new Insets(5));
		hbox.getStyleClass().add("teambox-style");
		hbox.setAlignment(Pos.CENTER);
		HBox.setHgrow(label, Priority.ALWAYS);
		ImageView view = new ImageView(img);
		view.setPreserveRatio(true);
		view.setFitHeight(25);
		// add children
		hbox.getChildren().addAll(button, view, label);
		vbox.getChildren().add(hbox);
		
		// define button action
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				lbl.setDisable(false);
				btn.setDisable(false);
				SelectedPane.label.setText("Selected Teams: " + --count);
				vbox.getChildren().removeAll(hbox);
			}
			
		});
			
	}

}
