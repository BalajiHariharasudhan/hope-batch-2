// Voter.java
// Represents a voter who can vote once in an election

public class Voter {

    String voterId;
    String name;
    boolean hasVoted;

    // Constructor
    Voter(String voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    // Cast a vote in an election
    void castVote(Election election, String candidateId) {
        if (hasVoted) {
            System.out.println("Sorry! " + name + " has already voted.");
            return;
        }

        boolean success = election.recordVote(candidateId);
        if (success) {
            hasVoted = true;
            System.out.println(name + " voted successfully!");
        }
    }

    // Display voter info
    void display() {
        System.out.println("Voter: " + name + " (ID: " + voterId + ") | Voted: " + hasVoted);
    }
}
