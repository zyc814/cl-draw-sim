package main;

public class Team {
	
	public String name;
	public float credit;
	public String nation;
	public String folder;
	
	
	public Team(String str1, float n, String str2, String str3) {
		name = str1;
		credit = n;
		nation = str2;
		folder = str3;
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
	
	public String getFolder() {
		return folder;
	}

}
