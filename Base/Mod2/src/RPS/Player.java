package RPS;

import java.util.Random;
public class Player {
    private String name;
    private VARIANTS variants;

    public Player() {
        name = "Bot";
        variants = RandomVar();
    }

    public Player(VARIANTS variants, String name){
        this.variants = variants;
        this.name = name;

    }
    public VARIANTS RandomVar() {

        VARIANTS[] variantsValue = VARIANTS.values();

        Random random = new Random();
        int randomIndex = random.nextInt(variantsValue.length);
        return variantsValue[randomIndex];

    }

    public String whoWins(Player player1, Player player2) {
        if (player1.variants == player2.variants) {
            return "Ничья";
        } else if ((player1.variants == VARIANTS.ROCK && player2.variants == VARIANTS.SCISSORS) ||
                (player1.variants == VARIANTS.PAPER && player2.variants == VARIANTS.ROCK) ||
                (player1.variants == VARIANTS.SCISSORS && player2.variants == VARIANTS.PAPER)) {
            return player1.name + " победил";
        } else {
            return player2.name + " победил";
        }
    }
}
