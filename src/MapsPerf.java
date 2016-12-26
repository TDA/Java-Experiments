import java.util.HashMap;

public class MapsPerf {
    public static void main(String args[]) {
        long avgRunningTime = 0;
        long startTime = System.nanoTime();
        for (int j = 0; j < 1000; j++) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < 10000; i++) {
                hashMap.put(i, i);
            }
        }
        long endTime = System.nanoTime();
        avgRunningTime += (endTime - startTime) / 1000;
        System.out.println("Average running time is " + avgRunningTime + " nano secs");
        System.out.println("Average running time is " + avgRunningTime/1000 + " micro secs");
        System.out.println("Average running time is " + avgRunningTime/1000000.0 + " milli secs");

        long avgRunningTimeStaticBlock = 0;
        long startTimeStaticBlock = System.nanoTime();
        for (int j = 0; j < 1000; j++) {
            HashMap hashMap = new HashMap() {
                {
                    for (int i = 0; i < 10000; i++) {
                        this.put(i, i);
                    }
                }
            };
        }
        long endTimeStaticBlock = System.nanoTime();
        avgRunningTimeStaticBlock += (endTimeStaticBlock - startTimeStaticBlock) / 1000;
        System.out.println("Average running time is " + avgRunningTimeStaticBlock + " nano secs");
        System.out.println("Average running time is " + avgRunningTimeStaticBlock/1000 + " micro secs");
        System.out.println("Average running time is " + avgRunningTimeStaticBlock/1000000.0 + " milli secs");
    }
}

// Surprisingly using the static block is faster on most occasions  compared to the hashmap plus for loop
// this is surprising because static block creates new anonymous inner class every time it executes
// while the for loop does not do so.  not sure why this behavior is exhibited.
