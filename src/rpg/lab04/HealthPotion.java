package rpg.lab04;

public class HealthPotion implements Consumable {
    private String name;
    private int healingPower;
    private int quantity;

    public HealthPotion(String name, int healingPower, int quantity) {
        this.name = name;
        this.healingPower = healingPower;
        this.quantity = quantity;
    }

    @Override
    public void use(Character user) {
        System.out.println("   " + user.getName() + " drinks " + name + "!");
        if (quantity > 0) {
            int oldHp = user.getHealthPoints();
            user.heal(healingPower);
            int newHp = user.getHealthPoints();
            quantity--;
            System.out.println("   Health restored: " + oldHp + " -> " + newHp + " (+" + (newHp - oldHp) + ")");
            System.out.println("   " + name + " remaining: " + quantity);
        } else {
            System.out.println("   No " + name + " left!");
        }
    }

    public void displayPotionDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("  Healing Power: " + healingPower + " HP");
        System.out.println("  Quantity: " + quantity);
        System.out.println("  Type: Consumable");
    }
}
interface Consumable {
    void use(Character user);
}