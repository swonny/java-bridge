package bridge;

import bridge.enums.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testMove() {
        Player player = new Player(0);
        player.move(Side.UP);
        assertThat(player.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    void testGetCurrentPosition() {
    }

    @Test
    void testGetLastMoving() {
    }
}