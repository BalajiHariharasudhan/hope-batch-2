class Character {
    String name;

    Character(String name) {
        this.name = name;
    }

    void attack(Character opponent) {
        System.out.println(name + " attacks " + opponent.name + "!");
    }

    void display() {
        System.out.println("Character: " + name);
    }
}

class Warrior extends Character {
    Warrior() {
        super("Warrior");
    }

    @Override
    void attack(Character opponent) {
        System.out.println(name + " attacks with a sword!");
    }
}

class Archer extends Character {
    Archer() {
        super("Archer");
    }

    @Override
    void attack(Character opponent) {
        System.out.println(name + " attacks with an arrow!");
    }
}

class Mage extends Character {
    Mage() {
        super("Mage");
    }

    @Override
    void attack(Character opponent) {
        System.out.println(name + " attacks with magic!");
    }
}

public class Game {
    public static void main(String[] args) {
        // Create characters
        Character warrior = new Warrior();
        Character archer = new Archer();
        Character mage = new Mage();

        // Display characters
        warrior.display();
        archer.display();
        mage.display();

        // Use polymorphism to attack
        warrior.attack(archer);  // Warrior attacks Archer
        archer.attack(mage);   // Archer attacks Mage
        mage.attack(warrior);   // Mage attacks Warrior
    }
}
