package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions

	private final Map<String,Student> things;
	
	public UniversityDatabase() {
		things = new HashMap<>();
	}
	
	
	public void addStudent(String accountName, Student student) {
		things.put(accountName, student);
	}

	public int getStudentCount() {
		// TODO
		return things.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if(things.get(accountName) == null) {
			return null;
		}
		return things.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		// TODO
		double count = 0;
		for(String name : things.keySet()) {
			count += things.get(name).getBearBucksBalance();
		}
		return count;
	}
}
