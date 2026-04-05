// Main.java
// Test cases for the Online Voting System

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Online Voting System ===\n");

        // ── Step 1: Create Admin ──────────────────
        Admin admin = new Admin("A01", "Priya");
        admin.display();

        // ── Step 2: Create Election ───────────────
        Election election = new Election("E01", "School Election 2024");

        // ── Step 3: Add Candidates ────────────────
        System.out.println();
        Candidate c1 = new Candidate("C01", "Raj",   "Blue Party");
        Candidate c2 = new Candidate("C02", "Meena", "Green Party");
        Candidate c3 = new Candidate("C03", "Arjun", "Red Party");

        admin.addCandidate(election, c1);
        admin.addCandidate(election, c2);
        admin.addCandidate(election, c3);

        // ── Step 4: Open Election ─────────────────
        System.out.println();
        admin.openElection(election);

        // ── Step 5: Create Voters ─────────────────
        System.out.println();
        Voter v1 = new Voter("V01", "Alice");
        Voter v2 = new Voter("V02", "Bob");
        Voter v3 = new Voter("V03", "Carol");
        Voter v4 = new Voter("V04", "Dave");

        // ── Step 6: Cast Votes ────────────────────
        System.out.println();
        v1.castVote(election, "C01");   // Alice votes Raj
        v2.castVote(election, "C02");   // Bob votes Meena
        v3.castVote(election, "C01");   // Carol votes Raj
        v4.castVote(election, "C03");   // Dave votes Arjun

        // ── Test: Vote again (should be blocked) ──
        System.out.println();
        v1.castVote(election, "C02");   // Alice tries again — blocked!

        // ── Test: Wrong candidate ID ──────────────
        System.out.println();
        Voter v5 = new Voter("V05", "Eve");
        v5.castVote(election, "C99");   // Invalid ID

        // ── Step 7: Show Results ──────────────────
        election.showResults();

        // ── Step 8: Show Winner ───────────────────
        election.showWinner();

        // ── Step 9: Close Election ────────────────
        System.out.println();
        admin.closeElection(election);

        // ── Test: Vote after election closed ──────
        Voter v6 = new Voter("V06", "Frank");
        v6.castVote(election, "C01");   // Should be blocked

        System.out.println("\n=== Done ===");
    }
}
