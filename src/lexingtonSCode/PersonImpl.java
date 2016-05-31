package lexingtonSCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Implementation of IPerson non mutable
 */
public final class PersonImpl implements Person {

  private final String lastName;
  private final String firstName;
  private final boolean isFemale;
  private final LocalDate dateOfBirth;
  private final String color;
  /* INVARIANT
   *  lastName != null
   *  firstName != nulls
   *  dateOfBirth < LocalDate.MAX && dateOfBirth > LocalDate.MIN
   */

  /**
   * Private Constructor
   */
  private PersonImpl(String lastName, String firstName, boolean isFemale,
                     LocalDate dateOfBirth, String color) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.isFemale = isFemale;
    this.dateOfBirth = dateOfBirth;
    this.color = color;
  }

  /**
   * Compares lastName alphabetically This before that
   *
   * @param {@code Person} comparing
   * @return int
   */
  @Override
  public int compareTo(Person o) {
    return getLastName().compareTo(o.getLastName());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    Person p = (Person) o;
    return p.isFemale() == isFemale() &&
           p.getLastName().equals(getLastName()) &&
           p.getFirstName().equals(getFirstName()) &&
           p.getColor().equals(getColor()) &&
           p.getDOBStringToString().equals(getDOBStringToString());
  }

  @Override
  public String toString() {
    return new StringBuilder(40).append(getLastName()).append(" ")
        .append(getFirstName()).append(" ")
        .append(getGenderToString()).append(" ")
        .append(getDOBStringToString()).append(" ")
        .append(color).toString();
  }

  @Override
  public LocalDate getDOB() {
    return dateOfBirth;
  }

  @Override
  public boolean isFemale() {
    return isFemale;
  }

  @Override
  public String getDOBStringToString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/uuuu");
    return dateOfBirth.format(format);
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public String getGenderToString() {
    if (isFemale()) {
      return "Female";
    } else {
      return "Male";
    }
  }

  @Override
  public String getColor() {
    return color;
  }

  /**
   * Nested Builder class
   */
  public static class PersonImplBuilder {

    static private String lastName;
    static private String firstName;
    static private boolean isFemale = true;
    static private LocalDate dateOfBirth = LocalDate.MAX;
    static private String color = "";

    public PersonImplBuilder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public PersonImplBuilder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public PersonImplBuilder setIsFemale(boolean isFemale) {
      this.isFemale = isFemale;
      return this;
    }

    public PersonImplBuilder setDateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public PersonImplBuilder setColor(String color) {
      this.color = color;
      return this;
    }

    public Person createPersonImpl() {
      return new PersonImpl(lastName, firstName, isFemale, dateOfBirth, color);
    }
  }
}
