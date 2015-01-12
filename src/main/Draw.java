package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ui.GroupPane;
import ui.SelectedPane;

public class Draw {
	
	public static ArrayList<Team> teamList = new ArrayList<Team>();
	
	public static ArrayList<Team> a = new ArrayList<Team>();
	public static ArrayList<Team> b = new ArrayList<Team>();
	public static ArrayList<Team> c = new ArrayList<Team>();
	public static ArrayList<Team> d = new ArrayList<Team>();
	
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
			String value = PropData.readProp(name[1].replace(" ", "_")); // value = score-nation
			String val[] = value.split("-");
			
			teamList.add(new Team(name[1], Float.parseFloat(val[0]), val[1], name[0]));
			// test output
			// System.out.println(name[1] + "---" + val[0] + "---" + val[1]);
		}
		
		// sort the array list
		Collections.sort(teamList, cmp);
		// sort test output
//		for (int i=0; i<teamList.size(); i++) {
//			System.out.println(teamList.get(i).getCredit());
//		}
		
		int interval = teamList.size()/4; // excepted to be 32/4=8
		List<Team> aa = teamList.subList(0, interval); // 0-7
		List<Team> bb = teamList.subList(interval, interval*2); // 8-15
		List<Team> cc = teamList.subList(interval*2, interval*3); // 16-23
		List<Team> dd = teamList.subList(interval*3, interval*4); // 24-32
		
		for (int i=0; i<8; i++) {
			a.add(aa.get(i));
			b.add(bb.get(i));
			c.add(cc.get(i));
			d.add(dd.get(i));
		}
		
	}
	
	public static void shuffle() {
		Collections.shuffle(a);
		Collections.shuffle(b);
		Collections.shuffle(c);
		Collections.shuffle(d);		
		Group.draw();
		//Group.examine();
		//Group.test();
	}
	
	public static void clear() {
		teamList.clear();
		a.clear();
		b.clear();
		c.clear();
		d.clear();
		for (int i=0; i<8; i++) {
			GroupPane.groupList.get(i).clear();
		}
	}
	
	
	public static void displayDraw() {
		for (int i=0; i<8; i++) {
			GroupPane.groupList.get(i).insert(a.get(i).getName(), a.get(i).getFolder());
			GroupPane.groupList.get(i).insert(b.get(i).getName(), b.get(i).getFolder());
			GroupPane.groupList.get(i).insert(c.get(i).getName(), c.get(i).getFolder());
			GroupPane.groupList.get(i).insert(d.get(i).getName(), d.get(i).getFolder());
		}
	}


}
