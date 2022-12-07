package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @ParameterizedTest
    @MethodSource("generateTestNumbers")
    public void testMakeBridge(List<Integer> bridgeNumbers, List<String> bridgeFormat) {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(bridgeNumbers);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeNumbers.size());
        Assertions.assertThat(bridge).containsExactly(bridgeFormat.toArray(new String[0]));
    }

    private static class TestNumberGenerator implements BridgeNumberGenerator {
        List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

    private static Stream<Arguments> generateTestNumbers() {
        return Stream.of(
                Arguments.of(newArrayList(1, 0, 0), newArrayList("U", "D", "D")),
                Arguments.of(newArrayList(1, 1, 1, 0), newArrayList("U", "U", "U", "D")),
                Arguments.of(newArrayList(1, 1, 1, 0, 1),  newArrayList("U", "U", "U", "D", "U"))
        );
    }
}

