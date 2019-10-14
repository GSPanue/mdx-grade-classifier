import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProfileTestCoverage {
  @Test
  // Test isClear returns the correct truth value for lower second class profile
  public void testIsClearWithLowerSecondClassProfile() {
    List<Grade> grades = new ArrayList<>();

    grades.add(new Grade(12));
    grades.add(new Grade(12));
    grades.add(new Grade(12));
    grades.add(new Grade(12));

    Profile profile = new Profile(grades);

    assertTrue(profile.isClear());
  }

  @Test
  // Test isClear returns the correct truth value for third class profile
  public void testIsClearWithThirdClassProfile() {
    List<Grade> grades = new ArrayList<>();

    grades.add(new Grade(16));
    grades.add(new Grade(16));
    grades.add(new Grade(16));
    grades.add(new Grade(16));

    Profile profile = new Profile(grades);

    assertTrue(profile.isClear());
  }
}
