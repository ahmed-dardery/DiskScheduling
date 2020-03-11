import javafx.util.Pair;

public class SCAN extends ISchedule {
    SCAN(DiskSchedulerInfo info) {
        super(info);
    }

    @Override
    public void simulate() {
        info.sortRequests();
        //find first process that is after my current position (in the sorted list)
        int start = info.findNextIndex(currentPosition);
        for (int i = start; i < info.requests.size(); i++)
            directServeProcess(i);

        if (start > 0) moveHeadTo(info.lastCylinder);

        for (int i = start-1; i >= 0; i--)
            directServeProcess(i);
    }
}
