package my.lesson_7.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumCountTest {

    private SumCount sumCount;

    @Before
    public void createClass() {
        sumCount = new SumCount();
    }

    @Test
    public void sumTestRight() {
        int c = sumCount.sum(5, 5);
        Assert.assertEquals(c, 10);
    }

    @Test
    public void sumTestWrong() {
        int c = sumCount.sum(5, -5);
        Assert.assertNotEquals(c, 10);
    }

}
