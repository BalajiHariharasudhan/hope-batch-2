package votingsystem.model;

/**
 * Candidate — a person standing in an election.
 * Encapsulates vote count — only incrementable through its own method.
 */
public class Candidate {

    private final String candidateId;
    private final String name;
    private final String party;
    private       int    voteCount;

    public Candidate(String candidateId, String name, String party) {
        if (candidateId == null || name == null || party == null)
            throw new IllegalArgumentException("Candidate fields cannot be null.");
        this.candidateId = candidateId;
        this.name        = name;
        this.party       = party;
        this.voteCount   = 0;
    }

    public String getCandidateId() { return candidateId; }
    public String getName()        { return name; }
    public String getParty()       { return party; }
    public int    getVoteCount()   { return voteCount; }

    /** Only way to increase vote count — no direct setter. */
    public void incrementVote() { voteCount++; }

    @Override
    public String toString() {
        return candidateId + " | " + name + " (" + party + ") — Votes: " + voteCount;
    }
}
