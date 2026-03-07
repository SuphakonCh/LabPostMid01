package rpg.lab03;

public class Mage extends Character {
    private int mana;

    public Mage(String name, int level, int maxHealthPoint, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHealthPoint, defense, weapon, "Mage");
        this.mana = mana;
    }

    @Override
    public void attack(Character target) {
        System.out.println("\n--- " + getName() + "'s Turn ---");
        System.out.println(" (Using Mage.attack() - Magic Missile spell)");
        System.out.println("\n" + getName() + " casts Magic Missile on " + target.getName() + "!");
        System.out.println("   Raw Attack Damage: " + getDamage());
        target.receiveDamage(getDamage());
    }
    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Mana: " + mana);
    }
}