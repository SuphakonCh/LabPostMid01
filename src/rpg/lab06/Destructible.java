package rpg.lab06;

public interface Destructible {
    void takeDamage(int amount);
    boolean isDestroyed();
}