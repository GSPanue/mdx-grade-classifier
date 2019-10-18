import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Degree {
  // Your additions/changes below this line
  private final List<Classification> CLASSIFICATIONS = Arrays.asList(Classification.values());
  private List<Grade> year2;
  private List<Grade> year3;
  private Profile level5;
  private Profile level6;

  public Degree(List<Grade> year2, List<Grade> year3) {
    final boolean SHOULD_THROW_EXCEPTION =
        isNull(year2, year3) || hasWrongNumberOfGrades(year2, year3) || containsFailGrade(year2, year3);

    // Throw exception when a list is null, does not contain four grades, or contains a fail grade
    if (SHOULD_THROW_EXCEPTION) {
      throw new IllegalArgumentException();
    }

    this.year2 = year2;
    this.year3 = year3;

    // Create level 5 and level 6 profiles
    createProfiles();
  }

  private boolean isNull(List<Grade> year2, List<Grade> year3) {
    return year2 == null || year3 == null;
  }

  private boolean hasWrongNumberOfGrades(List<Grade> year2, List<Grade> year3) {
    final int TOTAL_YEAR_2_GRADES = year2.size();
    final int TOTAL_YEAR_3_GRADES = year3.size();

    return TOTAL_YEAR_2_GRADES != 4 || TOTAL_YEAR_3_GRADES != 4;
  }

  private boolean containsFailGrade(List<Grade> year2, List<Grade> year3) {
    boolean containsFailGrade = false;
    List<Grade> list = new ArrayList<>();

    // Add all grades to one list
    list.addAll(year2);
    list.addAll(year3);

    // Find fail grade in list of grades
    for (Grade grade : list) {
      if (grade.classify() == Classification.Fail) {
        containsFailGrade = true;
      }
    }

    return containsFailGrade;
  }

  private void createProfiles() {
    // Add all grades to one list for the level 5 profile
    List<Grade> grades = new ArrayList<>();
    grades.addAll(year2);
    grades.addAll(year3);

    // Create level 5 and level 6 profiles
    level5 = new Profile(grades);
    level6 = new Profile(year3);
  }

  public Classification classify() {
    Classification classification = Classification.Discretion;

    if (haveSameClassification()) {
      classification = level5.classify();
    }
    else if (isBetter(level6, level5) && level6.isClear() && isClassAbove(level6, level5)) {
      classification = level6.classify();
    }
    else if (isBetter(level5, level6) && level5.isClear() && isClassAbove(level5, level6)) {
      classification = level5.classify();
    }

    return classification;
  }

  private boolean haveSameClassification() {
    final Classification LEVEL_5_CLASSIFICATION = level5.classify();
    final Classification LEVEL_6_CLASSIFICATION = level6.classify();

    return LEVEL_5_CLASSIFICATION == LEVEL_6_CLASSIFICATION;
  }

  private boolean isBetter(Profile profile1, Profile profile2) {
    final Classification PROFILE_1_CLASSIFICATION = profile1.classify();
    final Classification PROFILE_2_CLASSIFICATION = profile2.classify();

    // Get the index of the classification for both profiles
    final int PROFILE_1_CLASSIFICATION_INDEX = CLASSIFICATIONS.indexOf(PROFILE_1_CLASSIFICATION);
    final int PROFILE_2_CLASSIFICATION_INDEX = CLASSIFICATIONS.indexOf(PROFILE_2_CLASSIFICATION);

    // Return whether profile1 has a better classification than profile2
    return PROFILE_1_CLASSIFICATION_INDEX > PROFILE_2_CLASSIFICATION_INDEX;
  }

  private boolean isClassAbove(Profile profile1, Profile profile2) {
    final Classification PROFILE_1_CLASSIFICATION = profile1.classify();
    final Classification PROFILE_2_CLASSIFICATION = profile2.classify();

    // Get the index of the classification for both profiles
    final int PROFILE_1_CLASSIFICATION_INDEX = CLASSIFICATIONS.indexOf(PROFILE_1_CLASSIFICATION);
    final int PROFILE_2_CLASSIFICATION_INDEX = CLASSIFICATIONS.indexOf(PROFILE_2_CLASSIFICATION);

    // Return whether profile1 is one class above profile2
    return (PROFILE_1_CLASSIFICATION_INDEX - 1) == PROFILE_2_CLASSIFICATION_INDEX;
  }
}
