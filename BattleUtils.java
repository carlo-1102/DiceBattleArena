import java.util.Random;

/**
 * Utility class for battle calculations and combat logging.
 * Demonstrates method overloading.
 */
public class BattleUtils {

    private static Random rand = new Random();

    /**
     * Rolls a basic attack (1d6).
     * @return damage value
     */
    public static int rollAttack() {
        return rand.nextInt(6) + 1;
    }

    /**
     * Rolls attack with a bonus.
     * @param bonus additional damage
     * @return total damage
     */
    public static int rollAttack(int bonus) {
        return (rand.nextInt(6) + 1) + bonus;
    }

    /**
     * Rolls attack based on weapon type with bonus.
     * @param weapon type of weapon
     * @param bonus additional damage
     * @return total damage
     */
    public static int rollAttack(String weapon, int bonus) {
        int base;

        switch (weapon.toLowerCase()) {
            case "sword":
                base = rand.nextInt(8) + 1; // 1d8
                break;
            case "axe":
                base = rand.nextInt(10) + 1; // 1d10
                break;
            default:
                base = rand.nextInt(6) + 1; // default 1d6
        }

        return base + bonus;
    }

    /**
     * Formats a simple event log.
     * @param event message
     * @return formatted string
     */
    public static String formatLog(String event) {
        return "[LOG] " + event;
    }

    /**
     * Formats attacker damage log.
     * @param attacker name
     * @param damage damage dealt
     * @return formatted string
     */
    public static String formatLog(String attacker, int damage) {
        return attacker + " deals " + damage + " damage!";
    }

    /**
     * Formats full combat log.
     * @param attacker attacker name
     * @param target target name
     * @param damage damage dealt
     * @return formatted string
     */
    public static String formatLog(String attacker, String target, int damage) {
        return attacker + " hits " + target + " for " + damage + " damage!";
    }
}