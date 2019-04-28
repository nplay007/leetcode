package JavaAnswer.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import JavaAnswer.Point;

class GrahamScan {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public int distance(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    private static Point bottomLeft(Point[] points) {
        Point bottomLeft = points[0];
        for (Point point : points) {
            if (point.y < bottomLeft.y) {
                bottomLeft = point;
            }
        }
        return bottomLeft;
    }

    public List<Point> outerTrees(Point[] points) {
        if (points.length <= 1) {
            return Arrays.asList(points);
        }
        Point bm = bottomLeft(points);
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p, Point q) {
                double diff = orientation(bm, p, q) - orientation(bm, q, p);
                if (diff == 0) {
                    return distance(bm, p) - distance(bm, q);
                }
                else {
                    return diff > 0 ? 1 : -1;
                }
            }
        });
        int i = points.length - 1;
        while (i >= 0 && orientation(bm, points[points.length - 1], points[i]) == 0) {
            i--;
        }
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int j = 2; j < points.length; j++) {
            Point top = stack.pop();
            while (orientation(stack.peek(), top, points[j]) > 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[j]);
        }
        return new ArrayList<>(stack);
    }
}

class MonotoneChain {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p, Point q) {
                return q.x - p.x == 0 ? q.y - p.y : q.x - p.x;
            }
        });
        Stack<Point> hull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        hull.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(hull));
    }
}
