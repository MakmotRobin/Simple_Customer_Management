class Manager extends Person {
    private static int idCounter = 0; // Static counter for generating manager IDs  
    private final int managerId;
    private int actionNumber;

    public Manager(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.managerId = ++idCounter; // Increment and assign ID  
        this.actionNumber = 0; // Initialize actionNumber to 0  
    }

    public int getActionNumber() {
        return actionNumber;
}

    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    public int getManagerId() {
        return managerId;
    }

    @Override
    public String toString() {
        return String.format("Manager ID: %d, %s", managerId, super.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Manager other = (Manager) obj;
        return (getUsername().equals(other.getUsername()) && getPassword().equals(other.getPassword())) ||
                (this.managerId == other.managerId && getPassword().equals(other.getPassword()));
    }

    // Main method for testing  
    public static void main(String[] args) {
        Manager manager1 = new Manager("Charlie", 40, "charlie123", "password456");
        Manager manager2 = new Manager("Diana", 35, "diana456", "mypassword");
        Manager manager3 = new Manager("Charlie", 40, "charlie123", "password456");

        // Print manager details  
        System.out.println(manager1);  // Output: Manager ID: 1, Name: Charlie, Age: 40  

        // Check equality  
        System.out.println(manager1.equals(manager3));  // Output: true  
        System.out.println(manager1.equals(manager2));  // Output: false  

        // Set and get action number  
        manager1.setActionNumber(5);
        System.out.println("Action Number: " + manager1.getActionNumber()); // Output: Action Number: 5  
    }
}