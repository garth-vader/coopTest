package lexingtonSCode;

import java.util.Comparator;

/**
 * Comparator that sorts female to male
 */
public final class GenderFemaleToMaleComparator implements Comparator<Person> {

  GenderFemaleToMaleComparator() {
  }

  @Override
  public int compare(Person o1, Person o2) {
    if (o1.isFemale() && !o2.isFemale()) {
      return -1;
    } else if (!o1.isFemale() && o2.isFemale()) {
      return 1;
    } else {
      return 0;
    }
  }
}
