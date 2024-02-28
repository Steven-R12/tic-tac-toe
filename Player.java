import java.util.Objects;
import java.util.Scanner;
public class Player {
    /* A class representation of a TicTacToe player.
    A player is identified by their symbol, which can be "X" or "O".

    Complete the getTurn() method.
    */
    public final String symbol;
    public int points;

    public Player(String symbol) {
        if (!(symbol.equals("X") || symbol.equals("O"))) {
            throw new IllegalArgumentException("Invalid Symbol: Must be X or O");
        }
        this.symbol = symbol;
        this.points = 0;
    }

    public Move getTurn() {
        /* TODO: Ask the player where they'd like to place their move.
        if the inputted position is not from 1-9, reject and ask again
        return a new Move with this player and the desired location.
         */
        Scanner scanner = new Scanner(System.in);
        int resp;
        while (true) {
            System.out.println("Where would you like to place your move? ");
            resp = scanner.nextInt();
            if (resp < 1 || resp > 9) {
                System.out.println("Can't do that");
            } else {
                return new Move(this, resp);
            }
        }
    }


    /*
    These functions allow us to compare Players to each-other
    by overriding the .equals() and .hashCode() methods.
    Do not change these methods.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return this.symbol.equals(player.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
