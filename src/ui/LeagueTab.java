package ui;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

/**
 * A tab that contains a tilePane 
 * to show all teams in a certain league
 * 
 * @author YUCHZOU
 *
 */

public class LeagueTab {
	
	public Tab tab = new Tab();
	public TilePane tilePane = new TilePane();
	public String nation;
	
	
	public LeagueTab(String str) {
		nation = str;
		tab.setText(str);
		tilePane.getStyleClass().add("body-style");
	}

	public void buildLeaguePane() {
		// load icon files
		File iconFolder = new File("res/" + nation);
		File icon[] = iconFolder.listFiles(); 
		
		for (int i=0; i<icon.length; i++) {
			HBox hbox = new HBox();
			Label label = new Label();
			ImageView imgView = new ImageView();
			Button button = new Button("+");
			
			String name[] = icon[i].getName().split(".png");
			label.setText(name[0]);
			
			Image img = new Image("file:res/" + nation + "/" + icon[i].getName());
			imgView.setImage(img);
			imgView.setFitHeight(40);
			imgView.setPreserveRatio(true);
			
			hbox.setPrefHeight(50);
			hbox.setPrefWidth(100);
			hbox.getChildren().addAll(button, label, imgView);
			tilePane.getChildren().add(hbox);
			
		}
		
	}
	
	public Tab getVisual() {
		tab.setContent(tilePane);;
		return tab;
	}
	
	public void enableButton(String teamName) {
		
	}
	

}
