package gamewiphw;

import java.util.Scanner;
import java.util.Random;

public class GameWIPHW {

    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();

    //enemy stuff
    public static String enemy;
    public static int EnemyHealth;

    //player stuff
    public static int PlayerHealth = 250;
    public static int NumHealthPots = 3;

    public static void SetEnemyStats() {
        String[] enemies = {"Skeleton", "Zombie", "Warlock", "Assassin", "Giant Spider", "Mutant Bat"};
        int maxEnemyHealth = 100;
        int minEnemyHealth = 50;

        EnemyHealth = rand.nextInt((maxEnemyHealth - minEnemyHealth) + 1) + minEnemyHealth;
        enemy = enemies[rand.nextInt(enemies.length)];

    }

    public static boolean DropHealthPot() {
        int HealthPotDropChance = 35;  //percentage
        int chance = rand.nextInt(100);
        if (chance <= 35) {
            return true;
        } else {
            return false;
        }
    }

    public static void PlayerVEnemyCombat() {

        //player stuff
        int PlayerAttackDamage = 30;
        int HealthPotHealAmount = 30;

        //enemy stuff
        int maxEnemyAttackDamage = 25;

        //game stuff
        boolean flee = false;

        while (EnemyHealth > 0) {
            System.out.println("\n\tYou currently have " + PlayerHealth + " health.");
            System.out.println("\t" + enemy + " currently has " + EnemyHealth + " health.");
            while (true) {
                try {
                    System.out.println("\n\t What would you like to do?");
                    System.out.println("\t 1. Attack");
                    System.out.println("\t 2. Drink Health Potion");
                    System.out.println("\t 3. Flee");

                    String choice = input.next();
                    choice.toLowerCase();

                    if (choice.equals("attack") || choice.equals("1")) {
                        System.out.println("\t You have chosen 'Attack'!");

                        int DamageDealt = rand.nextInt((PlayerAttackDamage - 10) + 1) + 10;
                        System.out.println("\t You have dealt " + DamageDealt + " damage to " + enemy + "!");
                        EnemyHealth = EnemyHealth - DamageDealt;
                        int DamageTaken = rand.nextInt((maxEnemyAttackDamage - 10) + 1) + 10;
                        System.out.println("\t " + enemy + " has attacked back for " + DamageTaken + " damage!");
                        PlayerHealth = PlayerHealth - DamageTaken;

                        break;
                    } else if (choice.equals("drink health potion") || choice.equals("2")) {
                        System.out.println("\t You have chosen 'Drink Health Potion'!");

                        if (NumHealthPots != 0) {
                            PlayerHealth = PlayerHealth + HealthPotHealAmount;
                            System.out.println("\t You have been healed for " + HealthPotHealAmount + " health!");
                            System.out.println("\t You now have " + PlayerHealth + " health!");
                            NumHealthPots--;
                            System.out.println("\t You now have " + NumHealthPots + " left.");
                            int DamageTaken = rand.nextInt((maxEnemyAttackDamage - 10) + 1) + 10;
                            System.out.println("\t " + enemy + " has attacked back for " + DamageTaken + " damage!");
                            PlayerHealth = PlayerHealth - DamageTaken;
                        } else {
                            System.out.println("\t You don't have any health potions left!");
                        }
                        break;
                    } else if (choice.equals("Flee") || choice.equals("3")) {
                        System.out.println("\t You have chosen 'Flee'!");
                        System.out.println("\t You run away, leaving a confused " + enemy + " far behind you.");
                        EnemyHealth = 0;
                        flee = true;
                        break;
                    } else {
                        System.out.println("\t ERROR: please enter something valid.");
                    }
                } catch (Exception e) {
                    System.out.println("\t ERROR: " + e);
                }
            }
        }
        if (flee == false) {
            System.out.println("\t You have killed " + enemy);
            DropHealthPot();
            if (DropHealthPot() == true) {
                System.out.println("\t " + enemy + " dropped a health potion for you!");
                NumHealthPots++;
            }
        }
    }

    public static boolean PlayAgain() {
        while (true) {
            try {
                System.out.println("\n\t Would you like to enter the Dungeon again?");
                String answer = input.next();
                if (answer.equals("no")) {
                    System.out.println("\t Thank you for fighting at the Dungeon!");
                    System.out.println("\t We hope you return!");
                    return false;
                }else{
                    return true;
                }
            } catch (Exception e) {
                System.out.println("\t ERROR: " + e);
            }
        }
    }

    public static void main(String[] args) {

        /*game ideas: ask for user name, add inventory, add new enemies, add bosses, 
        add storyline, tidy up PlayerVEnemyCombat by maybe spliting it up into
        different methods, experience levels, graphics/buttons. MAKE IT SO MAX HEALTH
        IS ACTUALLY A THING AND USER CAN'T GO OVER.
         */
        boolean Running = true;

        System.out.println("\t Welcome to the Dungeon!");

        GAME:
        while (Running == true) {
            System.out.println("---------------------------------------------");
            SetEnemyStats();
            System.out.println("\t* " + enemy + " has appeared! *");
            PlayerVEnemyCombat();
            if (PlayAgain() == false){
                Running = false;
            }

        }

    }

}
