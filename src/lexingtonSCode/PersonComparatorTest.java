package lexingtonSCode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Testing Comparators
 */
public class PersonComparatorTest {

  Person
      p1 =
      new PersonImpl.PersonImplBuilder().setLastName("Hingis")
          .setIsFemale(true).setDateOfBirth(LocalDate.of(1979, 4, 2)).createPersonImpl();
  Person
      p2 =
      new PersonImpl.PersonImplBuilder().setLastName("Kelly").setIsFemale(true)
          .setDateOfBirth(LocalDate.of(1959, 7, 12)).createPersonImpl();
  Person
      p3 =
      new PersonImpl.PersonImplBuilder().setLastName("Kournikova")
          .setIsFemale(true).setDateOfBirth(LocalDate.of(1975, 6, 3)).createPersonImpl();
  Person
      p4 =
      new PersonImpl.PersonImplBuilder().setLastName("Seles")
          .setIsFemale(true).setDateOfBirth(LocalDate.of(1973, 2, 12)).createPersonImpl();
  Person
      p5 =
      new PersonImpl.PersonImplBuilder().setLastName("Abercrombie")
          .setIsFemale(false).setDateOfBirth(LocalDate.of(1943, 2, 13)).createPersonImpl();
  Person
      p6 =
      new PersonImpl.PersonImplBuilder().setLastName("Bishop")
          .setIsFemale(false).setDateOfBirth(LocalDate.of(1967, 3, 23)).createPersonImpl();
  Person
      p7 =
      new PersonImpl.PersonImplBuilder().setLastName("Bouillon")
          .setIsFemale(false).setDateOfBirth(LocalDate.of(1975, 6, 3)).createPersonImpl();
  Person
      p8 =
      new PersonImpl.PersonImplBuilder().setLastName("Smith")
          .setIsFemale(false).setDateOfBirth(LocalDate.of(1985, 3, 3)).createPersonImpl();
  Person
      p9 =
      new PersonImpl.PersonImplBuilder().setLastName("Bonk")
          .setIsFemale(false).setDateOfBirth(LocalDate.of(1975, 6, 3)).createPersonImpl();


/*  Hingis Martina Female 4/2/1979 Green
  Kelly Sue Female 7/12/1959 Pink
  Kournikova Anna Female 6/3/1975 Red
  Seles Monica Female 12/2/1973 Black
  Abercrombie Neil Male 2/13/1943 Tan
  Bishop Timothy Male 4/23/1967 Yellow
  Bouillon Francis Male 6/3/1975 Blue
  Smith Steve Male 3/3/1985 Red
  Bonk Radek Male 6/3/1975 Green*/

  ArrayList<Person> unsortedL = new ArrayList<>();
  ArrayList<Person> sortedByGenderL = new ArrayList<>();
  ArrayList<Person> sortedByAgeL = new ArrayList<>();
  ArrayList<Person> sortedReverseL = new ArrayList<>();

  Comparator<Person> genderComparator = new GenderFemaleToMaleComparator();
  Comparator<Person> ageComparator = new OldestToYoungestComparator();
  Comparator<Person> lastNameComparator = new ReverseAlphabetLastNameComparator();

  @Before
  public void setup() {
    unsortedL.add(p1);
    unsortedL.add(p3);
    unsortedL.add(p5);
    unsortedL.add(p2);
    unsortedL.add(p9);
    unsortedL.add(p6);
    unsortedL.add(p7);
    unsortedL.add(p8);
    unsortedL.add(p4);

    sortedByGenderL.add(p1);
    sortedByGenderL.add(p2);
    sortedByGenderL.add(p3);
    sortedByGenderL.add(p4);
    sortedByGenderL.add(p5);
    sortedByGenderL.add(p6);
    sortedByGenderL.add(p9);
    sortedByGenderL.add(p7);
    sortedByGenderL.add(p8);

    sortedByAgeL.add(p5);
    sortedByAgeL.add(p2);
    sortedByAgeL.add(p6);
    sortedByAgeL.add(p4);
    sortedByAgeL.add(p9);
    sortedByAgeL.add(p7);
    sortedByAgeL.add(p3);
    sortedByAgeL.add(p1);
    sortedByAgeL.add(p8);

    sortedReverseL.add(p8);
    sortedReverseL.add(p4);
    sortedReverseL.add(p3);
    sortedReverseL.add(p2);
    sortedReverseL.add(p1);
    sortedReverseL.add(p7);
    sortedReverseL.add(p9);
    sortedReverseL.add(p6);
    sortedReverseL.add(p5);

  }

  @Test
  public void testGenderFemaleToMaleComparator() {
    assertFalse(sortedByGenderL.equals(unsortedL));
    Collections.sort(unsortedL);
    Collections.sort(unsortedL, genderComparator); //Sorting
    assertArrayEquals(sortedByGenderL.toArray(), unsortedL.toArray());
  }

  @Test
  public void testOldestToYoungestComparator() {
    assertFalse(sortedByAgeL.equals(unsortedL));
    Collections.sort(unsortedL);
    Collections.sort(unsortedL, ageComparator); //Sorting
    assertArrayEquals(sortedByAgeL.toArray(), unsortedL.toArray());
  }

  @Test
  public void testReverseLastNameComparator() {
    assertFalse(sortedReverseL.equals(unsortedL));
    Collections.sort(unsortedL, lastNameComparator); //Sorting
    assertArrayEquals(sortedReverseL.toArray(), unsortedL.toArray());
  }

}
