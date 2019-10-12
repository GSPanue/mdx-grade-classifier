import java.util.List;

public class Profile {
	// Your additions/changes below this line
	private List<Grade> grades;
	private double firstClassPercentage;
	private double upperSecondClassPercentage;
	private double lowerSecondClassPercentage;
	private double thirdClassPercentage;

	public Profile(List<Grade> grades) {
		final boolean SHOULD_THROW_EXCEPTION = isNull(grades) || isEmpty(grades) || containsFailGrade(grades);

		// Throw exception when list is null, empty, or has fail grade
		if (SHOULD_THROW_EXCEPTION) {
			throw new IllegalArgumentException();
		}

		this.grades = grades;

		// Create percentage of each class
		createClassPercentages();
	}

	private boolean isNull(List<Grade> grades) {
		return grades == null;
	}

	private boolean isEmpty(List<Grade> grades) {
		return grades.isEmpty();
	}

	private boolean containsFailGrade(List<Grade> grades) {
		boolean containsFailGrade = false;

		// Find fail grade in list of grades
		for (Grade grade : grades) {
			if (grade.classify() == Classification.Fail) {
				containsFailGrade = true;
			}
		}

		return containsFailGrade;
	}

	private void createClassPercentages() {
		int totalFirstClassGrades = 0;
		int totalUpperSecondClassGrades = 0;
		int totalLowerSecondClassGrades = 0;
		int totalThirdClassGrades = 0;

		// Total the classes
		for (Grade grade : grades) {
			switch(grade.classify()) {
				case First:
					totalFirstClassGrades++;
					break;
				case UpperSecond:
					totalUpperSecondClassGrades++;
					break;
				case LowerSecond:
					totalLowerSecondClassGrades++;
					break;
				case Third:
					totalThirdClassGrades++;
			}
		}

		// Convert total of each class to a percentage
		firstClassPercentage = toPercentage(totalFirstClassGrades);
		upperSecondClassPercentage = toPercentage(totalUpperSecondClassGrades);
		lowerSecondClassPercentage = toPercentage(totalLowerSecondClassGrades);
		thirdClassPercentage = toPercentage(totalThirdClassGrades);
	}

	private double toPercentage(int total) {
		final double TOTAL_NUMBER_OF_GRADES = grades.size();

		return (total / TOTAL_NUMBER_OF_GRADES) * 100;
	}

	public Classification classify() {
		final double FIRST_CLASS = firstClassPercentage;
		final double UPPER_SECOND_CLASS = upperSecondClassPercentage;
		final double LOWER_SECOND_CLASS = lowerSecondClassPercentage;

		if (FIRST_CLASS >= 50) {
			return Classification.First;
		}
		else if (UPPER_SECOND_CLASS >= 50) {
			return Classification.UpperSecond;
		}
		else if (LOWER_SECOND_CLASS >= 50) {
			return Classification.LowerSecond;
		}

		return Classification.Third;
	}

	public boolean isClear() {
		final Classification CLASSIFICATION = classify();
		final boolean IS_FIRST_CLASS = CLASSIFICATION == Classification.First;
		final boolean IS_UPPER_SECOND_CLASS = CLASSIFICATION == Classification.UpperSecond;

		if (IS_FIRST_CLASS || IS_UPPER_SECOND_CLASS) {
			// Profile is clear when the third class grades in the profile are no more than 25%
			return thirdClassPercentage <= 25;
		}

		return false;
	}
}
