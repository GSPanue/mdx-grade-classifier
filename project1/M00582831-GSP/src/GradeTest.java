import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GradeTest {
    @Test
    // Test point below range throws exception
    public void testConstructorBelowRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Grade(0);
        });
    }

    @Test
    // Test point above range throws exception
    public void testConstructorAboveRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Grade(21);
        });
    }

    @Test
    // Test getPoints returns the correct value
    public void testGetPoints() {
        Grade grade = new Grade(1);

        assertEquals(1, grade.getPoints());
    }

    @Test
    // Test for First class classification
    public void testFirstClassClassification() {
        Grade grade = new Grade(4);

        assertEquals(Classification.First, grade.classify());
    }

    @Test
    // Test for Upper Second class classification
    public void testUpperSecondClassClassification() {
        Grade grade = new Grade(8);

        assertEquals(Classification.UpperSecond, grade.classify());
    }

    @Test
    // Test for Lower Second class classification
    public void testLowerSecondClassClassification() {
        Grade grade = new Grade(12);

        assertEquals(Classification.LowerSecond, grade.classify());
    }

    @Test
    // Test for Third class classification
    public void testThirdClassClassification() {
        Grade grade = new Grade(16);

        assertEquals(Classification.Third, grade.classify());
    }

    @Test
    // Test for Fail classification
    public void testFailClassification() {
        Grade grade = new Grade(17);

        assertEquals(Classification.Fail, grade.classify());
    }

    @Test
    // Test percentage below range throws exception
    public void testFromPercentageBelowRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Grade.fromPercentage(-2);
        });
    }

    @Test
    // Test percentage above range throws exception
    public void testFromPercentageAboveRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Grade.fromPercentage(101);
        });
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {-1, 20},
                {0, 19},
                {30, 18},
                {35, 17},
                {40, 16},
                {42, 15},
                {45, 14},
                {47, 13},
                {50, 12},
                {52, 11},
                {55, 10},
                {57, 9},
                {60, 8},
                {62, 7},
                {65, 6},
                {67, 5},
                {70, 4},
                {73, 3},
                {76, 2},
                {79, 1},
        });
    }

    @Parameter(0)
    public int percentage;

    @Parameter(1)
    public int point;

    @Test
    // Test fromPercentage returns the correct point
    public void testFromPercentage() {
        Grade grade = Grade.fromPercentage(percentage);
        assertEquals(point, grade.getPoints());
    }
}
