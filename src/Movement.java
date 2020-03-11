import java.util.List;

public class Movement {
    enum Direction {
        Forwards(1),
        Backwards(-1),
        Circular(null);

        final Integer val;

        Direction(Integer i) {
            val = i;
        }
    }

    final Direction typeOfMovement;
    final int valueOfMovment;

    Movement(Direction dir, int val) {
        typeOfMovement = dir;
        valueOfMovment = val;
    }

    static void printMovements(int initial, List<Movement> movements) {
        int pos = initial;
        for (Movement v : movements) {
            int newpos = pos;
            if (v.typeOfMovement == Direction.Circular) {
                newpos -= v.valueOfMovment;
                System.out.println("Reset head position from " + pos + " to " + newpos);
            } else {
                newpos += v.typeOfMovement.val * v.valueOfMovment;
                System.out.println("Move " + v.typeOfMovement.toString() + " from " + pos + " to " + newpos);
            }
            pos = newpos;
        }
    }

    static int getTotalMovements(List<Movement> movements) {
        int total = 0;
        for (Movement v : movements) {
            //if (v.typeOfMovement == Direction.Circular) continue;
            total += v.valueOfMovment;
        }
        return total;
    }
}
