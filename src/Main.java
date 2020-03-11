import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    /*
    8 53
    98 183 37 122 14 124 65 67

    9 120
    38 180 130 10 50 15 190 90 150

    9 80
    162 20 70 190 150 185 10 110 50
    */
    public static void main(String[] args) {

        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        DiskSchedulerInfo dsi = new DiskSchedulerInfo(arr, q, 200);
        ISchedule[] scs = new ISchedule[]{
                new FCFS(dsi),
                new SSTF(dsi),
                new SCAN(dsi),
                new C_SCAN(dsi),
                new LOOK(dsi),
                new C_LOOK(dsi),
                new Optimized(dsi)
        };
        for (ISchedule sc : scs) {
            System.out.println("---------------------------");
            System.out.println(sc.getClass().getName());
            System.out.println("---------------------------");

            sc.simulate();
            Movement.printMovements(dsi.headStart, sc.getMovements());
            System.out.print("Order of processing: ");
            for (int v : sc.getOrderOfProcessing()) {
                System.out.print(v + " ");
            }
            System.out.println();
            System.out.println("Total Movement is: " + Movement.getTotalMovements(sc.getMovements()));
        }
    }
}
