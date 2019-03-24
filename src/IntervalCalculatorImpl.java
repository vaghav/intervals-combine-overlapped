import java.util.*;

public class IntervalCalculatorImpl implements IntervalCalculator {

    @Override
    public List<Interval> mergeOverlapped(List<Interval> intervals) {

        intervals.sort(new LowerBoundComparator());

        Deque<Interval> intervalStack = new ArrayDeque<>();

        intervalStack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval retrieved = intervalStack.pop();
            Interval current = intervals.get(i);

            if (isOverlappingExists(retrieved, current)) {
                intervalStack.push(retrieved);
                continue;
            }

            if (isIntersectionExists(retrieved, current)) {
                intervalStack.push(new Interval(retrieved.getLowerBound(), current.getUpperBound()));
            } else {
                intervalStack.push(retrieved);
                intervalStack.push(current);
            }
        }

        List<Interval> list = new ArrayList(intervalStack);
        Collections.reverse(list);
        return list;
    }

    private boolean isOverlappingExists(Interval retrieved, Interval current) {
        return retrieved.getUpperBound() >= current.getUpperBound();
    }

    private boolean isIntersectionExists(Interval retrieved, Interval current) {
        return retrieved.getLowerBound() <= current.getLowerBound()
                && retrieved.getUpperBound() >= current.getLowerBound();
    }
}
