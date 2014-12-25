package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
		//sep.getStyleClass().add("groupbox-separator");
		
		vbox.setPrefWidth(225);
		vbox.setPrefHeight(200);
		//vbox.setSpacing(10);
		vbox.setPadding(new Insets(0,10,0,10));
		vbox.getChildren().addAll(label,sep);
		vbox.getStyleClass().add("teambox-style");
	}
	
	public void insert() {
		
	}
	
	public VBox getVisual() {
		return vbox;
	}
	

}
