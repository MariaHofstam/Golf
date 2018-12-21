package lexicon.se.maria.Golf;

import java.util.Scanner;

/**
 * Simplified Golf-game
 * --------------------
 * Each swing should move the starting location for each arc. 
 * The progress the player makes should be displayed between swings, 
 * showing the amount of swings the player has taken, 
 * as well as the distance to the cup. 
 * If the ball travels beyond the cup, the new distance should still be positive. 
 * When the ball has reached the goal, the game should end, displaying all swings taken, 
 * and how far the ball travelled each time. 
 * If the ball moves too far away from the cup, the game should generate an error that 
 * takes you out of the game loop, with a failure message. 
 * If too many swings have been taken, the game should end, with a different failure message.
 */

public class Golf {
	private static Scanner scanner = new Scanner(System.in);
	
	private static String getStringFromUser() {					//method getStringFromUser	
		String text = scanner.nextLine();
		return text;}
	
	public static boolean playing(String answer) {				//method Y/N
		String upperCaseString = answer.toUpperCase();			//String to Upper Case
		switch(upperCaseString) {
			case "Y":
				return true;
			default:
				return false;
		}
	}	
	
	private static double getDoubleFromUser() {						//method getDoubleFromUser
		
		boolean valid = false;
		double number = 0;
		while(!valid) {
			try {
				number = Double.parseDouble(getStringFromUser());
				valid = true;				
			}catch(NumberFormatException e) {
				System.out.println("Input was not a number");
			}
		}
		return number;
	}
	
	public static double roundDecimalNumber(double decimalNr) {	//method: rounding a decimal number
		double roundedNr = Math.round(decimalNr * 10.0)/10.0;
		return roundedNr;
	}
	
	public static double angleInRadians(double angle) {			//method: calculate angle in radians
		double angInRad = (Math.PI/180) * angle;
		return angInRad;
	}
	
	public static double calculateDistance(double velocity, double angle) {		//method: calculate distance
		//Distance: Math.pow(velocity, 2) / GRAVITY * Math.sin(2 * angleInRadians)	
		
		double powerOf2 = 2;
		double gravity = 9.8;
		
		double powOf = Math.pow(velocity, powerOf2);			//velocity^2
		double angleRad = angleInRadians(angle);
		double distance = (powOf/gravity) * Math.sin(2 * angleRad);
		
		return distance;
	}
	
	public static void main( String[] args ){
		
		double distanceToCup = 500;					//Start value: distance to cup is 500 meters
		double velocity, angle;
		boolean valid;
		
		/*********************
		 * Welcome - message *
		 *********************/	
		
		System.out.println("This is a simplified Golf-game");
		
		/*********************
		 * Playing Golf Y/N *
		 *********************/	
		
		System.out.println("Do you want to play? Y/N ");
		String golf = getStringFromUser();
		valid = playing(golf);
	
		
		while (valid) {								// Player wants to play Golf
			for (int i = 0; i < 5; i++) {
				System.out.println("Distance to the cup is: " + distanceToCup + " meters.");
				System.out.println("Enter your velocity (m/s):");				
				velocity = getDoubleFromUser();
			
				System.out.println("Enter your angle");				
				angle = getDoubleFromUser();
			
				double distance = calculateDistance(velocity, angle); 	//Calculate distance
				distance = roundDecimalNumber(distance); 	//Rounding the decimal number
			
				distanceToCup = distanceToCup - distance;
				System.out.println("Distance to the cup after swing no: " + i + " is " + distanceToCup + " meters.");
			}
		
		}											// Player do NOT want to play Golf
		System.out.println("Welcome back!");
	
			
			//double a = - 5.35;
			//a = Math.abs(a);		//Creates an absolute value of the variable, i.e no "-".
			
			
			
			//System.out.println("Distance to the cup after swing no: " + i + " is " + distanceToCup + " meters.");
		}    
}

