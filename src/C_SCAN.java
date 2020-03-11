public class C_SCAN extends ISchedule {
    C_SCAN(DiskSchedulerInfo info) {
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
            moveHeadTo(info.lastCylinder);
            resetHeadTo(0);
        }

        for (int i = 0; i < start; i++)
            directServeProcess(i);

    }
}
