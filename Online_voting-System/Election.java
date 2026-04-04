package votingsystem.model;

import votingsystem.enums.ElectionStatus;
import votingsystem.extra.VoteAuditLog;
import votingsystem.interfaces.Votable;

import java.util.*;

/**
 * Election — represents a single election event.
 * Implements Votable (Polymorphism + Abstraction).
 * Manages candidates, status, results, and audit logging.
 */
public class Election implements Votable {

    private final String           electionId;
    private final String           title;
    private       ElectionStatus   status;
    private final List<Candidate>  candidates = new ArrayList<>();
    private final VoteAuditLog     auditLog   = new VoteAuditLog();

    public Election(String electionId, String title) {
        if (electionId == null || title == null)
            throw new IllegalArgumentException("Election ID and title cannot be null.");
        this.electionId = electionId;
        this.title      = title;
        this.status     = ElectionStatus.UPCOMING;
    }

    public String          getElectionId() { return electionId; }
    public String          getTitle()      { return title; }
    public ElectionStatus  getStatus()     { return status; }

    public void setStatus(ElectionStatus status) {
        this.status = status;
    }

    /**
     * Adds a candidate. Only allowed before the election is CLOSED.
     */
    public void addCandidate(Candidate candidate) {
        if (status == ElectionStatus.CLOSED)
            throw new IllegalStateException("Cannot add candidates to a closed election.");
        candidates.add(candidate);
    }

    /**
     * Polymorphic vote() from Votable — validates status and candidate existence.
     */
    @Override
    public boolean vote(String candidateId) {
        return vote(candidateId, "unknown");
    }

    /**
     * Overloaded vote() — also records the voterId in the audit log.
     */
    public boolean vote(String candidateId, String voterId) {
        if (status != ElectionStatus.ONGOING)
            throw new IllegalStateException(
                "Election '" + title + "' is not currently ONGOING. Status: " + status);

        Optional<Candidate> match = candidates.stream()
                .filter(c -> c.getCandidateId().equals(candidateId))
                .findFirst();

        if (match.isEmpty()) {
            System.out.println("[ERROR] Candidate not found: " + candidateId);
            return false;
        }

        match.get().incrementVote();
        auditLog.logVote(voterId, candidateId);
        return true;
    }

    /**
     * Returns results sorted by vote count (highest first).
     */
    public Map<String, Integer> getResults() {
        Map<String, Integer> results = new LinkedHashMap<>();
        candidates.stream()
                  .sorted(Comparator.comparingInt(Candidate::getVoteCount).reversed())
                  .forEach(c -> results.put(c.getName() + " (" + c.getParty() + ")",
                                            c.getVoteCount()));
        return results;
    }

    public void printResults() {
        System.out.println("\n=== Results: " + title + " ===");
        getResults().forEach((name, votes) ->
            System.out.println("  " + name + " : " + votes + " vote(s)"));
        System.out.println("==============================");
    }

    public void printAuditLog() {
        auditLog.printLogs();
    }
}
