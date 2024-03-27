package Java;

public class Singleton {
	
	// Private static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        System.out.println("Welcome to singleton class");
    }

    // Static method to get the singleton instance
    public static Singleton getSingletonInstance() {
        // Check if the instance is null 
        if (instance == null) {
            // Create a new instance if it doesn't exist
            instance = new Singleton();
        }
        // Return the singleton instance
        return instance;
    }

	public static void main(String[] args) {
		Singleton st = Singleton.getSingletonInstance();
	}

}
