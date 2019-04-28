package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
* Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
* Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
*
*
* 方法1：max heap
* 分析：time: O(nlgn), space: O(n)
*
* 方法2：quick select
* */

public class KClosestPoints {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 方法1: max heap
    public Point[] findKClosestPoints(Point[] points, int k, Point target) {
        if (points == null || points.length == 0 || k < 1 || k > points.length) {
            return points;
        }
        Comparator<Point> cmp = new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int distOfa = (a.x - target.x) * (a.x - target.x) + (a.y - target.y) * (a.y - target.y);
                int distOfb = (b.x - target.x) * (b.x - target.x) + (b.y - target.y) * (b.y - target.y);
                if (distOfa != distOfb) {
                    return distOfb - distOfa;
                }
                else {
                    if (a.x != b.x) {
                        return b.x - a.x;
                    }
                    else {
                        return b.y - a.y;
                    }
                }
            }
        };
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(cmp);
        maxHeap.addAll(Arrays.asList(points));
        for (Point point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        Point[] result = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    /*
     * Solution 2: QuickSelect time: O(n) average, O(n + klogk) time if output is sorted; O(n^2) worst case space: O(1)
     */
    public Point QuickSelect(Point[] points, int k, Point target, int start, int end) {
        if (start > end) {
            return null;
        }
        Point pivot = points[end];
        int leftIndex = start;
        for (int i = start; i < end; i++) {
            if (getDistance(points[i], target) <= getDistance(pivot, target)) {
                swap(points, leftIndex++, i);
            }
        }
        swap(points, leftIndex, end);
        if (leftIndex == k) {
            return points[leftIndex];
        }
        else if (leftIndex < k) {
            return QuickSelect(points, k, target, leftIndex + 1, end);
        }
        else {
            return QuickSelect(points, k, target, start, leftIndex - 1);
        }
    }

    private int getDistance(Point p, Point target) {
        return (p.x - target.x) * (p.x - target.x) + (p.y - target.y) * (p.y - target.y);
    }

    private static void swap(Point[] points, int left, int right) {
        Point temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }
}
