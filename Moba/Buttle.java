package Moba;

import java.util.Random;

public class Buttle {

    static Random random = new Random();
    public static void main(String[] args) {

        Hero[] team1 = {new Tank("pers1"), new Warrior("pers2"), new Doctor("pers3")};
        Hero[] team2 = {new Doctor("pers4"), new Tank("pers5"), new Tank("pers6")};
        Boolean flag = true;


        while (flag) {
            System.out.println("Team 1:");
            reviewTeams(team1);
            System.out.println();
            System.out.println("Team 2:");
            reviewTeams(team2);
            System.out.println();
            System.out.println("Battle begin:");
            for (int i = 0; i <team1.length ; i++) {
                if (live(team1[i])) {
                    step(team1, team2, i);
                    }
                if (live(team2[i])) {
                    step(team2, team1, i);
                }
                if (liveTeam(team1) && liveTeam(team2)) {
                    continue;
                } else {
                    if (liveTeam(team1) == false) {
                        System.out.println("Team 2 WIN!");
                        flag = false;
                        break;
                    }
                    else {
                        System.out.println("Team 1 WIN!");
                        flag = false;
                        break;
                    }
                }
            }
        }
    }
    public static Boolean liveTeam(Hero[] team) {
        for (int i = 0; i < team.length; i++) {
            if (team[i].hp > 0) { return true; }
            }
        return false;
    }

    public static Boolean live (Hero hero) {
        if (hero.hp <= 0) {
            System.out.println(hero.type + " " + hero.name + " die");
            return false;
        } else {
            System.out.println(hero.type + " " + hero.name + " hp = " + hero.hp);
            return true;
        }
    }

    public static void step(Hero[] team1, Hero[] team2, int i) {
        Hero randpers = team1[random.nextInt(team1.length)];
        if (team1[i].type == "Doctor") {
            if (live(randpers)) {
                team1[i].cure(randpers);
            } else {
                damageLive(team1, team2 ,i);
            }
        } else {
            damageLive(team1, team2 ,i);
        }
    }

    public static void damageLive(Hero[] team1, Hero[] team2, int i) {
        while (true) {
            Hero randpers = team2[random.nextInt(team2.length)];
            if (live(randpers)) {
                team1[i].setDamage(randpers, team1[i].damage);
                break;
            } else {
                    continue;
            }
        }
    }

    public static void reviewTeams (Hero[] team) {
        for (int i = 0; i < team.length; i++) {
            System.out.println(team[i].type + " " + team[i].name + " " + team[i].hp + " " + team[i].damage);
        }
    }
}
