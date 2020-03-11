import javafx.util.Pair;

public class LOOK extends ISchedule {
    LOOK(DiskSchedulerInfo info) {
        super(info);
    }

    @Override
    public void simulate() {
        info.sortRequests();
        //find first process that is after my current position (in the sorted list)
        int start = info.findNextIndex(currentPosition);
        for (int i = start; i < info.requests.size(); i++)
            directServeProcess(i);

        for (int i = start-1; i >= 0; i--)
            directServeProcess(i);
    }
}
