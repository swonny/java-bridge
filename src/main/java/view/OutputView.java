package view;

import bridge.BridgeGame;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import enumCollections.UserInterfaceSymbol;

import java.util.List;

public class OutputView {
    public void printMap(List<List<String>> map) {
        map.stream().forEach(line -> {
                    printBridge(String.join(" | ", line));
                });
    }

    public void printResult(GameStatus gameResult, BridgeGame bridgeGame) {
        printGuideMessage(GuideMessage.RESULT_PRINT);
        printMap(bridgeGame.getMap());
        printNewline();
        printResult(gameResult);
        printGuideMessage(GuideMessage.GAME_TRIAL, bridgeGame.getTrial());
    }

    public void printResult(GameStatus gameStatus) {
        printGuideMessage(GuideMessage.GAME_RESULT ,GameStatus.get(gameStatus));
    }

    public void printAskGameCommand() {
        printGuideMessage(GuideMessage.GET_GAME_COMMAND);
    }

    public void printGuideMessage(GuideMessage situation) {
        System.out.println(GuideMessage.get(situation));
    }

    public void printGuideMessage(GuideMessage situation, String gameStatus) {
        System.out.printf(GuideMessage.get(situation), gameStatus);
    }

    public void printNewline() {
        System.out.println();
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private void printBridge(String line) {
        System.out.println(
                UserInterfaceSymbol.get(UserInterfaceSymbol.START_OF_BRIDGE)
                        .concat(line)
                        .concat(UserInterfaceSymbol.get(UserInterfaceSymbol.END_OF_BRIDGE))
        );
    }
}
