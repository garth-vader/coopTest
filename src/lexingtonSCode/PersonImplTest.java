package lexingtonSCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDate;

/**
 * Test class for PersonImpl
 */
public class PersonImplTest {

  LocalDate d1 = LocalDate.of(1990, 1, 31);
  Person p1 = new PersonImpl.PersonImplBuilder()
      .setColor("Blue").setDateOfBirth(d1).setFirstName("Bob")
      .setLastName("Builder").setIsFemale(false).createPersonImpl();
  Person p2 = new PersonImpl.PersonImplBuilder()
      .setColor("Pink").setDateOfBirth(d1).setFirstName("Jenna")
      .setLastName("Jones").setIsFemale(true).createPersonImpl();

  @Test
  public void isFemaleWorks() {
    assertFalse(p1.isFemale());
    assertTrue(p2.isFemale());
  }

  @Test
  public void getDOBStringToStringWorks() {
    assertEquals("1/31/1990", p1.getDOBStringToString());
  }

  @Test
  public void toStringWorks() {
    assertEquals("Builder Bob Male 1/31/1990 Blue", p1.toString());
    assertEquals("Jones Jenna Female 1/31/1990 Pink", p2.toString());
  }

  @Test
  public void compareToWorks() {
    assertTrue(p1.compareTo(p2) < 0);
    assertTrue(p2.compareTo(p1) > 0);
    assertTrue(p1.compareTo(p1) == 0);
  }

  @Test
  public void equalsWorks() {
    assertFalse(p1.equals(p2));
    assertFalse(p2.equals(p1));
    assertTrue(p1.equals(p1));
  }
}