package HW;

import Lesson_6.HW.Task1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {

    @Parameterized.Parameters
    public static Collection<Object[]> Arrays() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, new int[]{1, 5, 7, 3, 4, 8, 3, 4, 2, 5}},
                {new int[]{0, 2}, new int[]{5, 7, 8, 6, 4, 9, 0, 4, 1, 7}},
                {new int[]{0, 3, 2}, new int[]{4, 7, 9, 6, 2, 4, 0, 4, 1, 7}},
                {new int[]{8, 3, 5, 2, 5}, new int[]{0, 3, 7, 5, 4, 8, 3, 5, 2, 5}},
        });
    }

    private Task1 task;

    private int[] x;

    private int[] y;

    public Test1(int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }

    @Before
    public void init() {
        task = new Task1();
    }

    @Test
    public void test1(){
        Assert.assertArrayEquals("Arrays not equals", x, task.checkArray(y));
    }
}