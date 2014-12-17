package main;

import ui.LeagueTab;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class start extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		
		// Build tabs
		TabPane tabPane = new TabPane();
		LeagueTab tab1 = new LeagueTab("GER");
		tab1.buildLeaguePane();
		LeagueTab tab2 = new LeagueTab("ESP");
		tabPane.getTabs().addAll(tab1.getVisual());
		
		root.setCenter(tabPane);
		
		Scene scene = new Scene(root,750,550);
		//scene.getStylesheets().add("res/style.css");
		primaryStage.setTitle("UEFA Champions League Draw Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}
