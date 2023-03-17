package ru.netology.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Alex", 1);
    Player player2 = new Player(2, "Max", 4);
    Player player3 = new Player(3, "Igor", 1);

    @Test
    public void findByNameIfExistsTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Player actual = game.findByName("Alex");

        Assertions.assertEquals(actual, player1);
    }

    @Test
    public void findByNameIfNotExistsTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Player actual = game.findByName("Olya");

        Assertions.assertEquals(actual, null);
    }

    @Test
    public void roundPlayer1ExceptionTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Alex");
        });
    }

    @Test
    public void roundPlayer2ExceptionTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Olya");
        });
    }

    @Test
    public void roundPlayer1WinTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Max", "Alex");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void roundPlayer2WinTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Alex", "Max");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void roundDrawTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Alex", "Igor");
        Assertions.assertEquals(actual, expected);
    }
}
