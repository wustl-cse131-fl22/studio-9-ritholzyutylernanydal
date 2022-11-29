package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<String, Integer> heights = new HashMap<>();
		heights.put("Jacob",73);
		heights.put("Ryan", 73);
		heights.put("Arya", 72);
		heights.put("Andrew", 65);
		
		String input = "";
		while(!input.equals("Quit")) {
			System.out.println("whose height do you want to know");
			input = in.next();
			if(input.equals("Quit")) {
				
			}
			else if(heights.get(input) == null) {
				System.out.println("Name does not exist");
			}
			else {
				System.out.println(input + "'s height is " + heights.get(input));
			}
		}
				
	}
}
