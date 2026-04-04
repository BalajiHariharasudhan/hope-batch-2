package votingsystem.model;

/**
 * Admin — manages elections and candidates.
 * Inherits from Person. Access level controls permissions.
 * Demonstrates Inheritance and Encapsulation.
 */
public class Admin extends Person {

    private final String adminId;
    private final int    accessLevel; // 1 = viewer, 2 = manager, 3 = super admin

    public Admin(String name, String email, String adminId, int accessLevel) {
        super(name, email);
        if (accessLevel < 1 || accessLevel > 3)
            throw new IllegalArgumentException("Access level must be between 1 and 3.");
        this.adminId     = adminId;
        this.accessLevel = accessLevel;
    }

    public String getAdminId()     { return adminId; }
    public int    getAccessLevel() { return accessLevel; }

    /**
     * Adds a candidate to an election.
     * Requires access level >= 2.
     */
    public void addCandidate(Election election, Candidate candidate) {
        if (accessLevel < 2)
            throw new SecurityException(
                "Admin " + adminId + " lacks permission to add candidates.");
        election.addCandidate(candidate);
        System.out.println("[ADMIN] " + getName() + " added candidate: " + candidate.getName());
    }

    /**
     * Closes an election permanently.
     * Requires access level == 3 (super admin only).
     */
    public void closeElection(Election election) {
        if (accessLevel < 3)
            throw new SecurityException("Only super-admins can close elections.");
        election.setStatus(votingsystem.enums.ElectionStatus.CLOSED);
        System.out.println("[ADMIN] " + getName() + " closed election: " + election.getTitle());
    }

    @Override
    public String getInfo() {
        return "Admin [" + adminId + "] " + getName() + " | Access Level: " + accessLevel;
    }
}
