package bridge;

import bridge.enums.Side;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {
    @ParameterizedTest
    @MethodSource("validateWrongMovableSide")
    public void testBridge_잘못된값(String wrongMovableSide) {
        System.out.println(wrongMovableSide + " " + wrongMovableSide.matches("[^UD]+"));
    }

    @ParameterizedTest
    @MethodSource("validateRightMovableSide")
    public void testBridge_정상값(String wrongMovableSide) {
        System.out.println(wrongMovableSide + " " + wrongMovableSide.matches("/[^UD]/"));
    }

    @ParameterizedTest
    @MethodSource("isLastPosition")
    public void testIsLastPosition(List<String> movableSide, int playerPosition, boolean expected) {
        Bridge bridge = new Bridge(movableSide);
        assertThat(bridge.isLastPosition(playerPosition)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("isPlayerOnMovableSide")
    public void testIsPlayerOnMovableSide(List<String> movableSide, int playerPosition, Side movedSide , boolean expected) {
        Bridge bridge = new Bridge(movableSide);
        assertThat(bridge.isPlayerOnMovableSide(playerPosition, movedSide)).isEqualTo(expected);
    }

    private static Stream<String> validateWrongMovableSide() {
        return Stream.of("a", "b", "1", "0", "01", "u", "d", " U", " D", "U  ", "D  ");
    }

    private static Stream<String> validateRightMovableSide() {
        return Stream.of("a", "b", "1", "0", "01", "u", "d", " U", " D", "U  ", "D  ");
    }

    private static Stream<Arguments> isLastPosition() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D", "U", "U", "D", "U", "U", "D"), 8, true),
                Arguments.of(List.of("U", "U", "D", "U", "U", "D", "U", "U", "D"), 3, false),
                Arguments.of(List.of("U", "U", "D", "U", "U", "D", "U", "U", "D"), 0, false),
                Arguments.of(List.of("U", "U", "D", "U", "U", "D", "U", "U", "D", "D"), 9, true),
                Arguments.of(List.of("U", "U", "D", "U", "U", "D", "U", "U", "D", "D"), -1, false),
                Arguments.of(List.of(
                        "U", "U", "D", "U", "U", "D", "U", "U", "D",
                        "D", "U", "U", "D", "U", "U", "D", "U", "U", "D", "D"
                ), -1, false),
                Arguments.of(List.of(
                        "U", "U", "D", "U", "U", "D", "U", "U", "D",
                        "D", "U", "U", "D", "U", "U", "D", "U", "U", "D", "D"
                ), 19, true),
                Arguments.of(List.of(
                        "U", "U", "D", "U", "U", "D", "U", "U", "D",
                        "D", "U", "U", "D", "U", "U", "D", "U", "U", "D", "D"
                ), 20, false)
        );
    }

    private static Stream<Arguments> isPlayerOnMovableSide() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D"), 0, Side.UP, true),
                Arguments.of(List.of("U", "U", "D"), 0, Side.DOWN, false),
                Arguments.of(List.of("U", "U", "D"), 2, Side.UP, false),
                Arguments.of(List.of("U", "U", "D"), 2, Side.DOWN, true)
        );
    }
}
