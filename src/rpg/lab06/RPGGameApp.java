package rpg.lab06;

import java.util.ArrayList;
import java.util.List;

public class RPGGameApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" SCENARIO 4: INTERFACES - DESTRUCTIBLE & CONSUMABLE");
        System.out.println("=".repeat(70));

        // ==================== [STEP 1] CREATE WEAPONS ====================
        System.out.println("\n[STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Excalibur", "Melee", 30, "Slash Attack");
        Weapon staffWeapon = new Weapon("Staff of Mysticism", "Magic", 20, "Spell Cast");
        Weapon bowWeapon = new Weapon("Bow of Elven Make", "Ranged", 18, "Precise Shot");

        // ==================== [STEP 2] CREATE CHARACTERS ====================
        System.out.println("\n[STEP 2] Creating Characters...");
        Warrior warrior = new Warrior("Aragorn", 12, 2000, 25, 8, 15, swordWeapon);
        Mage mage = new Mage("Gandalf", 14, 1200, 20, 5, 150, staffWeapon);
        Archer archer = new Archer("Legolas", 13, 1400, 22, 6, 85, bowWeapon);

        // ==================== [STEP 3] CREATE DESTRUCTIBLE OBJECTS ====================
        System.out.println("\n[STEP 3] Creating Destructible Objects (Non-Character)...");
        WoodenBox treasureBox = new WoodenBox("Treasure Chest", 300, true, "1000 Gold Coins");
        WoodenBox crate = new WoodenBox("Supply Crate", 150, false, "Medicine & Supplies");

        // ==================== [STEP 4] CREATE CONSUMABLE ITEMS ====================
        System.out.println("\n[STEP 4] Creating Consumable Items...");
        HealthPotion potionGreater = new HealthPotion("Greater Health Potion", 100, 3);
        HealthPotion potionMinor = new HealthPotion("Minor Health Potion", 10, 10);

        // ==================== [STEP 5] DISPLAY INITIAL STATUS ====================
        System.out.println("\n[STEP 5] Initial Status:");
        System.out.println("\n--- CHARACTERS (Destructible) ---");
        warrior.displayCharacterDetails();
        mage.displayCharacterDetails();
        archer.displayCharacterDetails();

        System.out.println("\n--- DESTRUCTIBLE OBJECTS (Non-Character) ---");
        treasureBox.displayBoxDetails();
        crate.displayBoxDetails();

        System.out.println("\n--- CONSUMABLE ITEMS ---");
        potionGreater.displayPotionDetails();
        potionMinor.displayPotionDetails();

        // ==================== [STEP 6] COMBAT TEST & DECORATOR CHAIN ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 6] INTERFACE POLYMORPHISM & DECORATOR PATTERN");
        System.out.println("=".repeat(70));

        List<Destructible> battleTargets = new ArrayList<>();
        battleTargets.add(mage);
        battleTargets.add(warrior);
        battleTargets.add(treasureBox);
        battleTargets.add(crate);

        System.out.println("\n--- Aragorn and Mage attacks each other ---");

        warrior.setAttack(
                new LifeStealDecorator(
                        new DamageBoostDecorator(
                                new CriticalStrikeDecorator(warrior.getAttack()),
                                8
                        ),
                        0.15
                )
        );
        System.out.println(" Decorator Chain Applied: WarriorStyle -> CriticalStrike -> DamageBoost -> LifeSteal");

        for (int i = 0; i < 5; i++) {
            warrior.attack(mage);
            mage.attack(warrior);
        }

        System.out.println("\n--- Aragorn continues attacking the Treasure Chest ---");
        while (!treasureBox.isDestroyed()) {
            warrior.attack(treasureBox);
        }

        System.out.println("\n--- Legolas attacks a Supply Crate ---");
        archer.attack(crate);

        // ==================== [STEP 7] STATUS AFTER COMBAT ====================
        System.out.println("\n[STEP 7] Status After Combat:");
        System.out.println("\n--- Mage Status ---");
        mage.displayCharacterDetails();
        System.out.println("\n--- Destructible Objects Status ---");
        treasureBox.displayBoxDetails();
        crate.displayBoxDetails();

        // ==================== [STEP 8] CONSUMABLE ITEMS ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 8] INTERFACE POLYMORPHISM: Consumable Items");
        System.out.println("=".repeat(70));

        List<Consumable> inventory = new ArrayList<>();
        inventory.add(potionGreater);
        inventory.add(potionMinor);

        System.out.println("--- Gandalf uses a Greater Health Potion ---");
        inventory.get(0).use(mage);
        System.out.println("\n--- Gandalf uses a Minor Health Potion ---");
        inventory.get(1).use(mage);

        // ==================== [STEP 9] BREAK OPEN BOXES ====================
        System.out.println("\n[STEP 9] Breaking Open Boxes:");
        System.out.println("\n--- Breaking open the Treasure Chest ---");
        treasureBox.breakOpen();
        System.out.println("\n--- Attempting to break the Supply Crate (still intact) ---");
        crate.breakOpen();

        // ==================== [STEP 10] CROSS-HIERARCHY INTERACTION ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 10] CROSS-HIERARCHY INTERACTION: Stone Walls & Castle Gates");
        System.out.println("=".repeat(70));

        System.out.println("[Creating New Structures]");
        StoneWall northWall = new StoneWall("North Wall", 500, "Outer Wall");
        StoneWall eastWall = new StoneWall("East Wall", 400, "Inner Wall");
        CastleGate mainGate = new CastleGate("Main Gate", 600, true, true);
        CastleGate sideGate = new CastleGate("Side Gate", 300, false, false);

        System.out.println("\n--- Aragorn (Warrior) attacks the North Wall ---");
        for (int i = 0; i < 8; i++) {
            warrior.attack(northWall);
            if (northWall.isDestroyed()) break;
        }

        System.out.println("\n--- Legolas (Archer) attacks the Main Gate (Reinforced!) ---");
        for (int i = 0; i < 10; i++) {
            archer.attack(mainGate);
            if (mainGate.isDestroyed()) break;
        }

        System.out.println("\n--- Aragorn (Warrior) attacks the Side Gate ---");
        while (!sideGate.isDestroyed()) {
            warrior.attack(sideGate);
        }

        // ==================== [STEP 11] POLYMORPHIC LIST ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 11] POLYMORPHIC LIST: Mixed Destructible Objects");
        System.out.println("=".repeat(70));

        List<Destructible> allDestructibles = new ArrayList<>();
        allDestructibles.add(eastWall);
        allDestructibles.add(crate);
        allDestructibles.add(archer);

        System.out.println("--- Mage attacking various targets from polymorphic list ---");
        for (Destructible target : allDestructibles) {
            if (target instanceof StoneWall) {
                System.out.println("\n>> Target: " + ((StoneWall) target).getLocation());
            } else if (target instanceof WoodenBox) {
                System.out.println("\n>> Target: " + ((WoodenBox) target).getName());
            } else if (target instanceof Character) {
                System.out.println("\n>> Target: " + ((Character) target).getName());
            }
            mage.attack(target);
        }
    }
}