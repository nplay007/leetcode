package JavaAnswer.four;

class MovingAverage {
    private int[] window;
    private int count;
    private int insert;
    private long sum;

    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (count < window.length) {
            count++;
        }
        sum += val;
        sum -= window[insert]; // remove val at insert position
        window[insert] = val;  // update value
        insert = (insert + 1) % window.length; // next valid insert position
        return (double) sum / count;
    }
}