import java.util.concurrent.atomic.AtomicInteger;

class Person {
    private String name;
    private int age;
    private String username;
    private String password;

    public Person(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return username.equals(other.username) && password.equals(other.password);
    }

    // Getters  
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Customer extends Person {
    private static final AtomicInteger idGenerator = new AtomicInteger(0); // Atomic to handle concurrent generation  
    private final int customerID;
    private double balance;

    public Customer(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.customerID = idGenerator.incrementAndGet(); // Generate ID  
        this.balance = 0.0; // Initialize balance to 0  
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d, %s", customerID, super.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return (getUsername().equals(other.getUsername()) && getPassword().equals(other.getPassword())) ||
                (this.customerID == other.customerID && getPassword().equals(other.getPassword()));
    }

    // Main method for testing  
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", 30, "alice123", "password123");
        Customer customer2 = new Customer("Bob", 25, "bob456", "securepassword");
        Customer customer3 = new Customer("Alice", 30, "alice123", "password123");

        // Print customer details  
        System.out.println(customer1);  // Output: Customer ID: 1, Name: Alice, Age: 30  

        // Check equality  
        System.out.println(customer1.equals(customer3));  // Output: true  
        System.out.println(customer1.equals(customer2));  // Output: false  

        // Set and get balance  
        customer1.setBalance(100.0);
        System.out.println("Balance: " + customer1.getBalance()); // Output: Balance: 100.0  
    }
}