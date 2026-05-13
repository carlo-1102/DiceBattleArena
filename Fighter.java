/**
 * Fighter class represents a combatant in the arena.
 * It contains attributes such as name, HP, and attack power.
 */
public class Fighter {

    private String name;
    private int hp;
    private int attackPower;

    /**
     * Constructor to initialize a fighter.
     *
     * @param name fighter name
     * @param hp fighter hit points
     * @param attackPower fighter attack power
     */
    public Fighter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    /**
     * Gets fighter name.
     *
     * @return fighter name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets fighter HP.
     *
     * @return fighter HP
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gets fighter attack power.
     *
     * @return fighter attack power
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Sets fighter HP.
     *
     * @param hp updated HP value
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Checks if fighter is alive.
     *
     * @return true if HP is greater than 0
     */
    public boolean isAlive() {
        return hp > 0;
    }
}