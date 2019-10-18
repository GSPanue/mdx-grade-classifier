import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfileTestCoverage {
  @ParameterizedTest
  @CsvSource({
      "8, 8, 8, 8, true", // Clear upper second class profile
      "8, 8, 16, 16, false", // Borderline upper second class profile
      "12, 12, 12, 12, true", // Clear lower second class profile
      "12, 12, 16, 16, true", // Clear lower second class profile
      "16, 16, 16, 16, true" // Clear third class profile
  })
  // Test isClear returns the correct truth value
  public void testIsClear(String grade1, String grade2, String grade3, String grade4, String expectedResult) {
    List<Grade> grades = new ArrayList<>();

    grades.add(new Grade(Integer.parseInt(grade1)));
    grades.add(new Grade(Integer.parseInt(grade2)));
    grades.add(new Grade(Integer.parseInt(grade3)));
    grades.add(new Grade(Integer.parseInt(grade4)));

    Profile profile = new Profile(grades);

    assertEquals(Boolean.parseBoolean(expectedResult), profile.isClear());
  }
}
