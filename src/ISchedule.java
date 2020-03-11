import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class ISchedule {
    protected int currentPosition;

    protected final DiskSchedulerInfo info;

    private final List<Movement> movements;
    private final List<Integer> orderOfProcessing;

    ISchedule(DiskSchedulerInfo info) {
        this.info = info;
        this.currentPosition = info.headStart;
        this.movements = new ArrayList<>();
        this.orderOfProcessing = new ArrayList<>();
    }

    final List<Movement> getMovements() {
        return movements;
    }

    final List<Integer> getOrderOfProcessing() {
        return orderOfProcessing;
    }

    void resetHeadTo(int to) {
        if (to == currentPosition) return;
        movements.add(new Movement(Movement.Direction.Circular, currentPosition - to));
        currentPosition = to;
    }

    void moveHeadTo(int to) {
        int from = currentPosition;
        if (to > from)
            movements.add(new Movement(Movement.Direction.Forwards, to - from));
        else if (to < from)
            movements.add(new Movement(Movement.Direction.Backwards, from - to));

        currentPosition = to;
    }

    void processRequest(int idx) {
        orderOfProcessing.add(idx);
    }

    void directServeProcess(int idx) {
        Pair<Integer, Integer> v = info.requests.get(idx);
        moveHeadTo(v.getValue());
        processRequest(v.getKey());
    }

    public abstract void simulate();

}
