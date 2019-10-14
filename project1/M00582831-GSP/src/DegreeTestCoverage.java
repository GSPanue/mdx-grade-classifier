import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DegreeTestCoverage {
  @Test
  // Test better level 6 profile
  public void testClassifyWithBetterLevel6Profile() {
    List<Grade> year2 = new ArrayList<>();
    List<Grade> year3 = new ArrayList<>();

    // Upper second class, clear
    year2.add(new Grade(8));
    year2.add(new Grade(8));
    year2.add(new Grade(8));
    year2.add(new Grade(8));

    // First class, clear
    year3.add(new Grade(1));
    year3.add(new Grade(1));
    year3.add(new Grade(1));
    year3.add(new Grade(8));

    Degree degree = new Degree(year2, year3);

    assertEquals(Classification.First, degree.classify());
  }

  @Test
  // Test better level 5 profile
  public void testClassifyWithBetterLevel5Profile() {
    List<Grade> year2 = new ArrayList<>();
    List<Grade> year3 = new ArrayList<>();

    // First class, clear
    year2.add(new Grade(1));
    year2.add(new Grade(1));
    year2.add(new Grade(1));
    year2.add(new Grade(1));

    // Upper second class, clear
    year3.add(new Grade(1));
    year3.add(new Grade(8));
    year3.add(new Grade(8));
    year3.add(new Grade(8));

    Degree degree = new Degree(year2, year3);

    assertEquals(Classification.First, degree.classify());
  }
}
