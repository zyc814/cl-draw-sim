package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GroupBox {
	
	public VBox vbox = new VBox();
	public Label label = new Label();
	public String group;
	public Separator sep = new Separator(); 
	
	
	public GroupBox(String str) {
		group = str;
		
		label.setText("Group " + str);
		label.setPrefHeight(30);
		label.getStyleClass().add("teambox-label");
		
		vbox.setPrefWidth(225);
		vbox.setPrefHeight(200);
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0,10,0,10));
		vbox.getChildren().addAll(label,sep);
		vbox.getStyleClass().add("teambox-style");
	}
	
	// insert a team according to nation and name
	public void insert(String name, String nation) {
		HBox hbox = new HBox();
		Label lbl = new Label(name);
		lbl.getStyleClass().add("teambox-label");
		// test image path output
		// System.out.println("/" + nation + "/" + name + ".png");		
		Image img = new Image("/" + nation + "/" + name + ".png");
		ImageView view = new ImageView(img);
		view.setPreserveRatio(true);
		view.setFitHeight(30);
		
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.getChildren().addAll(view, lbl);
		vbox.getChildren().add(hbox);
	}
	
	// remove all the contents
	public void clear() {
		vbox.getChildren().clear();
	}
	
	public VBox getVisual() {
		return vbox;
	}
	

}
