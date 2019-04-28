package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;


// http://blog.csdn.net/jmspan/article/details/51749521
public class ConsistentHashingII {

    private TreeMap<Integer, Integer> tm = new TreeMap<>();

    private int[] nums;
    private int size = 0;
    private int k;

    public ConsistentHashingII(int n, int k) {
            this.nums = new int[n];
            for(int i = 0; i < n; i++) this.nums[i] = i;

            Random random = new Random();
            for(int i = 0; i < n; i++) {
                int j = random.nextInt(i + 1);
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            this.k = k;
        }

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static ConsistentHashingII create(int n, int k) {
        // Write your code here
        return new ConsistentHashingII(n, k);
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < this.k; i++) {
            int id = this.nums[size++ % this.nums.length];
            ids.add(id);
            this.tm.put(id, machine_id);
        }
        return ids;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        if (tm.isEmpty())
            return 0;
        Integer ceiling = tm.ceilingKey(hashcode);
        if (ceiling != null)
            return tm.get(ceiling);
        return tm.get(tm.firstKey());
    }
}
