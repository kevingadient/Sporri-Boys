package tutorials;

import java.util.Random;
import java.util.Scanner;

/**
 * MAIN
 */
public class Main {
    
    public static void main(String[] args) {
        // System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        

        // Game Vars
        String[] enemies = {"En 🐕 Höllenhund","E 💋 Cracknutte","Es 🍺 Bier","De 🦧 Zolli","Dini 🦄 Mueter"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;
        int enemyKillAmount = 0;
        int enemyKingPoints = 0;

        // Player Vars
        int health = 100;
        int level = 1;
        int attackDamage = 50;
        int numHealPotions = 2;
        int healthPotionHealAmount = 300;
        int healthPotionDropChance = 45; //precentage
        int numStupidity = 2;
       
        int kingPoints = 0;
        
        boolean runnning = true;
        System.out.println("\n"+"\n"+"----------------------------------------");
        System.out.println("\t> Hallo Spörri Boy    👋   ");
        System.out.println("----------------------------------------"+"\n");
        
        GAME:
        while (runnning) {
            System.out.println("----------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            enemyKingPoints = enemyHealth;
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("# "+ enemy + " wott dini Hood penetriere!"+"\n");

            while(enemyHealth>0) {
                System.out.println("\tDini Spörri Punkt: \t\t"+ health);
                System.out.println("\t"+ enemy +" Spörri Punkt: \t" + enemyHealth+"\n");
                System.out.println("\tWas wotsch mache?");
                System.out.println("\t1. Attackiere");
                System.out.println("\t2. Saufen!");
                System.out.println("\t3. Wegrenne");
                System.out.println("\t4. Erklär mir mal alles");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health      -= damageTaken;
                    System.out.println("----------------------------------------");
                    System.out.println("\t> Hesch dem Siech " + damageDealt +" Spörri Pünkt abzoge");
                    System.out.println("\t> Uff, du nimsch " + damageTaken +" Spörri Pünkt Schade");
                    System.out.println("----------------------------------------");

                    if(health<1) {
                        System.out.println("----------------------------------------");
                        System.out.println("\t"+enemy+" het dich bezwunge und schändet jetzt dini Liiche...");
                        break;
                    }
                }
                else if (input.equals("2")) {
                    if(numHealPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealPotions--;
                        System.out.println("\t> Super Bsoffe!" 
                                            +"\n\t> Fühlsch dich besser und hesch jetzt "+ health +" Spörri Pünkt" 
                                            +"\n\t> Power Move 👌" 
                                            +"\n");
                    } 
                    else {
                        System.out.println("\t>  😓😓 Du chasch jetzt nanig saufen. Bezwing es paar Penetrierer zum Saufmaterial z'becho"+"\n"+"\n" );
                    }
                }
                else if (input.equals("3")) {
                    System.out.println("\t> Ich gschmöck chli Scheisse i dinere Hose 💩💩💩"
                                    +"\n\t> "+enemy+" nagt zimmlich a dinere Manhood"
                                    +"\n"
                                    +"\n");
                    continue GAME;
                } 
                else if (input.equals("4")) {
                    System.out.println("----------------------------------------");
                    System.out.println("\t> Du bisch en Spörri Boy und wotsch de König vo Illnau werde. Easy!"
                                    +"\n\t> Zum dich König vo Illnau znenne muesch du vieli Penetrierer erledige."
                                    +"\n\t> Penetrierer sind dini Gegner wo dir de Titel wend stritig mache."
                                    +"\n\t> Du hesch Spörri Pünkt wo azeiged wievill Lebe du no hesch."
                                    +"\n\t> Went Saufsch bechunsch Spörri Pünkt. Went saufsch lebsch länger."
                                    +"\n\t> Wen de Penetrierer zu mächtig isch muesch Wegrenne"
                                    +"\n\t> Du bisch aktuell uf Level "+level+". Das heisst musch na chli Powermoves mache!");
                    System.out.println("----------------------------------------");
                }
                else {
                    if(numStupidity <= 0){
                        System.out.println("\t> Magsch du mit mir uf 3 zähle lerne?"
                                            +"\n\t> 1"
                                            +"\n\t> 2"
                                            +"\n\t> 3"
                                            +"\n\t> Dumm wie Brot 🍞🍞🍞"
                                            +"\n"
                                            +"\n");
                    }
                    else {
                        System.out.println("\t> 1-3! So schwirig isch das doch nöd, oder?!?"
                                            +"\n"
                                            +"\n");
                    numStupidity--;
                    }
                    
                }
            }
            if(health<1) {
                System.out.println("\t> 💀💀💀   Du bisch definitiv nöd de König vo Illnau"
                                    +"\n"
                                    +"\n");
                System.out.println("\t# Du hesch "+ enemyKillAmount+ " Penetrierer killt \t#");
                System.out.println("\t# Bisch bis zum Level "+ level+ " cho \t#");
                System.out.println("----------------------------------------");
                break;
            }
            enemyKillAmount++;
            kingPoints = kingPoints + (enemyKingPoints+900);
            if(kingPoints > 1000) {
                level++;
                System.out.println("----------------------------------------");
                System.out.println("Oh Boy, oh Boy      -     Du bisch es Level ufgstige! Jetzt bisch uf Level " + level);
                kingPoints = 0;
                attackDamage = attackDamage+5;
                maxEnemyHealth = maxEnemyHealth+40;
                enemyAttackDamage = enemyAttackDamage+5;
                healthPotionDropChance = healthPotionDropChance-2;
            } 
            else {
            System.out.println("----------------------------------------");
            System.out.println(" # " + enemy + " bezwunge #");
            System.out.println(" # Mad props, du hesch no " + health + " Spörri Punkt und hesch "+ enemyKillAmount+ " Penetrierer killt #");
            System.out.println(" # Bizzli meh annerkännig als König vo Illnau mit " + kingPoints + " King Points #" );
            }

            if(rand.nextInt(100)> healthPotionDropChance) {
                numHealPotions++;
                System.out.println("Din Penetrierer het öppis zum saufen gheie lah! Du chasch no "+numHealPotions+" saufen!" );
            }
        }


        in.close();

    }
    
}