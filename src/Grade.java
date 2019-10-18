public class Grade {
  private final int points;

  public int getPoints() {
    return points;
  }

  public Grade(int p) throws IllegalArgumentException {
    if(p<1 || p>20)
      throw new IllegalArgumentException();
    points = p;
  }

  // Your additions/changes below this line

  public Classification classify() {
    if (points <= 4) {
      return Classification.First;
    }
    else if (points <= 8) {
      return Classification.UpperSecond;
    }
    else if (points <= 12) {
      return Classification.LowerSecond;
    }
    else if (points <= 16) {
      return Classification.Third;
    }

    return Classification.Fail;
  }

  public static Grade fromPercentage(int percentage) throws IllegalArgumentException {
    if (percentage <= 100 && percentage >= 79) {
      return new Grade(1);
    }
    else if (percentage <= 78 && percentage >= 76) {
      return new Grade(2);
    }
    else if (percentage <= 75 && percentage >= 73) {
      return new Grade(3);
    }
    else if (percentage <= 72 && percentage >= 70) {
      return new Grade(4);
    }
    else if (percentage <= 69 && percentage >= 67) {
      return new Grade(5);
    }
    else if (percentage <= 66 && percentage >= 65) {
      return new Grade(6);
    }
    else if (percentage <= 64 && percentage >= 62) {
      return new Grade(7);
    }
    else if (percentage <= 61 && percentage >= 60) {
      return new Grade(8);
    }
    else if (percentage <= 59 && percentage >= 57) {
      return new Grade(9);
    }
    else if (percentage <= 56 && percentage >= 55) {
      return new Grade(10);
    }
    else if (percentage <= 54 && percentage >= 52) {
      return new Grade(11);
    }
    else if (percentage <= 51 && percentage >= 50) {
      return new Grade(12);
    }
    else if (percentage <= 49 && percentage >= 47) {
      return new Grade(13);
    }
    else if (percentage <= 46 && percentage >= 45) {
      return new Grade(14);
    }
    else if (percentage <= 44 && percentage >= 42) {
      return new Grade(15);
    }
    else if (percentage <= 41 && percentage >= 40) {
      return new Grade(16);
    }
    else if (percentage <= 39 && percentage >= 35) {
      return new Grade(17);
    }
    else if (percentage <= 34 && percentage >= 30) {
      return new Grade(18);
    }
    else if (percentage <= 29 && percentage >= 0) {
      return new Grade(19);
    }
    else if (percentage == -1) {
      return new Grade(20);
    }

    throw new IllegalArgumentException();
  }
}
