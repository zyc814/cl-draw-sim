package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GroupBox {
	
	public VBox vbox = new VBox();
	public Label label = new Label();
	public String group;
	
	
	public GroupBox(String str) {
		group = str;
		label.setText("Group " + str);
		vbox.getChildren().add(label);
		
	}
	
	public void insert() {
		
	}
	

}
