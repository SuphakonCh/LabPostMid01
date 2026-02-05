package rpg.lab01;

public class Healer extends Character {
    private int healingPoint;

    public Healer(String name, int level, int maxHealthPoint, Weapon weapon, int healingPoint) {
        super(name, level, maxHealthPoint, weapon, "healer");
        this.healingPoint = healingPoint;
    }

        public void heal() {
            this.heal(healingPoint);
            System.out.println(this.getName() + " (Healer) cast a healing spell!");
            System.out.println("   Healing Amount: " + getHealingPoint() + " (Base: " + getHealingPoint() + " + Level Bonus: " + (getLevel()*2) + ")");
            System.out.println("   Restored "+ getHealingPoint() + " HP! Current HP: " + this.getHealthPoints() + "/" + this.getMaxHealthPoint());
        }

        public void healAlly(Character ally) {
            ally.heal(getHealingPoint());
            System.out.println(this.getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
            System.out.println("   Healing Amount: " + getHealingPoint());
            System.out.println("   Restored "+ getHealingPoint() + " HP to " + ally.getName() + "! Their HP: " + ally.getHealthPoints());
        }

        @Override
        public void displayCharacterDetails() {
            System.out.println("\n--- " + this.getName().toUpperCase() + " ---");
            System.out.println("  Class: " + this.getCharacterClass());
            System.out.println("  Level: " + this.getLevel());
            System.out.println("  Health Points: " + this.getHealthPoints() + "/" + this.getMaxHealthPoint());
            System.out.println("    Weapon: " + this.getWeapon().toString());
            System.out.println("  Healing Power: " + getHealingPoint());
        }

        public int getHealingPoint() {
            return healingPoint + (getLevel()*2);
        }

    public void setHealingPoint(int healingPoint) {
        this.healingPoint = healingPoint;
    }
}
