package rpg.lab02;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoint;
    private int defense; // [Requirement] เพิ่ม Defense
    private Weapon weapon;
    private String characterClass;
    private int damage;

    public Character(String name, int level, int maxHealthPoint, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = maxHealthPoint;
        this.maxHealthPoint = maxHealthPoint;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.damage = weapon.getDamage() + (level * 2);
    }

    public void displayCharacterDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("  Class: " + characterClass);
        System.out.println("  Status: " + (healthPoints > 0 ? "Active" : "Fainted"));
        System.out.println("  Level: " + level);
        System.out.println("  Health Points: " + healthPoints + "/" + maxHealthPoint);
        System.out.println("  Damage: " + damage);
        System.out.println("  Defense: " + defense);
        System.out.println("    Weapon: " + weapon.toString());
    }

    public void attack(Character target) {
        System.out.println("\n" + name + " (" + characterClass + ") attacks " + target.getName() + " with " + weapon.getName() + "!");
        System.out.println("   Raw Attack Damage: " + damage);
        target.takeDamage(this.damage);
    }

    public void takeDamage(int incomingDamage) {
        System.out.println("   " + name + "'s Defense: " + defense + " (reduces damage by " + defense + ")");

        int actualDamage = incomingDamage - defense;
        if (actualDamage < 0) actualDamage = 0;

        System.out.println("   Actual Damage Taken: " + actualDamage);

        healthPoints -= actualDamage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        System.out.println("   " + name + "'s HP: " + healthPoints + "/" + maxHealthPoint);
    }

    public void levelUp() {
        level++;
        int healthIncrease = 10;
        maxHealthPoint += healthIncrease;
        healthPoints = maxHealthPoint;
        this.damage = weapon.getDamage() + (level * 2);
        System.out.println("\n" + name + " leveled up to Level " + level + "!");
        System.out.println("   Max health increased to " + maxHealthPoint + " (full heal applied)");
    }

    public void heal(int healingPoint) {
        this.healthPoints += healingPoint;
        if (this.healthPoints > this.maxHealthPoint) {
            this.healthPoints = this.maxHealthPoint;
        }
    }

    public String getName() {
        return name;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }
    public int getLevel() {
        return level;
    }
}