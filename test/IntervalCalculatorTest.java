import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IntervalCalculatorTest {

    @Test
    public void shouldMergeOverlappedIntervals() {

        IntervalCalculatorImpl intervalCalculator = new IntervalCalculatorImpl();
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1, 5),
                new Interval(10, 15),
                new Interval(16, 18),
                new Interval(17, 20),
                new Interval(11, 13),
                new Interval(3, 8),
                new Interval(21, 30),
                new Interval(32, 33),
                new Interval(33, 35),
                new Interval(38, 40)));

        List<Interval> actual = intervalCalculator.mergeOverlapped(intervals);

        //TODO: Test should be added
        Assertions.assertEquals(new Interval(1, 8), actual.get(0));
    }
}
