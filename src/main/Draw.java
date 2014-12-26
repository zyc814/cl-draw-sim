package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ui.SelectedPane;

public class Draw {
	
	public static ArrayList<Team> teamList = new ArrayList<Team>();
	
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
			String name = SelectedPane.vbox.getChildren().get(i).getId();
			String val = PropData.readProp(name.replace(" ", "_"));
			
			teamList.add(new Team(name, Float.parseFloat(val)));
			// test output
			// System.out.println(name + "---" + val);
		}
		
		// sort the array list
		Collections.sort(teamList, cmp);
		for (int i=0; i<teamList.size(); i++) {
			System.out.println(teamList.get(i).getCredit());
		}
		
	}
	


}


class Team {
	
	public String name;
	public float credit;
	
	public Team(String str, float n) {
		name = str;
		credit = n;
	}
	
	public String getName() {
		return name;
	}
	
	public float getCredit() {
		return credit;
	}
}