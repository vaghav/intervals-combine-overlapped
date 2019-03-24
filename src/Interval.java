import java.util.TreeSet;
import java.util.stream.IntStream;

public class Interval {

    private int lowerBound;

    private int upperBound;

    private TreeSet<Integer> intervalValues;

    public Interval(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        intervalValues = new TreeSet<>();
        IntStream.rangeClosed(lowerBound, upperBound).forEach(intervalValues::add);
    }

    public TreeSet<Integer> getIntervalValues() {
        return intervalValues;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }
}
