package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import ui.GroupPane;
import ui.SelectedPane;

public class Draw {
	
	public static ArrayList<Team> teamList = new ArrayList<Team>();
	
	public static List<Team> a; 
	public static List<Team> b;
	public static List<Team> c;
	public static List<Team> d; 
	
	public static Comparator<Team> cmp = new Comparator<Team>() {

		@Override
		public int compare(Team team1, Team team2) {
			if (team1.getCredit() > team2.getCredit()) {
				return -1;
			}
				return 1;
		}	
	};
	
	public static void loadSelectedPane() {
		int size = SelectedPane.vbox.getChildren().size();
		
		for (int i=0; i<size; i++) {
			String temp = SelectedPane.vbox.getChildren().get(i).getId();
			String name[] = temp.split("-");
			String val = PropData.readProp(name[1].replace(" ", "_"));
			
			teamList.add(new Team(name[1], Float.parseFloat(val), name[0]));
			// test output
			// System.out.println(name + "---" + val);
		}
		
		// sort the array list
		Collections.sort(teamList, cmp);
		// sort test output
//		for (int i=0; i<teamList.size(); i++) {
//			System.out.println(teamList.get(i).getCredit());
//		}
		
		int interval = teamList.size()/4; // excepted to be 32/4=8
		a = teamList.subList(0, interval); // 0-7
		b = teamList.subList(interval, interval*2); // 8-15
		c = teamList.subList(interval*2, interval*3); // 16-23
		d = teamList.subList(interval*3, interval*4); // 24-32
		
	}
	
	public static void shuffle() {
		Collections.shuffle(a);
		Collections.shuffle(b);
		Collections.shuffle(c);
		Collections.shuffle(d);	
	}
	
	public static void displayDraw() {
		shuffle();
		for (int i=0; i<8; i++) {
			GroupPane.groupList.get(i).insert(a.get(i).getName(), a.get(i).getNation());
			GroupPane.groupList.get(i).insert(b.get(i).getName(), b.get(i).getNation());
			GroupPane.groupList.get(i).insert(c.get(i).getName(), c.get(i).getNation());
			GroupPane.groupList.get(i).insert(d.get(i).getName(), d.get(i).getNation());
		}
	}


}


class Team {
	
	public String name;
	public float credit;
	public String nation;
	
	
	public Team(String str1, float n, String str2) {
		name = str1;
		credit = n;
		nation = str2;
	}
	
	public String getName() {
		return name;
	}
	
	public float getCredit() {
		return credit;
	}
	
	public String getNation() {
		return nation;
	}
}