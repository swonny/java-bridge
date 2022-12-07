package bridge.exceptions;

import bridge.exceptions.enums.BridgeExceptionMessages;
import view.exceptions.enums.Exceptions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BridgeExceptions {
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final String UP = "U";
    private static final String DOWN = "D";

    public static void validate(List<String> movableSide) {
        validateRange(movableSide);
        validateLength(movableSide);
    }

    private static void validateLength(List<String> movableSide) {
        if (movableSide.size() > MAXIMUM_BRIDGE_SIZE || movableSide.size() < MINIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BridgeExceptionMessages.OUT_OF_BRIDGE_SIZE.get());
        }
    }

    public static void validateRange(List<String> movableSide) {
        if (movableSide.stream().collect(Collectors.joining("")).matches("/[^UD]/+g")) {
            throw new IllegalArgumentException(Exceptions.OUT_OF_BRIDGE_SIZE.get());
        }
    }
}
