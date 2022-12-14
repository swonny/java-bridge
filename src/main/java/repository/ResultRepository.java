package repository;

import constant.Side;
import constant.Status;

import java.util.*;

public class ResultRepository {
    private static final String EMPTY = " ";
    private static final String MOVE_SUCCESSFULLY = "O";
    private static final String MOVE_FAILED = "X";
    private static final EnumMap<Side, List<String>> resultMap = new EnumMap<>(Side.class);
    private static int trial = 0;
    private static Status status;


    public static void updateResult(boolean movedSuccessfully, Side movingSide) {
        if (!movedSuccessfully) {
            status = Status.FAIL;
        }
        String movingSymbol = getMovingSymbol(movedSuccessfully);
        resultMap.get(movingSide).add(movingSymbol);
        resultMap.get(movingSide.getOppositeSide()).add(EMPTY);
    }

    private static String getMovingSymbol(boolean movedSuccessfully) {
        if (movedSuccessfully) {
            return MOVE_SUCCESSFULLY;
        }
        return MOVE_FAILED;
    }

    public static EnumMap<Side, List<String>> getResultMap() {
        return resultMap;
    }

    public static Status getStatus() {
        return status;
    }

    public static int getTrial() {
        return trial;
    }

    private static void addTrial() {
        trial++;
    }

    public static boolean isFail() {
        return Status.FAIL.equals(status);
    }

    public static void retry() {
        addTrial();
        resultMap.clear();
        initialize();
    }

    public static void initialize() {
        addTrial();
        status = Status.CONTINUE;
        resultMap.put(Side.UP, new ArrayList<>());
        resultMap.put(Side.DOWN, new ArrayList<>());
    }
}
