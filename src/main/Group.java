package main;

import java.util.ArrayList;

public class Group {
	
	public static ArrayList<String> ck = new ArrayList<String>();
	
	public static boolean flag;
	
	public Group() {
		
	}
	
	public static boolean examine() {
		
		boolean ok = true;
		
		ck.clear();
		for (int i=0; i<8; i++) {
			
			if ( Draw.a.get(i).getNation().equals(Draw.b.get(i).getNation()) || Draw.a.get(i).getNation().equals(Draw.c.get(i).getNation()) || Draw.a.get(i).getNation().equals(Draw.d.get(i).getNation()) ) 
			{ck.add(Draw.a.get(i).getNation()); ok = false; continue;}
			
			if ( Draw.b.get(i).equals(Draw.c.get(i)) || Draw.b.get(i).equals(Draw.d.get(i)) )
			{ck.add(Draw.b.get(i).getNation()); ok = false; continue;}
			
			if ( Draw.c.get(i).equals(Draw.d.get(i)) )
			{ck.add(Draw.c.get(i).getNation()); ok = false; continue;}
			
			ck.add("---");
		}
		flag = ok;
		return ok;
		// System.out.println(ck.toString());
	}
	
	public static void shift2() {
		Team temp = Draw.b.get(7);
		Draw.b.add(0, temp);
		Draw.b.remove(8);
	}
	
	public static void shift3() {
		Team temp = Draw.c.get(7);
		Draw.c.add(0, temp);
		Draw.c.remove(8);
	}
	
	public static void shift4() {
		Team temp = Draw.d.get(7);
		Draw.d.add(0, temp);
		Draw.d.remove(8);
	}
	
	public static boolean draw() {
		
		// re-arrange class 2 
		for (int i=0; i<8; i++) {
			for (int j=i; j<8; j++) {
				if (Draw.b.get(i).getNation().equals(Draw.a.get(i).getNation())) {
					Team temp = Draw.b.get(7);
					Draw.b.add(i, temp);
					Draw.b.remove(8);
				} else {
					break;
				}
			}
		}
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		
		// re-arrange class 3
		for (int i=0; i<8; i++) {
			for (int j=i; j<8; j++) {
				if ( Draw.c.get(i).getNation().equals(Draw.a.get(i).getNation()) || Draw.c.get(i).getNation().equals(Draw.b.get(i).getNation()) ) {
					Team temp = Draw.c.get(7);
					Draw.c.add(i, temp);
					Draw.c.remove(8);
				} else {
					break;
				}
			}
		}
		//System.out.println(c3.toString());
		
		// re-arrange class 4
		for (int i=0; i<8; i++) {
			for (int j=i; j<8; j++) {
				if ( Draw.d.get(i).getNation().equals(Draw.a.get(i).getNation()) || Draw.d.get(i).getNation().equals(Draw.b.get(i).getNation()) || Draw.d.get(i).getNation().equals(Draw.c.get(i).getNation()) ) {
					Team temp = Draw.d.get(7);
					Draw.d.add(i, temp);
					Draw.d.remove(8);
				} else {
					break;
				}
			}
		}
		//System.out.println(c4.toString());
		return examine();
		
	}
	
	public static void test() {
		for (int i=0; i<8; i++) {
			if (flag) break;
			else {
				shift2();
				//System.out.println("=== shift 2 ===");
				draw();
				examine();

			}
		}
		
		for (int i=0; i<8; i++) {
			if (flag) break;
			else {
				shift3();
				//System.out.println("=== shift 3 ===");
				draw();
				examine();

			}
		}
		
		for (int i=0; i<8; i++) {
			if (flag) break;
			else {
				shift4();
				//System.out.println("=== shift 4 ===");
				draw();
				examine();

			}
		}
	}

}
