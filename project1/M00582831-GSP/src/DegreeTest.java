import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DegreeTest {
    @Test
    // Test null list throws exception
    public void testConstructorWithNullList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Grade> year2 = new ArrayList<>();

            year2.add(new Grade(1));
            year2.add(new Grade(1));
            year2.add(new Grade(1));
            year2.add(new Grade(1));

            new Degree(year2, null);
        });
    }

    @Test
    // Test list not containing four grades throws exception
    public void testConstructorWithWrongNumberOfGrades() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Grade> year2 = new ArrayList<>();
            List<Grade> year3 = new ArrayList<>();

            year2.add(new Grade(1));
            year2.add(new Grade(1));
            year2.add(new Grade(1));
            year2.add(new Grade(1));

            year3.add(new Grade(1));
            year3.add(new Grade(1));
            year3.add(new Grade(1));

            new Degree(year2, year3);
        });
    }

    @Test
    // Test list containing fail grade throws exception
    public void testConstructorWithFailGradeInList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Grade> year2 = new ArrayList<>();
            List<Grade> year3 = new ArrayList<>();

            year2.add(new Grade(1));
            year2.add(new Grade(1));
            year2.add(new Grade(1));
            year2.add(new Grade(1));

            year3.add(new Grade(1));
            year3.add(new Grade(1));
            year3.add(new Grade(1));
            year3.add(new Grade(17));

            new Degree(year2, year3);
        });
    }

    @Test
    // Test for First class classification
    public void testClassifyFirstClassClassification() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));

        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(1));

        Degree degree = new Degree(year2, year3);

        assertEquals(Classification.First, degree.classify());
    }

    @Test
    // Test for Upper Second class classification
    public void testClassifyUpperSecondClassClassification() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(5));
        year2.add(new Grade(5));
        year2.add(new Grade(5));
        year2.add(new Grade(5));

        year3.add(new Grade(5));
        year3.add(new Grade(5));
        year3.add(new Grade(5));
        year3.add(new Grade(5));

        Degree degree = new Degree(year2, year3);

        assertEquals(Classification.UpperSecond, degree.classify());
    }

    @Test
    // Test for Lower Second class classification
    public void testClassifyLowerSecondClassClassification() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(9));
        year2.add(new Grade(9));
        year2.add(new Grade(9));
        year2.add(new Grade(9));

        year3.add(new Grade(9));
        year3.add(new Grade(9));
        year3.add(new Grade(9));
        year3.add(new Grade(9));

        Degree degree = new Degree(year2, year3);

        assertEquals(Classification.LowerSecond, degree.classify());
    }

    @Test
    // Test for Third class classification
    public void testClassifyThirdClassClassification() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(13));
        year2.add(new Grade(13));
        year2.add(new Grade(13));
        year2.add(new Grade(13));

        year3.add(new Grade(13));
        year3.add(new Grade(13));
        year3.add(new Grade(13));
        year3.add(new Grade(13));

        Degree degree = new Degree(year2, year3);

        assertEquals(Classification.Third, degree.classify());
    }

    @Test
    // Test for classification with discretion
    public void testClassifyClassificationWithDiscretion() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        // First class, borderline
        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(16));
        year2.add(new Grade(16));

        // Upper second class, borderline
        year3.add(new Grade(5));
        year3.add(new Grade(5));
        year3.add(new Grade(16));
        year3.add(new Grade(16));

        Degree degree = new Degree(year2, year3);

        assertEquals(Classification.Discretion, degree.classify());
    }
}
