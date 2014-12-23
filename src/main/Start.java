package main;

import ui.BottomPane;
import ui.GroupPane;
import ui.LeagueTab;
import ui.SelectedPane;
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

public class Start extends Application {
	
	public static BorderPane root = new BorderPane();
	public TabPane tabPane = new TabPane();
	public SelectedPane selPane = new SelectedPane();
	public BottomPane bottomPane = new BottomPane();
	public static GroupPane groupPane = new GroupPane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Build tabs
		LeagueTab tab1 = new LeagueTab("GER");
		tab1.buildLeaguePane();
		LeagueTab tab2 = new LeagueTab("ENG");
		tab2.buildLeaguePane();
		LeagueTab tab3 = new LeagueTab("ITA");
		tab3.buildLeaguePane();
		LeagueTab tab4 = new LeagueTab("ESP");
		tab4.buildLeaguePane();
		LeagueTab tab5 = new LeagueTab("EUR1");
		tab5.buildLeaguePane();
		LeagueTab tab6 = new LeagueTab("EUR2");
		tab6.buildLeaguePane();
		
		
		tabPane.getTabs().addAll(tab1.getVisual(), tab2.getVisual(), tab3.getVisual(), tab4.getVisual());
		tabPane.getTabs().addAll(tab5.getVisual(), tab6.getVisual());
		
		// build panels 
		selPane.build();
		bottomPane.build();
		groupPane.build();
		
		// add contents to root border panel
		root.setCenter(tabPane);
		root.setRight(selPane.getVisual());
		root.setBottom(bottomPane.getVisual());
		
		// scene setup
		Scene scene = new Scene(root,900,750);
		scene.getStylesheets().add("/style.css");
		
		// stage setup
		primaryStage.setTitle("UEFA Champions League Draw Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void onNextBtn() {
		root.setRight(null);
		root.setCenter(groupPane.getVisual());
	}

}
