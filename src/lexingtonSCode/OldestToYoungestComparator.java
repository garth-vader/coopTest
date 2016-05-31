package lexingtonSCode;

import java.util.Comparator;

/**
 * Comparator Sorts from Oldest To Youngest
 */
public final class OldestToYoungestComparator implements Comparator<Person> {

  OldestToYoungestComparator() {
  }

  @Override
  public int compare(Person o1, Person o2) {
    return o1.getDOB().compareTo(o2.getDOB());
  }
}
