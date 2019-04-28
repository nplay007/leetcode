package JavaAnswer.four;

public class Solution309 {
    public int maxProfit(int[] prices) {
        int uhold = 0, cool = Integer.MIN_VALUE, hold = Integer.MIN_VALUE;
        for (int price : prices) {
            hold = Math.max(hold, uhold - price) ;
            uhold = Math.max(uhold, cool);
            cool = hold + price;
        }
        return Math.max(uhold, cool);
    }
}