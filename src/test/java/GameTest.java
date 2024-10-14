import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Jackson", 800);
        Player player2 = new Player(2, "Breddy", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Jackson", "Breddy");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Jackson", 500);
        Player player2 = new Player(2, "Breddy", 800);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Jackson", "Breddy");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test //когда ничья
    public void testWhenNobodyWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Jackson", 500);
        Player player2 = new Player(2, "Breddy", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Jackson", "Breddy");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayer1NotRegistered() {
        Game game = new Game();
        Player player2 = new Player(2, "Breddy", 800);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jackson", "Breddy");
        });
    }

    @Test
    public void testPlayer2NotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Jackson", 500);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jackson", "Breddy");
        });
    }

    @Test
    public void testAllPlayersNotRegistered() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jackson", "Breddy");
        });
    }
}

