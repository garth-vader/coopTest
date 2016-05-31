package lexingtonSCode;

import java.util.Comparator;

/**
 * Comparator Sorts by LastName in Reverse
 */
public class ReverseAlphabetLastNameComparator implements Comparator<Person> {

  ReverseAlphabetLastNameComparator() {
  }

  ;

  @Override
  public int compare(Person o1, Person o2) {
    return o2.getLastName().compareTo(o1.getLastName());
  }
}
