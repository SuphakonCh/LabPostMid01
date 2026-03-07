package rpg.lab03;

import java.util.ArrayList;
import java.util.List;

public class RPGGameApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" SCENARIO 2: RPG BATTLEFIELD POLYMORPHISM & METHOD OVERRIDING");
        System.out.println("=".repeat(70));
        System.out.println("\n[STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Sword", "Melee", 25, "Slash Attack");
        Weapon staffWeapon = new Weapon("Staff", "Magic", 20, "Spell Cast");
        Weapon bowWeapon = new Weapon("Bow", "Ranged", 18, "Precise Shot");
        Weapon staffHealer = new Weapon("Healing Staff", "Magic", 15, "Healing");
        System.out.println("\n[STEP 2] Creating Battlefield Team...");
        List<Character> team = new ArrayList<>();

        Warrior warrior = new Warrior("Arthur", 10, 1500, 25, 10, 15, swordWeapon);
        Mage mage = new Mage("Merlin", 12, 800, 20, 5, 150, staffWeapon);
        Archer archer = new Archer("Legolas", 11, 1200, 22, 6, 85, bowWeapon);
        Healer healer = new Healer("Elara", 9, 1000, 8, staffHealer, 30); // คงคลาสที่คุณเขียนไว้

        team.add(warrior);
        team.add(mage);
        team.add(archer);
        team.add(healer);

        Character enemy = new Character("Dragon", 15, 2500, 10, new Weapon("Claws", "Melee", 25, "Bite"), "Boss");

        System.out.println("\n[STEP 3] Initial Team Status:");
        for (Character member : team) {
            member.displayCharacterDetails();
        }
        enemy.displayCharacterDetails();

        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 4] POLYMORPHIC COMBAT: Team Attacks Enemy");
        System.out.println(" Same method call (attack), DIFFERENT behavior for each type!");
        System.out.println("=".repeat(70));

        for (Character member : team) {
            member.attack(enemy);
        }

        System.out.println("\n\n [STEP 5] Enemy Status After Team Attacks:");
        enemy.displayCharacterDetails();

        System.out.println("\n [STEP 6] Enemy Counterattacks!");
        System.out.println("\n--- Dragon attacks Warrior ---");
        enemy.attack(warrior);

        System.out.println("\n [STEP 7] Final Status (Testing Special Methods):");
        healer.healAlly(warrior);
        warrior.displayCharacterDetails();
    }
}