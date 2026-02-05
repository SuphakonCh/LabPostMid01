package rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoint;
    private Weapon weapon;
    private String characterClass;
    private int damage;

    public Character(String name, int level, int maxHealthPoint, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = maxHealthPoint;
        this.maxHealthPoint = maxHealthPoint;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.damage = weapon.getDamage() + (level*2);
    }

    public void displayCharacterDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("  Class: " + characterClass);
        System.out.println("  Level: " + level);
        System.out.println("  Health Points: " + healthPoints + "/" + maxHealthPoint);
        System.out.println("    Weapon: " + weapon.toString());
    }

    public int attack() {
        System.out.println("\nAttack Damage: " + damage + " (Weapon base: " + weapon.getDamage() + " + Level Bonus: " + (level*2) + ")");
        return damage;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        System.out.println("\n" + name + " takes " + damage + " damage! Remaining HP: " + healthPoints + "/" + maxHealthPoint);
    }

    public void levelUp() {
        level++;
        int healthIncrease = 10;
        maxHealthPoint += healthIncrease;
        healthPoints = maxHealthPoint;
        System.out.println("\n" + name + " leveled up to Level " + level + "!");
        System.out.println("   Max health increased to " + maxHealthPoint + " (full heal applied)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void heal(int healingPoint) {
        this.healthPoints += healingPoint;
        if (this.healthPoints > this.maxHealthPoint) {
            this.healthPoints = this.maxHealthPoint;
        }

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }
}
