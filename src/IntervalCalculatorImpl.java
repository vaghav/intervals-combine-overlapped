import java.util.*;

public class IntervalCalculatorImpl implements IntervalCalculator {

    @Override
    public List<Interval> mergeOverlapped(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            throw new IllegalArgumentException("Intervals can't be empty or null");
        }

        intervals.sort(new LowerBoundComparator());

        List<Interval> mergedIntervalsList = new ArrayList<>();

        Interval lastProcessed = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            if (isIntersectionExists(lastProcessed, current)) {
                lastProcessed = new Interval(Math.min(lastProcessed.getLowerBound(), current.getLowerBound()),
                        Math.max(lastProcessed.getUpperBound(), current.getUpperBound()));
            } else {
                mergedIntervalsList.add(lastProcessed);
                lastProcessed = current;
            }
        }

        mergedIntervalsList.add(lastProcessed);
        return mergedIntervalsList;
    }

    private boolean isIntersectionExists(Interval processed, Interval current) {
        return processed.getLowerBound() <= current.getUpperBound()
                && processed.getUpperBound() >= current.getLowerBound();
    }
}
