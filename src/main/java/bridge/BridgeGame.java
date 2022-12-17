package bridge;

import constant.Side;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final int playerPositionIndex;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.playerPositionIndex = -1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean move(Side movingSide) {
        // TODO : 사용자 움직이는 메소드 추가
        // TODO : 반환값 변경
        // TODO : resultrepository 업데이트 기능 추가
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isFinished() {
        //TODO : 리턴값 변경 : 포지션 , 마지막 인덱스 비교
        return false;
    }
}

