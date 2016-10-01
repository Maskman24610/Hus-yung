package com.TestExercise;

public class EnumerTest{
	enum Names{
	JERRY("lead guitae"){public String sings(){
		return "plailnttively";
	}
			
	},
	BOBBY("rhythm guitar"){public String sings(){
	return "hoarsely";
	}
	},
	PHIL("bass");
	
	private String instrument;
	
	Names(String instrument){
		this.instrument=instrument;
	}
	public String getInstrument(){
		return this.instrument;
	}
	public String sings(){
		return "occassionally";
	}
	}//close enum Names
	public static void main(String[] args) {
		for(Names n:Names.values()){
			System.out.print(n);
			System.out.print(", instrument: "+n.getInstrument());
			System.out.println(", sings: "+n.sings());
		}
	}//close method main

}//close class
