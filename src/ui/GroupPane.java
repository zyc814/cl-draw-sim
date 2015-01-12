package ui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class GroupPane {
	
	public GridPane gridPane = new GridPane();
	
	public GroupBox a = new GroupBox("A");
	public GroupBox b = new GroupBox("B");
	public GroupBox c = new GroupBox("C");
	public GroupBox d = new GroupBox("D");
	
	public GroupBox e = new GroupBox("E");
	public GroupBox f = new GroupBox("F");
	public GroupBox g = new GroupBox("G");
	public GroupBox h = new GroupBox("H");
	
	public static ArrayList<GroupBox> groupList = new ArrayList<GroupBox>();
	
	public GroupPane() {
		
		groupList.add(a);
		groupList.add(b);
		groupList.add(c);
		groupList.add(d);
		
		groupList.add(e);
		groupList.add(f);
		groupList.add(g);
		groupList.add(h);
		
	}
	
	public void build() {
		
		gridPane.getStyleClass().add("body-style");
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(30, 15, 0, 15));
		// gridPane.setGridLinesVisible(true);		
		
		// test
		gridPane.add(a.getVisual(), 0, 0);
		gridPane.add(b.getVisual(), 1, 0);
		gridPane.add(c.getVisual(), 2, 0);
		gridPane.add(d.getVisual(), 3, 0);
		
		gridPane.add(e.getVisual(), 0, 1);
		gridPane.add(f.getVisual(), 1, 1);
		gridPane.add(g.getVisual(), 2, 1);
		gridPane.add(h.getVisual(), 3, 1);
		
		// test build up
		// a.insert("FC Koln", "GER");
		
	}
	
	public GridPane getVisual() {
		return gridPane;
	}

}
