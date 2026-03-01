package rpg.lab04;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHealthPoint, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHealthPoint, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Destructible target) {
        System.out.println("\n--- " + getName() + "'s Turn ---");
        System.out.println(" (Using Warrior.attack() - 1.5x damage bonus)");
        int boostedDamage = (int)(getDamage() * 1.5);
        System.out.println("\n" + getName() + " (" + getCharacterClass() + ") attacks Target with " + getWeapon().getName());
        System.out.println("   Raw Attack Damage: " + boostedDamage);
        target.takeDamage(boostedDamage);
    }
    @Override
    public void receiveDamage(int incomingDamage) {
        System.out.println("   " + getName() + "'s Armor: " + armorValue + " (absorbs incoming damage)");
        int reducedDamage = incomingDamage - armorValue;
        if (reducedDamage < 0) reducedDamage = 0;
        super.receiveDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Armor Value: " + armorValue);
    }
}