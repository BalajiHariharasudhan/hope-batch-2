# Online Voting System — Java OOP Project

## Project Structure

```
OnlineVotingSystem/
└── src/
    └── votingsystem/
        ├── enums/
        │   └── ElectionStatus.java       # UPCOMING, ONGOING, CLOSED
        ├── interfaces/
        │   └── Votable.java              # Interface for vote() method
        ├── model/
        │   ├── Person.java               # Abstract base class
        │   ├── Voter.java                # Extends Person — casts votes
        │   ├── Admin.java                # Extends Person — manages elections
        │   ├── Candidate.java            # Stands in an election
        │   └── Election.java             # Implements Votable
        ├── extra/
        │   └── VoteAuditLog.java         # Extra feature: audit trail
        └── main/
            └── Main.java                 # Entry point + 12 test cases
```

## OOP Concepts Covered

| Concept        | Where Used                                        |
|----------------|---------------------------------------------------|
| Encapsulation  | All fields private; access via getters only       |
| Inheritance    | Voter and Admin both extend Person                |
| Polymorphism   | getInfo() overridden per subclass; Votable vote() |
| Abstraction    | Person (abstract class) + Votable (interface)     |
| Extra Feature  | VoteAuditLog — timestamped, append-only log       |

## How to Compile and Run

```bash
# From the OnlineVotingSystem/ directory:

# Step 1: Compile all files
javac -d out src/votingsystem/enums/*.java \
             src/votingsystem/interfaces/*.java \
             src/votingsystem/extra/*.java \
             src/votingsystem/model/*.java \
             src/votingsystem/main/*.java

# Step 2: Run
java -cp out votingsystem.main.Main
```

## Test Cases (12 total)

1. Create entities (Admin, Voters, Candidates, Election)
2. Admin adds candidates to election
3. Voters cast votes normally
4. Duplicate vote prevention
5. Invalid candidate ID handling
6. Election results (sorted by votes)
7. Audit log output
8. Admin closes election
9. Vote after election is closed
10. Low-access admin tries to close (SecurityException)
11. Polymorphism — getInfo() across Person list
12. Input validation (empty name, bad email)
