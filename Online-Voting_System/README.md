# 🗳️ Online Voting System

A simple Java OOP project for an online voting system.

---

## 📁 Project Structure

```
OnlineVotingSystem/
└── src/
    ├── Admin/
    │   └── Admin.java          # Opens/closes elections, adds candidates
    ├── Candidate/
    │   └── Candidate.java      # Stores name, party, and vote count
    ├── Election/
    │   └── Election.java       # Manages voting and results
    ├── Voter/
    │   └── Voter.java          # Casts a vote (only once)
    └── Main/
        └── Main.java           # Runs all the test cases
```

---

## 🧠 OOP Concepts Used

| Concept       | Where                                          |
|---------------|------------------------------------------------|
| Class         | Candidate, Voter, Admin, Election              |
| Object        | c1, v1, admin, election (created in Main)      |
| Encapsulation | Each class manages its own data and methods    |
| Inheritance   | Not used here (kept simple on purpose)         |

---

## ▶️ How to Run

Put all `.java` files in the same folder, then:

```bash
# Compile
javac Candidate.java Voter.java Admin.java Election.java Main.java

# Run
java Main
```

---

## ✅ What Gets Tested

1. Create Admin, Candidates, Voters
2. Admin adds candidates to election
3. Admin opens the election
4. Voters cast their votes
5. Duplicate vote → blocked
6. Wrong candidate ID → error message
7. Show results
8. Show winner
9. Admin closes election
10. Vote after close → blocked

---

## 👩‍💻 Author

Java OOP Assignment — Task 40: Online Voting System
