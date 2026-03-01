package rpg.lab04;

public class WoodenBox implements Destructible {
    private String name;
    private int health;
    private int maxHealth;
    private boolean isLocked;
    private String contents;

    public WoodenBox(String name, int health, boolean isLocked, String contents) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.isLocked = isLocked;
        this.contents = contents;
    }

    @Override
    public void takeDamage(int amount) {
        System.out.println("   " + name + " takes " + amount + " damage!");
        health -= amount;
        if (health <= 0) {
            health = 0;
            System.out.println("   " + name + " HP: 0/" + maxHealth + " (DESTROYED!)");
        } else {
            System.out.println("   " + name + " HP: " + health + "/" + maxHealth);
        }
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    public void breakOpen() {
        if (isDestroyed()) {
            if (isLocked) {
                System.out.println("   The lock broke! " + name + " breaks open!");
            } else {
                System.out.println("   " + name + " breaks open!");
            }
            System.out.println("   Contents revealed: " + contents);
        } else {
            System.out.println("   Cannot break open " + name + " - it's still intact!");
        }
    }

    public void displayBoxDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " (WOODEN BOX) ---");
        System.out.println("  Status: " + (isDestroyed() ? "Destroyed" : "Intact"));
        System.out.println("  Health: " + health + "/" + maxHealth);
        System.out.println("  Locked: " + (isLocked ? "Yes" : "No"));
        System.out.println("  Contains: " + contents);
    }

    public String getName() { return name; }
}