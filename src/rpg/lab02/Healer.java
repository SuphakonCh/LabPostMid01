package rpg.lab02;

public class Healer extends Character {
    private int healingPoint;

    public Healer(String name, int level, int maxHealthPoint, int defense, Weapon weapon, int healingPoint) {
        super(name, level, maxHealthPoint, defense, weapon, "Healer");
        this.healingPoint = healingPoint;
    }

    public void heal() {
        this.heal(getHealingPoint());
        System.out.println("\n" + this.getName() + " (Healer) casts a healing spell on self!");
        System.out.println("   Healing Amount: " + getHealingPoint());
        System.out.println("   Restored HP! Current HP: " + this.getHealthPoints() + "/" + this.getMaxHealthPoint());
    }

    public void healAlly(Character ally) {
        ally.heal(getHealingPoint());
        System.out.println("\n" + this.getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("   Healing Amount: " + getHealingPoint());
        System.out.println("   Restored HP to " + ally.getName() + "! Their HP: " + ally.getHealthPoints());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Healing Power: " + getHealingPoint());
    }

    public int getHealingPoint() {
        return healingPoint + (getLevel() * 2);
    }
}