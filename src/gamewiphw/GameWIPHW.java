package gamewiphw;

import java.util.Scanner;
import java.util.Random;

public class GameWIPHW {

    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();

    //enemy stuff
    public static String enemy;
    public static int EnemyHealth;
    
    //boss stuff
    public static String boss;
    public static int BossHealth;

    //player stuff
    public static int PlayerHealth = 250;
    public static int NumHealthPots = 3;
    public static String PlayerName;
    public static String PlayerClass;
    
    public static void wait(int ms) {
    try{
        Thread.sleep(ms);
    }
    catch(InterruptedException ex){
        Thread.currentThread().interrupt();
    }
}

    public static void GetPlayerName() {
        
        while (true) {
            System.out.println("\t What is your name?");
            PlayerName = input.next();
            PlayerName = PlayerName.trim();
            System.out.println("\t Your name is \u001b[36;1m"+PlayerName+"\u001b[0m? Did I hear you correctly?");
            String answer = input.next();
            answer = answer.toLowerCase();
            if (answer.equals("yes")||answer.equals("y")){
                System.out.println("\t Great to meet you!");
                break;
            }else{
                System.out.println("\t Sorry! I think you were mumbling.");
            }
        }

    }
    
    public static int GetPlayerClass(){
        
        System.out.println("\n\t---------------------------------------------\n");
        
        while (true) {
            System.out.println("\t What is your class \u001b[36;1m"+PlayerName+"\u001b[0m?");
            System.out.println("\t You can choose between \u001b[36;1mMage, Warrior, Archer and Assassin\u001b[0m! Select one to find out more about each class:");
            String ChooseClass = input.next();
            ChooseClass = ChooseClass.toLowerCase();
            if (ChooseClass.equals("mage")){
                System.out.println("\t A Mage is a decendent from the elves in the mountains over several hundreds of years. A Mage can\n\t cast a varity of spells for quite a bit of damage. However Mages do not have a lot of health.");
                wait(5000);
                System.out.println("\t Would you like to choose Mage?");
                String choice = input.next();
                choice = choice.toLowerCase();
                if (choice.equals("yes")||choice.equals("y")){
                    System.out.println("\t You have chosen the Mage class! Welcome caster!");
                    PlayerClass = "mage";
                    return 1;
                }
            }else if (ChooseClass.equals("warrior")){
                System.out.println("\t A Warrior is a master with the blade, having trained all their life to perfect the sword. A Warrior\n\t can perform fancy tricks with their weapon and has a lot of health. However, Warriors cannot\n\t deal much damage.");
                wait(5000);
                System.out.println("\t Would you like to choose Warrior?");
                String choice = input.next();
                choice = choice.toLowerCase();
                if (choice.equals("yes")||choice.equals("y")){
                    System.out.println("\t You have chosen the Warrior class! Welcome master of the blade!");
                    PlayerClass = "warrior";
                    return 2;
                }
            }else if(ChooseClass.equals("archer")){
                System.out.println("\t An Archer is one with the arrow, able to shoot nearly anything. An Archer can deal a lot of piercing\n\t damage. However, they do not have a lot of health.");
                wait(5000);
                System.out.println("\t Would you like to choose Archer?");
                String choice = input.next();
                choice = choice.toLowerCase();
                if (choice.equals("yes")||choice.equals("y")){
                    System.out.println("\t You have chosen the Archer class! Welcome master of the arrow!");
                    PlayerClass = "archer";
                    return 3;
                }
            }else if(ChooseClass.equals("assassin")){
                System.out.println("\t An Assassin sticks to the darkness, steathily sneaking around in the shadows until the time to strike\n\t appears. An Assassin deals a lot of damage and a decent amount of health. However, gaining\n\t upgrades can prove to be challeneging.");
                wait(5000);
                System.out.println("\t Would you like to choose Assassin?");
                String choice = input.next();
                choice = choice.toLowerCase();
                if (choice.equals("yes")||choice.equals("y")){
                    System.out.println("\t You have chosen the Assassin class! Welcome keeper of shadows!");
                    PlayerClass = "assassin";
                    return 4;
                }
            }else{
                System.out.println("That isn't a valid choice! Please select again!");
            }
        }
    }
    
    public static void PlotPartOne(){
        wait(2000);
        System.out.println("\n\t---------------------------------------------");
        System.out.println("\n\t The market is busy today in the outskirts of the kingdom, bustling with life.");
        wait(4000);
        System.out.println("\t You can hear vendors shouting to promote themselves so someone will buy their goods, a shop owner chases\n\t after a thief who has stolen some of their wares. ");
        wait(8000);
        System.out.println("\t Everyone you look at seems to have some place to be, but so do you. Since your money is running dry, you\n\t need to find a job. That's why you're on your way to the bounty hunter station.");
        wait(8000);
        System.out.println("\tYou push the door open to reveal one of your only friends: Thorne. He isn't the particular person you imagine\n\t to be running a place where bounty hunters could gather.");
        wait(8000);
        System.out.println("\t He's a small, frail man who can barely stand by himself for too long. However, he used to be one of the best\n\t hunters in the land and that's what got you into this profession.");
        wait(8000);
        if(PlayerClass.equals("mage")){
            System.out.println("\t The stories Thorne told of one of his friends shooting fireballs from her palm entranced you. and stuck in\n\t your mind for the longest time. Eventually making you learn how to do it yourself.");
        }else if(PlayerClass.equals("warrior")){
            System.out.println("\t The stories of Thorne taking down a possessed warlock and nearly a hundred skeletons by himself with his sword\n\t sent excitement through your body. You wanted to do that too.");
        }else if(PlayerClass.equals("archer")){
            System.out.println("\t The stories Thorne told you of one of his friends shooting a giant spider in the eye with a crossbow from over\n\t a mile away thrilled you. You didn't know it was possible, but now you wanted to do it too.");
        }else if(PlayerClass.equals("assassin")){
            System.out.println("\t The stories Thorne told you of one of his friends doing shadow work for the Queen, spying from the darkness,\n\t had you in awe. How could someone be so unnoticable yet so important?");
        }
        wait(8000);
        System.out.println("\t\"\u001b[36;1m"+PlayerName+"\u001b[0m!\" Thorne greeted as he noticed you approach the counter. ");
        if(PlayerClass.equals("mage")){
            System.out.print("\t\"How's my favourite little caster?\"");
        }else if(PlayerClass.equals("warrior")){
            System.out.print("\t\"How's my favourite little blade master?\"");
        }else if(PlayerClass.equals("archer")){
            System.out.print("\t\"How's my favourite little archer?\"");
        }else if(PlayerClass.equals("assassin")){
            System.out.print("\t\"How's my favourite little shadow?\"");
        }
        
        //add option to pick what to reply
    }

    public static void SetEnemyStats() {
        String[] enemies = {"Skeleton", "Zombie", "Possessed Warlock", "Demon"};
        int maxEnemyHealth = 100;
        int minEnemyHealth = 50;

        EnemyHealth = rand.nextInt((maxEnemyHealth - minEnemyHealth) + 1) + minEnemyHealth;
        enemy = enemies[rand.nextInt(enemies.length)];

    }
    
    public static void SetBossStats(){
        String [] bosses = {"Giant Spider","Mutant Bat","Demon King"};
        int maxBossHealth = 250;
        int minBossHealth = 100;
        
        BossHealth = rand.nextInt((maxBossHealth-minBossHealth)+1)+minBossHealth;
        boss = bosses[rand.nextInt(bosses.length)];
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

    public static void EnemyCombat() {

        //player stuff
        int PlayerAttackDamage = 30;
        int HealthPotHealAmount = 30;

        //enemy stuff
        int maxEnemyAttackDamage = 25;

        //game stuff
        boolean flee = false;

        System.out.println("\t* " + enemy + " has appeared! *");

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
                } else {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("\t ERROR: " + e);
            }
        }
    }

    public static void main(String[] args) {

        /*things to do: add inventory, add new enemies, add bosses, 
        tidy up PlayerVEnemyCombat by maybe spliting it up into
        different methods, experience levels, graphics/buttons. MAKE IT SO MAX HEALTH
        IS ACTUALLY A THING AND USER CAN'T GO OVER.
         */
        
        System.out.println("\u001b[36;1m \t* Welcome adventurer! * \u001b[0m");
        GetPlayerName();
        GetPlayerClass();
        PlotPartOne();
        /*while/for loop for 3 enemy combat rounds, give an extra 2 health pots and then boss.
        Then give a new weapon/ armour based on class.
        */
    }
}
