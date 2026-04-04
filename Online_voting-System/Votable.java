package votingsystem.interfaces;

/**
 * Votable interface — any entity that supports voting must implement this.
 * Demonstrates Abstraction and Polymorphism.
 */
public interface Votable {
    boolean vote(String candidateId);
}
