package votingsystem.model;

/**
 * Person — abstract base class for all users in the system.
 * Demonstrates Abstraction and Encapsulation.
 */
public abstract class Person {

    private String name;   // Encapsulated — only accessible via getter
    private String email;

    public Person(String name, String email) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty.");
        if (!email.contains("@"))
            throw new IllegalArgumentException("Invalid email: " + email);
        this.name  = name;
        this.email = email;
    }

    public String getName()  { return name; }
    public String getEmail() { return email; }

    /**
     * Polymorphic method — each subclass provides its own implementation.
     */
    public abstract String getInfo();
}
