package votingsystem.main;

import votingsystem.enums.ElectionStatus;
import votingsystem.model.*;

import java.util.List;

/**
 * Main — entry point and test cases for the Online Voting System.
 * Run: javac -d out src/votingsystem/**\/*.java && java -cp out votingsystem.main.Main
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("  Online Voting System — Test Cases  ");
        System.out.println("======================================\n");

        // ── Test 1: Create entities ──────────────────────────
        System.out.println("--- Test 1: Create entities ---");
        Admin  admin  = new Admin("Priya Admin", "priya@vote.in", "A001", 3);
        Voter  alice  = new Voter("Alice",  "alice@mail.com",  "V001", "North");
        Voter  bob    = new Voter("Bob",    "bob@mail.com",    "V002", "North");
        Voter  carol  = new Voter("Carol",  "carol@mail.com",  "V003", "South");

        Candidate c1 = new Candidate("C001", "Raj Kumar",  "Blue Party");
        Candidate c2 = new Candidate("C002", "Meena Iyer", "Green Party");
        Candidate c3 = new Candidate("C003", "Arjun Nair", "Red Party");

        Election election = new Election("E2024", "General Election 2024");
        System.out.println("Created: " + admin.getInfo());
        System.out.println("Created: " + alice.getInfo());

        // ── Test 2: Admin adds candidates ────────────────────
        System.out.println("\n--- Test 2: Admin adds candidates ---");
        election.setStatus(ElectionStatus.ONGOING);
        admin.addCandidate(election, c1);
        admin.addCandidate(election, c2);
        admin.addCandidate(election, c3);

        // ── Test 3: Normal voting ─────────────────────────────
        System.out.println("\n--- Test 3: Voters cast votes ---");
        alice.castVote(election, "C001");
        bob.castVote(election, "C002");
        carol.castVote(election, "C001");

        // ── Test 4: Duplicate vote prevention ────────────────
        System.out.println("\n--- Test 4: Duplicate vote attempt ---");
        try {
            alice.castVote(election, "C002");
        } catch (IllegalStateException e) {
            System.out.println("[CAUGHT] " + e.getMessage());
        }

        // ── Test 5: Invalid candidate ─────────────────────────
        System.out.println("\n--- Test 5: Invalid candidate ---");
        Voter dave = new Voter("Dave", "dave@mail.com", "V004", "East");
        dave.castVote(election, "C999"); // prints error but does not throw

        // ── Test 6: Election results ──────────────────────────
        System.out.println("\n--- Test 6: Election results ---");
        election.printResults();

        // ── Test 7: Audit log ─────────────────────────────────
        System.out.println("\n--- Test 7: Audit log ---");
        election.printAuditLog();

        // ── Test 8: Admin closes election ─────────────────────
        System.out.println("\n--- Test 8: Close election ---");
        admin.closeElection(election);
        System.out.println("Status: " + election.getStatus());

        // ── Test 9: Vote after election closed ────────────────
        System.out.println("\n--- Test 9: Vote after election is closed ---");
        Voter eve = new Voter("Eve", "eve@mail.com", "V005", "West");
        try {
            eve.castVote(election, "C001");
        } catch (IllegalStateException e) {
            System.out.println("[CAUGHT] " + e.getMessage());
        }

        // ── Test 10: Low-access admin tries to close ──────────
        System.out.println("\n--- Test 10: Low-access admin closes election ---");
        Admin junior = new Admin("Junior", "j@vote.in", "A002", 1);
        try {
            junior.closeElection(election);
        } catch (SecurityException e) {
            System.out.println("[CAUGHT] " + e.getMessage());
        }

        // ── Test 11: Polymorphism — Person list ───────────────
        System.out.println("\n--- Test 11: Polymorphism — getInfo() on each Person ---");
        List<Person> people = List.of(alice, bob, carol, admin);
        people.forEach(p -> System.out.println("  " + p.getInfo()));

        // ── Test 12: Input validation ─────────────────────────
        System.out.println("\n--- Test 12: Invalid voter input ---");
        try {
            new Voter("", "bad-email", "V999", "X");
        } catch (IllegalArgumentException e) {
            System.out.println("[CAUGHT] " + e.getMessage());
        }

        System.out.println("\n======================================");
        System.out.println("  All test cases complete.           ");
        System.out.println("======================================");
    }
}
