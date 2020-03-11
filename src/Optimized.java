public class Optimized extends ISchedule {
    Optimized(DiskSchedulerInfo info) {
        super(info);
    }

    @Override
    public void simulate() {
        info.sortRequests();
        resetHeadTo(0);
        for (int i = 0; i < info.requests.size(); i++)
            directServeProcess(i);
    }
}
