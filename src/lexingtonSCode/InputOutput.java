package lexingtonSCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Handles IO
 */
public class InputOutput {

  public static void main(String[] args) throws IOException {
    ArrayList<Person> aListOfP = new ArrayList<>();

    readFile(aListOfP, args[0], ", ");
    readFile(aListOfP, args[1], " \\| ");
    readFile(aListOfP, args[2], " ");
    writeFile(aListOfP);

  }

  public static void writeFile(ArrayList<Person> aListOfP) {
    try {
      FileWriter fw = new FileWriter("Gmoo_output.txt");
      Collections.sort(aListOfP);
      fw.write("My Output 1:\n");
      Collections.sort(aListOfP, new GenderFemaleToMaleComparator());
      printFile(aListOfP, fw);
      Collections.sort(aListOfP);
      fw.write("\nMy Output 2:\n");
      Collections.sort(aListOfP, new OldestToYoungestComparator());
      printFile(aListOfP, fw);
      Collections.sort(aListOfP);
      fw.write("\nMy Output 3:\n");
      Collections.sort(aListOfP, new ReverseAlphabetLastNameComparator());
      printFile(aListOfP, fw);

      fw.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private static void printFile(ArrayList<Person> aListOfP, FileWriter fw) throws IOException {
    for (int i = 0; i < aListOfP.size(); i++) {
      fw.write(aListOfP.get(i).toString().concat("\n"));
    }
  }

  private static void readFile(ArrayList<Person> aListOfP, String commaFile, String delim)
      throws IOException {
    try {
      BufferedReader br = new BufferedReader(new FileReader(commaFile));

      String fileRead = br.readLine();

      while (fileRead != null) {

        aListOfP.add(tokenize(fileRead, delim));

        fileRead = br.readLine();
      }
    } catch (FileNotFoundException fnfe) {
      System.out.print("file not found");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }


  private static boolean parseIsFemale(String s) {
    return s.toUpperCase().startsWith("F");
  }

  private static Person tokenize(String f, String delim) {
    Person p;
    String[] tokenize = f.split(delim);
    String lastName = tokenize[0];
    String firstName = tokenize[1];
    boolean isFemale;
    String color;
    LocalDate dateOfBirth;
    if (delim.equals(", ")) {
      isFemale = parseIsFemale(tokenize[2]);
      color = tokenize[3];
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
      dateOfBirth = LocalDate.parse(tokenize[4], formatter);
    } else {
      isFemale = parseIsFemale(tokenize[3]);
      if (delim.equals(" \\| ")) {
        color = tokenize[4];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
        dateOfBirth = LocalDate.parse(tokenize[5], formatter);
      } else {
        color = tokenize[5];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
        dateOfBirth = LocalDate.parse(tokenize[4], formatter);
      }
    }
    p = new PersonImpl.PersonImplBuilder().setLastName(lastName).setFirstName(firstName)
        .setIsFemale(isFemale).setDateOfBirth(dateOfBirth).setColor(color).createPersonImpl();
    return p;
  }
}
