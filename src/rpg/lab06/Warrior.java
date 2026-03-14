package rpg.lab06;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHealthPoint, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHealthPoint, defense, weapon, "Warrior");
        this.armorValue = armorValue;
        setAttack(new WarriorStyleDecorator(getAttack())); // สวม Decorator
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