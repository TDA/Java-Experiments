import java.util.HashMap;

public class MapsPerf {
    static {
        long startTime = System.nanoTime();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 10000; i++) {
            hashMap.put(i, i);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
