package RPS;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Player bot = new Player();

        Player alex = new Player(VARIANTS.SCISSORS, "Alex");

        System.out.println(bot.whoWins(bot, alex));
    }
}
