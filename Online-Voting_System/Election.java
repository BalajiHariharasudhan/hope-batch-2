// Election.java
// Holds all candidates and handles the voting logic

import java.util.ArrayList;

public class Election {

    String electionId;
    String title;
    boolean isOpen;
    ArrayList<Candidate> candidates;

    // Constructor
    Election(String electionId, String title) {
        this.electionId = electionId;
        this.title = title;
        this.isOpen = false;
        this.candidates = new ArrayList<>();
    }

    // Record a vote for a candidate by ID
    boolean recordVote(String candidateId) {
        if (!isOpen) {
            System.out.println("Election is not open right now.");
            return false;
        }

        for (Candidate c : candidates) {
            if (c.candidateId.equals(candidateId)) {
                c.addVote();
                return true;
            }
        }

        System.out.println("Candidate not found: " + candidateId);
        return false;
    }

    // Show all candidates and their vote counts
    void showResults() {
        System.out.println("\n--- Results: " + title + " ---");
        for (Candidate c : candidates) {
            c.display();
        }
        System.out.println("--------------------------------");
    }

    // Show the winner (candidate with highest votes)
    void showWinner() {
        Candidate winner = candidates.get(0);
        for (Candidate c : candidates) {
            if (c.voteCount > winner.voteCount) {
                winner = c;
            }
        }
        System.out.println("Winner: " + winner.name + " (" + winner.party + ") with " + winner.voteCount + " votes!");
    }
}
