package bridge;

import enumCollections.AvailableInput;
import enumCollections.GameStatus;
import enumCollections.Side;

import java.util.List;

public class BridgeGame {
    private final int INITIALIZED_TRIAL = 1;
    private final int INITIALIZED_PLAYER_POSITION = -1;
    private final Map map = new Map();

    private Bridge bridge;
    private Player player;
    private int trial;

    public BridgeGame() {
        trial = INITIALIZED_TRIAL;
        player = new Player(INITIALIZED_PLAYER_POSITION);
    }

    public void generateBridge(final int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void move(final String sideToMove) {
        this.player.move(sideToMove);
        updateMap();
    }

    public boolean isPlayerInMovableSide() {
        return bridge.isMovableSide(
                player.getLastMoving(),
                player.getCurrentPosition()
        );
    }

    public boolean retry(final String gameCommand) {
        if (gameCommand.equals(AvailableInput.RETRY_COMMAND.getUserInput())) {
            initialize_game();
            addTrial();
            return true;
        }
        return false;
    }

    public GameStatus isGameFinished() {
        if (this.bridge.isLastPosition(this.player.getCurrentPosition())) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    public String getTrial() {
        return Integer.toString(this.trial);
    }

    public List<List<String>> getMap() {
        return this.map.get();
    }

    private void initialize_game() {
        player = new Player(INITIALIZED_PLAYER_POSITION);
        map.initialize();
    }

    private void updateMap() {
        this.map.add(
                Side.get(player.getLastMoving()),
                isPlayerInMovableSide()
        );
    }

    private void addTrial() {
        this.trial++;
    }
}