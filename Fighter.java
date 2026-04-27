/**
 * Fighter class represents a combatant in the arena.
 * It contains basic attributes such as name, HP, and attack power.
 */
public class Fighter {

    private String name;
    private int hp;
    private int attackPower;

    /**
     * Constructor to initialize a fighter.
     * @param name Name of the fighter
     * @param hp Hit points
     * @param attackPower Base attack power
     */
    public Fighter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // Setter
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Checks if fighter is still alive.
     * @return true if HP > 0
     */
    public boolean isAlive() {
        return hp > 0;
    }
}