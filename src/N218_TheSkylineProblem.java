import java.util.*;
public class N218_TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a,b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int prev = 0;
        queue.offer(prev);
        for (int[] height : heights) {
            if (height[1] < 0) {
                queue.offer(-height[1]);
            } else {
                queue.remove(height[1]);
            }
            int currMax = queue.peek();
            if (prev != currMax) {
                res.add(new int[]{height[0], currMax});
                prev = currMax;
            }
        }
        return res;
    }
}