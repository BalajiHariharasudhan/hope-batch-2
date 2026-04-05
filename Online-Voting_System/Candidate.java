// Candidate.java
// Stores candidate name, party, and vote count

public class Candidate {

    String candidateId;
    String name;
    String party;
    int voteCount;

    // Constructor
    Candidate(String candidateId, String name, String party) {
        this.candidateId = candidateId;
        this.name = name;
        this.party = party;
        this.voteCount = 0;
    }

    // Add one vote to this candidate
    void addVote() {
        voteCount++;
    }

    // Display candidate info
    void display() {
        System.out.println(candidateId + " | " + name + " (" + party + ") - Votes: " + voteCount);
    }
}
