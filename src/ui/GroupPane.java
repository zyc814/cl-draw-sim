package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GroupPane {
	
	public GridPane gridPane = new GridPane();
	
	public VBox ga = new VBox();
	public VBox gb = new VBox();
	public VBox gc = new VBox();
	public VBox gd = new VBox();
	public VBox ge = new VBox();
	public VBox gf = new VBox();
	public VBox gg = new VBox();
	public VBox gh = new VBox();
	
	
	
	public GroupPane() {
		ga.getStyleClass().add("teambox-style");
		gb.getStyleClass().add("teambox-style");
		gc.getStyleClass().add("teambox-style");
		gd.getStyleClass().add("teambox-style");
		ge.getStyleClass().add("teambox-style");
		gf.getStyleClass().add("teambox-style");
		gg.getStyleClass().add("teambox-style");
		gh.getStyleClass().add("teambox-style");
	}
	
	public void build() {
		gridPane.getStyleClass().add("body-style");
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(0, 10, 0, 10));
		gridPane.setGridLinesVisible(true);
		
		gridPane.add(ga, 0, 0);
		gridPane.add(gb, 1, 0);
		gridPane.add(gc, 0, 1);
		gridPane.add(gd, 1, 1);
		gridPane.add(ge, 0, 2);
		gridPane.add(gf, 1, 2);
		gridPane.add(gg, 0, 3);
		gridPane.add(gh, 1, 3);	
		
		ga.getChildren().add(new Button("test"));
	}
	
	public GridPane getVisual() {
		return gridPane;
	}

}
