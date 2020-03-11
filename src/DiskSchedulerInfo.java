import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiskSchedulerInfo {
    final List<Pair<Integer, Integer>> requests;
    final int headStart;
    final int lastCylinder;

    public DiskSchedulerInfo(int[] requests, int headStart, int lastCylinder) {
        this.requests = new ArrayList<>();
        for (int i = 0; i < requests.length; ++i) {
            this.requests.add(new Pair<>(i, requests[i]));
        }
        this.headStart = headStart;
        this.lastCylinder = lastCylinder;
    }

    void sortRequests() {
        Collections.sort(requests, Comparator.comparing(Pair::getValue));
    }

    int findNextIndex(int pos){
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getValue() > pos) return i;
        }
        return 0;
    }
}
