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
 * and how far the ball traveled each time. 
 * If the ball moves too far away from the cup, the game should generate an error that 
 * takes you out of the game loop, with a failure message. 
 * If too many swings have been taken, the game should end, with a different failure message.
 */

public class Golf {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static boolean menu () {									//method: menu
		boolean valid = false;
		System.out.println("\n******************************");
		System.out.println("* Do you want to play? (Y/N) *");
		System.out.println("******************************");
		String golf = getStringFromUser();						
	return valid = playing(golf);
	}
	
	public static boolean playing(String answer) {					//method Y/N
		String upperCaseString = answer.toUpperCase();				//String to Upper Case
		switch(upperCaseString) {
			case "Y":
				double distanceToCup = 300;	//Start value: distance to cup is 300 meters
				System.out.println("The Golf game consists of maximum 7 swings");
				System.out.println("If the ball moves too far away from the cup, the game ends \n");
				System.out.println("Distance to the cup is 300 meters.");
				return true;
			default:
				return false;
		}
	}	
	
	private static String getStringFromUser() {						//method: getStringFromUser	
		String text = scanner.nextLine();
	return text;
	}
	
	private static double getDoubleFromUser() {						//method: getDoubleFromUser
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
	
	public static double roundDecimalNumber(double decimalNr) {		//method: rounding a decimal number
		double roundedNr = Math.round(decimalNr * 10.0)/10.0;
	return roundedNr;
	}
	
	public static double swing (int i) {							//method for a swing, return distance
		double [] distance = new double [7];
		System.out.println("Swing no " + (i+1) + ": Enter your velocity (m/s):");				
		double velocity = getDoubleFromUser();
		System.out.println("Enter your angle");				
		double angle = getDoubleFromUser();
	return distance[i] = calculateDistance(velocity, angle); 	//Calculate distance
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
	
	public static double angleInRadians(double angle) {				//method: calculate angle in radians
		double angInRad = (Math.PI/180) * angle;
	return angInRad;
	}
	
	//*************************************** MAIN *****************************************************
	
	public static void main( String[] args ){
		int i = 0;
		double distanceToCup = 300;
		double [] distance = new double [7];
		boolean valid;
		
		System.out.println("This is a simplified Golf-game");
		valid = menu();
		
		while (valid) {
	
				distance[i] = swing (i);
				distanceToCup = Math.abs(distanceToCup - distance[i]);	//No negative numbers
				
				if (distanceToCup <= 0.1) {
					System.out.println("Congratulations. You won!!!");
					System.out.println("Your result: \n");
					int j = i;
					for (i = 0; i <= j; i++ ) {
						System.out.println("Swing no " +  (i +1) + ": " + roundDecimalNumber(distance[i]) + " meters");
					}
					System.out.println();
					valid = menu();
				} else if (distanceToCup > 400){							//Ball moved way too far
						System.out.println("The ball moved outside of the playing field");
					valid = menu();
				} else {
					System.out.println("The length of your swing was: " + roundDecimalNumber(distance[i]) + " meters");
					System.out.println("Distance to the cup after swing no: " + (i+1) + " is " + roundDecimalNumber(distanceToCup) + " meters.");
					i++;
				}
			
				//Too many swings?
				if (i > 6) {
					System.out.println("You have used the maximum number of swings");
					valid = menu();
				}
		}
		
		// Player do NOT want to play or the game has ended
		System.out.println("Welcome back!");
	}
	    
}

