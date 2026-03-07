package rpg.lab03;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int maxHealthPoint, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHealthPoint, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Character target) {
        System.out.println("\n--- " + getName() + "'s Turn ---");
        System.out.println(" (Using Archer.attack() - Ranged arrow attack with accuracy)");
        System.out.println("\n" + getName() + " shoots an arrow at " + target.getName() + " with " + accuracy + "% accuracy!");
        System.out.println("   Raw Attack Damage: " + getDamage());
        target.receiveDamage(getDamage());
    }
    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Accuracy: " + accuracy + "%");
    }
}