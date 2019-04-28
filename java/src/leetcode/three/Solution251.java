package JavaAnswer.three;

import java.util.Iterator;
import java.util.List;

class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> iter;
    private Iterator<Integer> cur;

    public Vector2D(List<List<Integer>> vec2d) {
        iter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        while ((cur == null || !cur.hasNext()) && iter.hasNext()) {
            cur = iter.next().iterator();
        }
        return cur != null && cur.hasNext();
    }
}