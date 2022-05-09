package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Anna", 300);
    private Player player2 = new Player(2, "John", 250);
    private Player player3 = new Player(3, "Miki", 200);
    private Player player4 = new Player(4, "Niki", 100);
    private Player player5 = new Player(5,"Riki", 150);
    private Player player6 = new Player(6,"Bob",200);

    @BeforeEach
    void shouldRegisterAllPlayers() {
        game.registerAll(List.of(player1, player2, player3, player4, player5, player6));
    }

    @Test
    void shouldFindByNameWhenRegistered() {
        assertEquals(player4, game.findByName("Niki"));
    }
    @Test
    void shouldFindAllRegisteredPlayers() {
        assertEquals(List.of(player1, player2, player3, player4, player5, player6), game.findAll());
    }
    @Test
    void shouldReturnNullWhenNotRegistered() {
        assertNull(game.findByName("Vanya"));
    }

    @Test
    void shouldShowResultIfPlayer2Wins() {
        assertEquals(2, game.round("Riki", "John"));
    }

    @Test
    void shouldShowResultIfPlayer1Wins() {
        assertEquals(1, game.round("Anna", "Niki"));
    }
    @Test
    void shouldShowResultIfPlayersHaveEqualStrenghts() {
        assertEquals(0, game.round("Miki", "Bob"));
    }

      @Test
    void shouldThrowNotRegisteredExceptionWhenPlayer1Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Sasha", "John"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionWhenPlayer2Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Riki", "Viki"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionWhenBothPlayersUnregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Vanya", "Manya"));
    }
}

