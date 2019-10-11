import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfileTest {
    @Test
    // Test empty list throws exception
    public void testConstructorWithEmptyList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           List<Grade> grades = new ArrayList<>();

           new Profile(grades);
        });
    }

    @Test
    // Test null list throws exception
    public void testConstructorWithNullList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Profile(null);
        });
    }

    @Test
    // Test list with fail grade throws exception
    public void testConstructorWithFailGrade() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Grade> grades = new ArrayList<>();
            
            grades.add(new Grade(1));
            grades.add(new Grade(1));
            grades.add(new Grade(1));
            grades.add(new Grade(17));

            new Profile(grades);
        });
    }

    @Test
    // Test for First class classification
    public void testClassifyFirstClassClassification() {
        List<Grade> grades = new ArrayList<>();

        grades.add(new Grade(1));
        grades.add(new Grade(1));
        grades.add(new Grade(1));
        grades.add(new Grade(1));

        Profile profile = new Profile(grades);

        assertEquals(Classification.First, profile.classify());
    }

    @Test
    // Test for Upper Second class classification
    public void testClassifyUpperSecondClassClassification() {
        List<Grade> grades = new ArrayList<>();

        grades.add(new Grade(5));
        grades.add(new Grade(5));
        grades.add(new Grade(5));
        grades.add(new Grade(5));

        Profile profile = new Profile(grades);

        assertEquals(Classification.UpperSecond, profile.classify());
    }

    @Test
    // Test for Lower Second class classification
    public void testClassifyLowerSecondClassClassification() {
        List<Grade> grades = new ArrayList<>();

        grades.add(new Grade(9));
        grades.add(new Grade(9));
        grades.add(new Grade(9));
        grades.add(new Grade(9));

        Profile profile = new Profile(grades);

        assertEquals(Classification.LowerSecond, profile.classify());
    }

    @Test
    // Test for Third class classification
    public void testClassifyThirdClassClassification() {
        List<Grade> grades = new ArrayList<>();

        grades.add(new Grade(13));
        grades.add(new Grade(13));
        grades.add(new Grade(13));
        grades.add(new Grade(13));

        Profile profile = new Profile(grades);

        assertEquals(Classification.Third, profile.classify());
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1, 1, true", "1, 1, 16, 16, false"})
    // Test isClear returns the correct truth value
    public void isClear(String grade1, String grade2, String grade3, String grade4, String expectedResult) {
        List<Grade> grades = new ArrayList<>();

        grades.add(new Grade(Integer.parseInt(grade1)));
        grades.add(new Grade(Integer.parseInt(grade2)));
        grades.add(new Grade(Integer.parseInt(grade3)));
        grades.add(new Grade(Integer.parseInt(grade4)));

        Profile profile = new Profile(grades);

        assertEquals(Boolean.parseBoolean(expectedResult), profile.isClear());
    }
}
