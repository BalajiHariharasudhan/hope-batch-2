// Admin.java
// Admin can add candidates and open/close elections

public class Admin {

    String adminId;
    String name;

    // Constructor
    Admin(String adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    // Add a candidate to an election
    void addCandidate(Election election, Candidate candidate) {
        election.candidates.add(candidate);
        System.out.println("[Admin] " + name + " added candidate: " + candidate.name);
    }

    // Open the election so voting can begin
    void openElection(Election election) {
        election.isOpen = true;
        System.out.println("[Admin] " + name + " opened the election: " + election.title);
    }

    // Close the election — no more votes accepted
    void closeElection(Election election) {
        election.isOpen = false;
        System.out.println("[Admin] " + name + " closed the election: " + election.title);
    }

    // Display admin info
    void display() {
        System.out.println("Admin: " + name + " (ID: " + adminId + ")");
    }
}
