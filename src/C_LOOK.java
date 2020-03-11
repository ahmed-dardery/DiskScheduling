import javafx.util.Pair;

public class C_LOOK extends ISchedule {
    C_LOOK(DiskSchedulerInfo info) {
        super(info);
    }

    @Override
    public void simulate() {
        info.sortRequests();
        //find first process that is after my current position (in the sorted list)
        int start = info.findNextIndex(currentPosition);
        for (int i = start; i < info.requests.size(); i++)
            directServeProcess(i);

        if (start > 0){
            Pair<Integer, Integer> v = info.requests.get(0);
            resetHeadTo(v.getValue());
            processRequest(v.getKey());
        }

        for (int i = 1; i < start; i++)
            directServeProcess(i);

    }
}
