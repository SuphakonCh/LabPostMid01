package rpg.lab06;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int maxHealthPoint, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHealthPoint, defense, weapon, "Archer");
        this.accuracy = accuracy;
        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public boolean hasRangeAdvantage() {
        return true;
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Accuracy: " + accuracy + "%");
    }
    public int getAccuracy() {
        return accuracy;
    }

}