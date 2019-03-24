import java.util.Comparator;

public class LowerBoundComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval intervalFirst, Interval intervalSecond) {
        int valueFirst = intervalFirst.getLowerBound();
        int valueSecond = intervalSecond.getLowerBound();

        if (valueFirst == valueSecond) {
            return 0;
        }
        return (valueFirst - valueSecond);
    }
}
