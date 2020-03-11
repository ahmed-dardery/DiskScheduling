import javafx.util.Pair;

public class FCFS extends ISchedule {

    FCFS(DiskSchedulerInfo info) {
        super(info);
    }

    @Override
    public void simulate() {

        for (int i = 0; i < info.requests.size(); ++i)
            directServeProcess(i);

    }
}
