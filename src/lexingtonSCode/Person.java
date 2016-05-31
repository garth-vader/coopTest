package lexingtonSCode;

import java.time.LocalDate;

/**
 * interface for Person Default sorting for comparable is in lexicographical for the lastName
 */
public interface Person extends Comparable<Person> {

  /**
   * Return DOB
   *
   * @return LocalDate
   */
  LocalDate getDOB();

  /**
   * Returns if IPerson is female
   *
   * @return true if IPerson is female
   */
  boolean isFemale();

  /**
   * Return Date of Birth in String Form
   *
   * @return String
   */
  String getDOBStringToString();

  /**
   * Returns first Name
   *
   * @return String
   */
  String getFirstName();

  /**
   * Returns last name
   *
   * @return String
   */
  String getLastName();

  /**
   * returns gender
   *
   * @return String
   */
  String getGenderToString();

  /**
   * return color
   *
   * @return String
   */
  String getColor();
}

