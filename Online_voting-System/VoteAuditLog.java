package votingsystem.extra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * VoteAuditLog — extra feature: immutable, append-only log of every vote cast.
 * Useful for post-election auditing and transparency.
 */
public class VoteAuditLog {

    private final List<String> logs = new ArrayList<>();

    /**
     * Records a timestamped entry for each vote.
     */
    public void logVote(String voterId, String candidateId) {
        String entry = "[" + LocalDateTime.now() + "]"
                     + "  Voter: " + voterId
                     + "  ->  Candidate: " + candidateId;
        logs.add(entry);
    }

    /**
     * Prints all audit entries to the console.
     */
    public void printLogs() {
        System.out.println("\n=== Audit Log ===");
        if (logs.isEmpty()) {
            System.out.println("  No votes recorded yet.");
        } else {
            logs.forEach(entry -> System.out.println("  " + entry));
        }
        System.out.println("=================");
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs); // Defensive copy — original list stays immutable
    }
}
