package repository;

import constant.Side;
import constant.Status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ResultRepository {
    // TODO : 게임 성공, 실패, 진행중 저장하기
    // TODO : Status로 저장, 출력 시 더 편함, 저장도 편함.
    private static final List<List<Side>> resultMap = new ArrayList<>();
    private static int trial;

    public static void updateResult(boolean movedSuccessfully, Side movingSide) {
        // TODO : 결과 업데이트하기
    }

    public static List<List<Status>> getResultMap() {
        // TODO : 결과 반환하기
        return Collections.EMPTY_LIST;
    }

    public static Status getStatus() {
        // TODO : 결과 반환하기
        return null;
    }


    public static int getTrial() {
        return trial;
    }
}
