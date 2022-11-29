package assignment7;

public class Student {
	
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
	
	/**
	 * 
	 * @param firstName of student
	 * @param lastName of student
	 * @param id of student
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.attemptedCredits = 0;
		this.passingCredits = 0;
		this.totalGradeQualityPoints = 0;
		this.bearBucksBalance = 0;
		
	}
	
	/**
	 * 
	 * @return full name of student
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	/**
	 * 
	 * @return first name of student
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @param first name of student
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return last name of student
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param last name of student
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return id number of student
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * 
	 * @param grade of student
	 * @param credits of class student took
	 */
	public void submitGrade(double grade, int credits) {
		
			if (grade >= 1.7) {
				passingCredits += credits;
				attemptedCredits += credits;
				totalGradeQualityPoints += grade*credits;
			}
			else {
				attemptedCredits += credits;
				totalGradeQualityPoints += grade*credits;
			}
			
		
	}
	/**
	 * 
	 * @return attempted credits
	 */
	public int getAttemptedCredits() {
		return this.attemptedCredits;
	}
	/**
	 * 
	 * @return passing credits
	 */
	public int getPassingCredit() {
		return passingCredits;
	}
	/**
	 * 
	 * @return total grade quality points
	 */
	public double getTotalGradeQualityPoints() {
		return this.totalGradeQualityPoints;
	}
	/**
	 * 
	 * @param total grade quality points
	 */
	public void setTotalGradeQualityPoints(double totalGradeQualityPoints) {
		this.totalGradeQualityPoints = totalGradeQualityPoints;
	}
	/**
	 * 
	 * @return bear bucks balance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	/**
	 * 
	 * @param bear bucks balance
	 */
	public void setBearBucksBalance(double bearBucksBalance) {
		this.bearBucksBalance = bearBucksBalance;
	}
	
	/**
	 * 
	 * @return GPA of student
	 */
	public double calculateGradePointAverage() {
		double gpa =  (double) this.totalGradeQualityPoints /this.attemptedCredits;
		return gpa;
	}
	/**
	 * 
	 * @return what year the student is in
	 */
	public String getClassStanding() {
		if(getPassingCredit() < 30) {
			return "First Year";
		}
		else if(getPassingCredit() >= 30 && getPassingCredit() < 60) {
			return "Sophomore";
		}
		else if(getPassingCredit() >= 60 && getPassingCredit() < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	/**
	 * 
	 * @return whether the student is eligible for phi beta kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if(getPassingCredit() >= 98 && calculateGradePointAverage() >= 3.6) {
			return true;
		}
		else if(getPassingCredit() >= 75 && calculateGradePointAverage() >= 3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * \
	 * @param amount to deposit
	 */
	public void depositBearBucks(double amount) {
		setBearBucksBalance(getBearBucksBalance() + amount);
	}
	/**
	 * 
	 * @param amount to withdraw
	 */
	public void deductBearBucks(double amount) {
		setBearBucksBalance(getBearBucksBalance() - amount);
	}
	/**
	 * 
	 * @return amount someone can cash out of their balance
	 */
	public double cashOutBearBucks() {
		double x = getBearBucksBalance();
		setBearBucksBalance(0);
		if(x > 10) {
			return x - 10;
		}
		else {
			return 0;
		}
	}
	/**
	 * 
	 * @param firstName of new student
	 * @param other name of parent
	 * @param isHyphenated whether a students last name is hyphenated
	 * @param id of new student
	 * @return the new student
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		if(isHyphenated) {
			Student child = new Student(firstName,this.lastName + "-" + other.lastName,id);
			child.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
			return child;
		}
		else {
			Student child = new Student(firstName,this.lastName,id);
			child.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
			return child;
		}
		
	}
	/**
	 * @return the students name and id
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + this.id;
	}


	
	
	
	
}
