package bridge;

import enumCollections.Side;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {
    private static final int INITIALIZED_POSITION = -1;
    Player player;

    @Test
    public void testInitializePosition() {
        Player player = new Player(INITIALIZED_POSITION);
        assertThat(player.getCurrentPosition())
                .isEqualTo(-1);
    }

    @Test
    public void testMove() {
        Player player = new Player(INITIALIZED_POSITION);
        player.move(Side.UP.getBridgeSavingFormat());
        assertThat(player.getLastMoving())
                .isEqualTo(Side.UP.getBridgeSavingFormat());
    }

    static Stream<Arguments> generateFootprints() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D")),
                Arguments.of(List.of("U", "D", "U", "D")),
                Arguments.of(List.of("U", "D", "U", "D", "U")),
                Arguments.of(List.of("U", "D", "U", "D", "D"))
        );
    }
}