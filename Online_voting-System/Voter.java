package votingsystem.model;

/**
 * Voter — a registered voter who can cast one vote per election.
 * Inherits from Person. Demonstrates Inheritance and Encapsulation.
 */
public class Voter extends Person {

    private final String  voterId;
    private       boolean hasVoted;
    private final String  constituency;

    public Voter(String name, String email, String voterId, String constituency) {
        super(name, email);
        if (voterId == null || voterId.isBlank())
            throw new IllegalArgumentException("Voter ID cannot be empty.");
        this.voterId      = voterId;
        this.hasVoted     = false;
        this.constituency = constituency;
    }

    public String  getVoterId()      { return voterId; }
    public boolean hasVoted()        { return hasVoted; }
    public String  getConstituency() { return constituency; }

    /**
     * Casts a vote for the given candidate in the given election.
     * Enforces one-vote-per-voter rule.
     */
    public void castVote(Election election, String candidateId) {
        if (hasVoted)
            throw new IllegalStateException(
                "Voter " + voterId + " has already voted in this election.");

        if (election.vote(candidateId, voterId)) {
            hasVoted = true;
            System.out.println("[VOTE] " + getName() + " voted successfully.");
        }
    }

    @Override
    public String getInfo() {
        return "Voter [" + voterId + "] " + getName()
               + " | Constituency: " + constituency
               + " | Voted: " + hasVoted;
    }
}
