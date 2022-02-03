
interface CriticalDamage{
    double plusDamage = 0.2;

}


abstract class Character {
    private double healthPoint;
    private double attackDamage;
    private double defense;
    private int level;
    private boolean lifeStatus;

    public void attack(Character A) {

        reviewDamage(attackDamage);

    }

    public void reviewDamage(double realDamage) {
        realDamage -= this.defense;

        if (healthPoint - realDamage <= 0) {
            healthPoint = 0;
            lifeStatus = false;
        } else {
            healthPoint -= realDamage;
        }
    }

    abstract public void spawnIntro();

    public void checkStatus() {

        System.out.println("Level \t:" + level);
        System.out.println("HealthPoint : " + healthPoint + "\t defense : " + defense);
        System.out.println("AttackDamage: " + attackDamage + "\t\t lifeStatus : " + lifeStatus);
        System.out.println(" ");

    }


}

class Warrior extends Character implements CriticalDamage {
    double healthPoint = 3000;
    double attackDamage = 800;
    double defense = 250;
    int level;
    boolean lifeStatus;

    Warrior(int level) {

        this.healthPoint += (level * 100);
        this.attackDamage += (level * 15) * 0.2;
        this.attackDamage += attackDamage * plusDamage * level;
        this.defense += (level * 10);
        this.level = level;
        this.lifeStatus = true;

    }


    public void attack(Assasin A) {

        reviewDamage(A.attackDamage);

    }

    public void attack(Tank A) {

        reviewDamage(A.attackDamage);

    }

    public void reviewDamage(double realDamage) {
        realDamage -= this.defense;

        if (healthPoint - realDamage <= 0) {
            healthPoint = 0;
            lifeStatus = false;
        } else {
            healthPoint -= realDamage;
        }
    }

    @Override
    public void spawnIntro() {
        System.out.println("Feel my Blade!!");
    }

    public void checkStatus() {

        System.out.println("Level \t:" + this.level);
        System.out.println("HealthPoint : " + this.healthPoint + "\t defense : " + this.defense);
        System.out.println("AttackDamage: " + this.attackDamage + "\t\t lifeStatus : " + this.lifeStatus);
        System.out.println(" ");

    }

}

class Assasin extends Character {
    double healthPoint = 2500;
    double attackDamage = 750;
    double defense = 200;
    int level;
    boolean lifeStatus;

    Assasin(int level) {

        this.healthPoint += (level * 80);
        this.attackDamage += (level * 10);
        this.defense += (level * 25);
        this.level = level;
        this.lifeStatus = true;


    }

    public void attack(Warrior A) {

        reviewDamage(A.attackDamage);

    }

    public void attack(Tank A) {

        reviewDamage(A.attackDamage);

    }

    public void reviewDamage(double realDamage) {
        realDamage -= this.defense;

        if (healthPoint - realDamage <= 0) {
            healthPoint = 0;
            lifeStatus = false;
        } else {
            healthPoint -= realDamage;
        }
    }

    @Override
    public void spawnIntro() {
        System.out.println("Your Soul is Mine!!!");
    }

    public void checkStatus() {

        System.out.println("Level \t:" + this.level);
        System.out.println("HealthPoint : " + this.healthPoint + "\t defense : " + this.defense);
        System.out.println("AttackDamage: " + this.attackDamage + "\t\t lifeStatus : " + this.lifeStatus);
        System.out.println(" ");

    }

}


class Tank extends Character {

    double healthPoint = 5000;
    double attackDamage = 400;
    double defense = 400;
    int level;
    boolean lifeStatus;

    Tank(int level) {

        this.healthPoint += (level * 150);
        this.attackDamage += (level * 10);
        this.defense += (level * 15);
        this.level = level;
        this.lifeStatus = true;


    }

    public void attack(Warrior A) {

        reviewDamage(A.attackDamage);

    }

    public void attack(Assasin A) {

        reviewDamage(A.attackDamage);

    }

    public void reviewDamage(double realDamage) {
        realDamage -= defense;

        if (healthPoint - realDamage <= 0) {
            healthPoint = 0;
            lifeStatus = false;
        } else {
            healthPoint -= realDamage;
        }
    }

    @Override
    public void spawnIntro() {
        System.out.println("By the Shield of Slyrak!");
    }

    public void checkStatus() {

        System.out.println("Level \t:" + this.level);
        System.out.println("HealthPoint : " + this.healthPoint + "\t defense : " + this.defense);
        System.out.println("AttackDamage: " + this.attackDamage + "\t\t lifeStatus : " + this.lifeStatus);
        System.out.println(" ");

    }

}

public class Main {
    public static void main(String[] args) {

        Battle Begin = new Battle();
        Begin.start();
    }

}



class Battle {

    Assasin player1 = new Assasin(0);
    Warrior player2 = new Warrior(1);
    int a = 1;
    boolean KO = true;

    void start() {
        System.out.println(" \n");
        System.out.println("===== PLAYER 1 =====");
        player1.checkStatus();
        System.out.println("===== PLAYER 2 =====");
        player2.checkStatus();
        System.out.println("################### ROUND START #########################");
        System.out.println(" ");


        while (KO) {
            System.out.println("===== TURN " + a + " =====");
            System.out.println("-- Player 1 Move --");
            player1.spawnIntro();
            player1.attack(player2);
            System.out.println("Player 2 Health Remaining " + player2.healthPoint);

            System.out.println("-- Player 2 Move --");
            player2.spawnIntro();
            player2.attack(player1);
            System.out.println("Player 1 Health Remaining " + player1.healthPoint);
            System.out.println(" ");

            if (!player1.lifeStatus) {
                System.out.println("===== Battle Result =====");
                System.out.println("-- Player 1 Move --");
                System.out.println("CANT ATTACK, ALREADY DEAD ");
                System.out.println("Player 2 Health Remaining : " + player2.healthPoint);

                System.out.println("-- Player 2 Move --");
                System.out.println("Player 1 Health Remaining : " + player1.healthPoint);
                System.out.println(" ");
                KO = false;

                System.out.println(">>>>>>>>>  Player 2 WIN  <<<<<<<<<<<<");

            } else if (!player2.lifeStatus) {
                System.out.println("===== Battle Result =====");
                System.out.println("-- Player 1 Move --");
                System.out.println("Player 2 Health Remaining : " + player2.healthPoint);

                System.out.println("-- Player 2 Move --");
                System.out.println("CANT ATTACK, ALREADY DEAD ");
                System.out.println("Player 1 Health Remaining : " + player1.healthPoint);
                System.out.println(" ");
                KO = false;

                System.out.println(">>>>>>>>>  Player 1 WIN  <<<<<<<<<<<<");
            }
            a++;
        }
    }
}
