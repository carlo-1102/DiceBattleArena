import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Main driver class for Dice Battle Arena.
 *
 * Uses Java API classes:
 * - ArrayList
 * - Random
 * - Collections
 * - Math
 * - String
 */
public class Main {

    /**
     * Main method to run the arena simulation.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Fighter> fighters = new ArrayList<>();
        Random rand = new Random();

        // Create 5 fighters
        fighters.add(new Fighter("Knight", 30, 3));
        fighters.add(new Fighter("Orc", 35, 2));
        fighters.add(new Fighter("Elf", 25, 4));
        fighters.add(new Fighter("Goblin", 20, 2));
        fighters.add(new Fighter("Barbarian", 40, 1));

        System.out.println("=== BATTLE START ===\n");

        // Print starting stats
        for (Fighter f : fighters) {
            System.out.println(
                    f.getName()
                            + " | HP: "
                            + f.getHp()
                            + " | ATK: "
                            + f.getAttackPower()
            );
        }

        int round = 1;

        while (fighters.size() > 1) {

            System.out.println("\n--- ROUND " + round + " ---");

            // Shuffle turn order
            Collections.shuffle(fighters);

            for (int i = 0; i < fighters.size(); i++) {

                Fighter attacker = fighters.get(i);

                // Skip dead fighters
                if (!attacker.isAlive()) {
                    continue;
                }

                // Create list of valid targets
                ArrayList<Fighter> targets = new ArrayList<>();

                for (Fighter f : fighters) {
                    if (f != attacker && f.isAlive()) {
                        targets.add(f);
                    }
                }

                // Stop if no targets remain
                if (targets.isEmpty()) {
                    break;
                }

                // Pick random target
                Fighter target = targets.get(rand.nextInt(targets.size()));

                int damage;

                // Demonstrate overloaded methods
                int choice = rand.nextInt(3);

                if (choice == 0) {
                    damage = BattleUtils.rollAttack();
                } else if (choice == 1) {
                    damage = BattleUtils.rollAttack(attacker.getAttackPower());
                } else {
                    damage = BattleUtils.rollAttack(
                            "sword",
                            attacker.getAttackPower()
                    );
                }

                // Ensure minimum damage
                damage = Math.max(1, damage);

                // Apply damage
                target.setHp(
                        Math.max(0, target.getHp() - damage)
                );

                // Demonstrate overloaded formatLog methods
                System.out.println(
                        BattleUtils.formatLog(
                                attacker.getName(),
                                target.getName(),
                                damage
                        )
                );

                System.out.println(
                        BattleUtils.formatLog(
                                attacker.getName(),
                                damage
                        )
                );

                // Check elimination
                if (!target.isAlive()) {
                    System.out.println(
                            BattleUtils.formatLog(
                                    target.getName() + " has been eliminated!"
                            )
                    );
                }
            }

            // Remove dead fighters
            fighters.removeIf(f -> !f.isAlive());

            round++;
        }

        // Winner
        System.out.println("\n=== BATTLE ENDED ===");

        if (fighters.size() == 1) {
            System.out.println(
                    "Winner: " + fighters.get(0).getName()
            );
        } else {
            System.out.println("No winner.");
        }
    }
}