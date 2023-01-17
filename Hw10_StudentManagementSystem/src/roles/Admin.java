package roles;

public class Admin extends Users {
	
	// instance variables 
	public String adminId;
	
	/**
	 * Constructor for the Admin class
	 * @param Id of the Admin
	 * @param name of the Admin
	 * @param user of the Admin
	 * @param pass :The password of the Admin
	 */
	public Admin(String Id, String name, String user, String pass) {
		super(name, user, pass);
		this.adminId = Id;
	}

	
	/**
	 * This method prints the options that are available to admin users of the system
	 */
	@Override
	public void printOptions() {
		System.out.println("---------------------------");
		System.out.println("welcome, " + this.name);
		System.out.println("---------------------------");
		System.out.println(" 1 -- View all courses");
		System.out.println(" 2 -- Add new courses");
		System.out.println(" 3 -- Delete courses");
		System.out.println(" 4 -- Add new professor");
		System.out.println(" 5 -- Delete professor");
		System.out.println(" 6 -- Add new student");
		System.out.println(" 7 -- Delete student");
		System.out.println(" 8 -- Return to previous menu");
		System.out.println("");
	}

	@Override
	void printGrades() {}
}
