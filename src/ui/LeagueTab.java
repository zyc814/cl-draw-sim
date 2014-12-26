package ui;

import java.io.File;

import main.PropData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

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
	public ScrollPane scrPane = new ScrollPane();
	
	public LeagueTab(String str) {
		nation = str;
		tab.setText(str);
		tab.setClosable(false);
		ImageView icon = new ImageView(new Image("league/" + nation + ".png"));
		icon.setFitHeight(25);
		icon.setPreserveRatio(true);
		tab.setGraphic(icon);
		// tile panel setup
		tilePane.getStyleClass().add("body-style");
		tilePane.setPadding(new Insets(10));
		tilePane.setHgap(10);
		tilePane.setVgap(10);
		
	}

	public void buildLeaguePane() {
		// load icon files
		File iconFolder = new File("res/" + nation);
		File icon[] = iconFolder.listFiles(); 
		
		for (int i=0; i<icon.length; i++) {
			// icon path and file name
			String name[] = icon[i].getName().split(".png");
			// exclude .DS Store file in Mac OS
			if (name[0].contains("DS_Store")) {
				continue;
			}
			// team box components
			HBox hbox = new HBox();
			final Label label = new Label();
			ImageView imgView = new ImageView();
			final Button button = new Button("+");
			// load icon images
			final Image img = new Image("file:res/" + nation + "/" + icon[i].getName());
			imgView.setImage(img);
			imgView.setFitHeight(40);
			imgView.setPreserveRatio(true);
			// Label setup
			label.setText(name[0]);
			label.setMaxWidth(Double.MAX_VALUE);
			label.setFont(new Font("Arial", 17));
			label.getStyleClass().add("teambox-label");
			// Hbox setup
			hbox.setAlignment(Pos.CENTER_LEFT);
			hbox.setSpacing(12);
			HBox.setHgrow(label, Priority.ALWAYS);
			hbox.setPrefHeight(40);
			hbox.setPrefWidth(300);
			hbox.setPadding(new Insets(10));
			hbox.getStyleClass().add("teambox-style");
			
			// define button operation
			button.getStyleClass().add("teambox-button");
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					button.setDisable(true);
					label.setDisable(true);
					SelectedPane.label.setText("Selected Teams: " + ++SelectedPane.count);
					SelectedPane.addTeam(label.getText(),img, button, label);
				}
				
			});		
			
			hbox.getChildren().addAll(button, label, imgView);
			tilePane.getChildren().add(hbox);
			
			// test property write
			// PropData.writeProp(name[0].replace(" ", "_"), nation);
			// String val = PropData.readProp(name[0].replace(" ", "_"));
			// System.out.println(val);
			
		} // for loop
	}
	
	public Tab getVisual() {
		// scroll panel setup
		scrPane.setContent(tilePane);
		scrPane.setFitToWidth(true);
		scrPane.getStyleClass().add("body-style");
		
		tab.setContent(scrPane);
		return tab;
	}
	
	public void enableButton(String teamName) {
		
	}
	

}
