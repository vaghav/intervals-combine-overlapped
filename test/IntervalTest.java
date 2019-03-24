import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class IntervalTest {

    @Test
    public void shouldFillSetWithValues() {

        Interval interval = new Interval(1, 10);

        TreeSet<Integer> expected = interval.getIntervalValues();

        Assertions.assertEquals(expected.first().intValue(), 1);
        Assertions.assertEquals(expected.last().intValue(), 10);
    }
}
