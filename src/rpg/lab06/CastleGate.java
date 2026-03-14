package rpg.lab06;

public class CastleGate implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private boolean isLocked;
    private boolean isReinforced;

    public CastleGate(String name, int durability, boolean isLocked, boolean isReinforced) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.isLocked = isLocked;
        this.isReinforced = isReinforced;
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount;
        if (isReinforced) {
            actualDamage = amount / 2;
            System.out.println("   " + name + " is REINFORCED! (reduces damage from " + amount + " to " + actualDamage + ")");
        }

        durability -= actualDamage;
        if (durability <= 0) {
            System.out.println("   " + name + " takes " + actualDamage + " damage! (Durability: " + durability + "/" + maxDurability + ")");
            System.out.println("   " + name + " has been BREACHED! The gate COLLAPSES!");
        } else {
            System.out.println("   " + name + " takes " + actualDamage + " damage! (Durability: " + durability + "/" + maxDurability + ")");
        }
    }

    @Override
    public boolean isDestroyed() {
        return durability <= 0;
    }

    public void displayGateDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("  Status: " + (isDestroyed() ? "BREACHED" : "INTACT"));
        System.out.println("  Durability: " + Math.max(0, durability) + "/" + maxDurability);
        System.out.println("  Locked: " + (isLocked ? "Yes" : "No"));
        System.out.println("  Reinforced: " + (isReinforced ? "Yes" : "No"));
    }
}