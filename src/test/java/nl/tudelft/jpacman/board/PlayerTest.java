package nl.tudelft.jpacman.board;


import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    PacManSprites SPRITE_STORE = new PacManSprites();
    PlayerFactory playerFactory;
    Player playerDefault;
    Player playerCustom;
    public void setUp() {
        playerFactory = new PlayerFactory(SPRITE_STORE);
        playerDefault = playerFactory.createPacMan();
        playerCustom = playerFactory.createPacMan(10);
    }
    @Test
    public void testCreatePacMan() {
        assertThat( playerDefault.getLives()).isEqualTo(3);
        assertThat( playerCustom.getLives()).isEqualTo(10);
    }

    @Test
    public void testDecrementLives() {
        playerDefault.decrementLives(1);
        assertThat(playerDefault.getLives()).isEqualTo(2);
        playerDefault.decrementLives(2);
        assertThat(playerDefault.getLives()).isEqualTo(0);
    }



}
