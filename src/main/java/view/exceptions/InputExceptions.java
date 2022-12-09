package view.exceptions;

import view.exceptions.enums.Exceptions;

public class InputExceptions {
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final String regex = "[0-9]+";
    private static final String QUIT = "Q";
    private static final String RESTART = "R";
    private static final String UP = "U";
    private static final String DOWN = "D";

    public static void validateBridgeSize(String bridgeSize) {
        validateNumericOnly(bridgeSize);
        validateBridgeRange(bridgeSize);
    }

    private static void validateNumericOnly(String bridgeSize) {
        if (!bridgeSize.matches(regex)) {
            throw new IllegalArgumentException(Exceptions.INCLUDE_CHARACTER.get());
        }
    }

    public static void validateBridgeRange(String bridgeSize) {
        if (Integer.valueOf(bridgeSize) < MINIMUM_BRIDGE_SIZE || Integer.valueOf(bridgeSize) > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Exceptions.OUT_OF_BRIDGE_SIZE.get());
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(QUIT) && !gameCommand.equals(RESTART)) {
            throw new IllegalArgumentException(Exceptions.NOT_GAME_COMMAND.get());
        }
    }

    public static void validateMovingSide(String movingSide) {
        if (!movingSide.equals(UP) && !movingSide.equals(DOWN)) {
            throw new IllegalArgumentException(Exceptions.NOT_SIDE.get());
        }
    }
}
