package rpg.lab06;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int maxHealthPoint, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHealthPoint, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
        setAttack(new MageStyleDecorator(getAttack()));
    }

    public int getMana() {
        return mana;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }


    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Mana: " + mana + "/" + maxMana);
    }
}